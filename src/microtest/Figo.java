package microtest;

import java.util.Scanner;

public class Figo
{
    public static void main(String[] args)
    {
        new Figo();
    }

    public Figo()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un numero positivo: ");
        mostrar_lista(figonacci(sc.nextInt()));
        sc.close();
    }
    public void mostrar_lista(int[] lista)
    {
        for(int n:lista)
        {
            System.out.println(n);
        }
    }

    public int[] figonacci(int n)
    {
        int suma=0;
        int anterior=1;
        if(n>0)
        {
            int[] lista = new int[n];

            for(int i=0;i<n;i++)
            {
                lista[i]=suma;
                suma=suma+anterior;
                anterior=lista[i];
            }
            return lista;
        }
        return new int[1];
    }
}
