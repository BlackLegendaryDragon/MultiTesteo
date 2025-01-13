package microtest;

import java.util.Arrays;

public class MezclaTres {
    public static void main(String[] args) {
        String[] prueba = {"Hola","como","estas"};
        avanzar(prueba);
    }
    public static void avanzar(String[] palabras) {
        int largo = palabras.length;
        for(String palabra:palabras) {
            String aux = palabras[0];
            for (int i = 0; i < largo; i++) {
                if (i < largo - 1) {
                    palabras[i] = palabras[i + 1];
                }
            }
            palabras[largo - 1] = aux;
            System.out.println(Arrays.toString(palabras));
        }
    }
    public void mezclar(String[] palabras) {
        
    }
}
