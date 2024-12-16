
package proyectoud3;

import java.util.Arrays;
import java.util.Scanner;

public class ProyectoUD3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce la cantidad de números a ingresar: ");
        int n = scanner.nextInt();

        int[] tabla = new int[n];
        System.out.println("Introduce los números:");
        for (int i = 0; i < n; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            tabla[i] = scanner.nextInt();
        }

        int numPares = 0, numImpares = 0;
        for (int num : tabla) {
            if (num % 2 == 0) {
                numPares++;
            } else {
                numImpares++;
            }
        }

        int[] pares = new int[numPares];
        int[] impares = new int[numImpares];

        int iPares = 0, iImpares = 0;
        for (int num : tabla) {
            if (num % 2 == 0) {
                pares[iPares++] = num;
            } else {
                impares[iImpares++] = num;
            }
        }

        Arrays.sort(pares);
        Arrays.sort(impares);

        System.out.println("Tabla de números pares ordenada: " + Arrays.toString(pares));
        System.out.println("Tabla de números impares ordenada: " + Arrays.toString(impares));

        System.out.print("Introduce un número para insertar: ");
        int nuevoNumero = scanner.nextInt();

        if (nuevoNumero % 2 == 0) {
            pares = insertarEnArrayOrdenado(pares, nuevoNumero);
            System.out.println("Tabla de pares después de insertar: " + Arrays.toString(pares));
        } else {
            impares = insertarEnArrayOrdenado(impares, nuevoNumero);
            System.out.println("Tabla de impares después de insertar: " + Arrays.toString(impares));
        }
    }

    private static int[] insertarEnArrayOrdenado(int[] array, int nuevoNumero) {
        int[] nuevoArray = new int[array.length + 1];
        int i = 0;
        while (i < array.length && array[i] < nuevoNumero) {
            nuevoArray[i] = array[i];
            i++;
        }
        nuevoArray[i] = nuevoNumero;
        while (i < array.length) {
            nuevoArray[i + 1] = array[i];
            i++;
        }
        return nuevoArray;
    }
}
