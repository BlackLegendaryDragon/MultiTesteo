package loteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Loteria {

    private ArrayList<Integer> pelotas = new ArrayList<>();
    private int[] numeros = new int[4];
    public static void main(String[] args) {
        new Loteria();
    }

    public Loteria(){
        generar(pelotas);
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero que quiere apostar...");



        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextInt();
        }
        sc.close();
        //System.out.println(comparar(numeros,jugar()));
        //System.out.println(Arrays.toString(jugar()));
        System.out.println("despues de "+intentar_hasta_ganar()+" lograste ganar");
    }

    public void generar(ArrayList<Integer> entrada){
        for (int i = 0; i < 48; i++) {
            entrada.add(i, i+1);
        }
    }

    public int[] jugar(){
        int[] lista = new int[4];
        for(int i=0;i<lista.length;i++){
            int seleccionado = (int)(Math.random()*pelotas.size());
            lista[i]=pelotas.get(seleccionado);
            pelotas.remove(seleccionado);
        }
        return lista;
    }

    public boolean comparar(int[] eleccion, int[] resultado){
        return Arrays.equals(eleccion, resultado);
    }

    public int intentar_hasta_ganar(){
        int intentos = 0;
        int[] jugada=jugar();
        while(!comparar(jugada=jugar(), numeros)){
            System.out.println();
            System.out.println(Arrays.toString(jugada));
            generar(pelotas);
            System.out.println("Intento..."+intentos);
            intentos++;
        }
        return intentos;
    }

}
