package org.example.Lacasa_Diego_20240306_2DAM_EXAMEN_4;

public class Minusculas implements Runnable {
    // Variables de instancia
    private final Buzon a_Buzon;

    public Minusculas(Buzon p_Buzon) {
        a_Buzon = p_Buzon;
    }

    @Override
    public void run() {
        // Variables
        int l_LetrasMinusculas = 0;
        String l_UltimaLetra = "";

        // Bucle infinito
        while (true) {
            // Se adquiere el semaforo de las minúsculas
            try {
                a_Buzon.a_SemaforoMinusculas.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // El valor de la variable indicara hasta que punto de la frase hay que escribir
            l_LetrasMinusculas = a_Buzon.a_LetrasMinusculas;

            // Se comprueba si se esta pasando la frase a mayúsculas
            if (a_Buzon.a_FraseAMayusculas) {
                /** SE ESTA PASANDO LA FRASE A MAYUSCULAS **/

                // Se imprime en minúsculas la parte de la frase que quede por imprimir (segunda parte)
                System.out.println(a_Buzon.a_Frase.substring(a_Buzon.a_LetrasMayusculas, l_LetrasMinusculas).toLowerCase());

                // Se aumenta el númeo de letras mayúsculas escritas
                a_Buzon.a_LetrasMayusculas++;

                // Dormir el hilo durante 500 milisegundos
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                // Se comprueba si ya esta toda la frase en mayúsculas
                if (a_Buzon.a_LetrasMayusculas == a_Buzon.a_Frase.length()) {
                    // Ahora la frase se empezara a pasar a minúsculas
                    a_Buzon.a_FraseAMayusculas = false;
                    // Se resetea el valor de letrasMinusculas para evitar problemas
                    a_Buzon.a_LetrasMinusculas = 0;
                    // Se ejecuta el codigo de las minúsculas dos veces
                    a_Buzon.a_SemaforoMinusculas.release();
                } else {
                    // Como aun falta para completar la frse en mayúsculas, se vuelve a liberar su semaforo
                    a_Buzon.a_SemaforoMayusculas.release();
                }
            } else {
                /** SE ESTA PASANDO LA FRASE A MINUSCULAS **/

                // Se comprueba que la ultima letra a escribir no sea un espacio
                l_UltimaLetra = String.valueOf(a_Buzon.a_Frase.charAt(l_LetrasMinusculas));

                if (!l_UltimaLetra.equals(" ")) {
                    // Se imprimen la cantidad de minúsculas que contenga la frase (primera parte) y se libera el semáforo contrario
                    System.out.print(a_Buzon.a_Frase.substring(0, l_LetrasMinusculas).toLowerCase());
                    a_Buzon.a_SemaforoMayusculas.release();
                } else {
                    // Para evitar imprimir una linea sin cambios, se incrementa en 1 el numero de letras escritas y se vuelve a liberar el mismo semáforo
                    a_Buzon.a_LetrasMinusculas++;
                    a_Buzon.a_SemaforoMinusculas.release();
                }
            }
        }
    }
}
