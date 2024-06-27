package microtest;

public class Diagonal {
    public static void main(String[] args)
    {
        new Diagonal();
    }
    public Diagonal()
    {
        int[][] matrix3x3 = {{1, 0, 2}, {1, 0, 1}, {2, 0, 1}};
        int[][] matrix4x4 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        System.out.println(sumarDiag(matrix3x3,true));
        System.out.println(sumarDiag(matrix3x3,false));

        System.out.println(sumarDiag(matrix4x4,true));
        System.out.println(sumarDiag(matrix4x4,false));
    }

    public int sumarDiag(int[][] entrada,boolean izqDer)
    {
        int suma = 0;
        if(izqDer)
        {
            for(int i=0;i<entrada.length;i++)
            {
                suma+=entrada[i][i];
            }
            return suma;
        }else
        {
            int aux = 0;
            for(int i=entrada.length-1;i>=0;i--)
            {
                suma+=entrada[i][aux];
                aux++;
            }
            return suma;
        }
    }
}
