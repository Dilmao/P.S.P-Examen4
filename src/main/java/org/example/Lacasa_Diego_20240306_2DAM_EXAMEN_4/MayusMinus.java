package org.example.Lacasa_Diego_20240306_2DAM_EXAMEN_4;

public class MayusMinus {
    public static void main(String[] args) {
        // Creación del buzon que compartirar ambos codigos
        Buzon l_Buzon = new Buzon();

        // Se crean los constructores de ambos codigos
        Mayusculas l_Mayusculas = new Mayusculas(l_Buzon);
        Minusculas l_Minusculas = new Minusculas(l_Buzon);

        // Se crean los hilos que ejecutaran ambos codigos
        Thread l_HiloMayusculas = new Thread(l_Mayusculas);
        Thread l_HiloMinuscilas = new Thread(l_Minusculas);

        // Se ejecutan los hilos creados
        l_HiloMayusculas.start();
        l_HiloMinuscilas.start();
    }
}