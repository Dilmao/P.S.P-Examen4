package org.example.Lacasa_Diego_20240306_2DAM_EXAMEN_4;

import java.util.concurrent.Semaphore;

public class Buzon {
    // Tokens iniciales de ambos codigos
    public static final int TOKENS_MAYUSCULAS = 1;
    public static final int TOKENS_MINUSCULAS = 0;

    // Variables para la frase y la cantidad de mayúsculas/minúsculas que se han escrito
    final String a_Frase = "en un lugar de la mancha";
    int a_LetrasMayusculas = 0;
    int a_LetrasMinusculas = a_Frase.length();

    // Booleano para saber si se esta transicionando a la frase en mayusculas o a la frase en minusculas
    boolean a_FraseAMayusculas = true;

    // Semaforos para ambas clases
    final Semaphore a_SemaforoMayusculas = new Semaphore(TOKENS_MAYUSCULAS);
    final Semaphore a_SemaforoMinusculas = new Semaphore(TOKENS_MINUSCULAS);
}
