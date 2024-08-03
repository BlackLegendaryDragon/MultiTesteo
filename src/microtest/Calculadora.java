package microtest;

import javax.swing.*;

public class Calculadora {
    public static void main(String[] args) {
        int operacion;
        double sumando1, sumando2, resultado;
        boolean concretado = false;

        operacion = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese su operacion\n 1 suma, 2 resta, 3 multiplicacion\n4 divicion, 5 raiz cuadrada"));

        switch(operacion){
            case 1:
                sumando1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese numero"));
                sumando2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese otro numero"));
                resultado = sumando1 + sumando2;
                JOptionPane.showMessageDialog(null,"Resultado: " + resultado);
                concretado = true;
            break;
            case 2:
                sumando1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese numero"));
                sumando2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese otro numero"));
                resultado = sumando1 - sumando2;
                JOptionPane.showMessageDialog(null,"Resultado: " + resultado);
                concretado = true;
            break;
            case 3:
                sumando1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese numero"));
                sumando2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese otro numero"));
                resultado = sumando1 * sumando2;
                JOptionPane.showMessageDialog(null,"Resultado: " + resultado);
                concretado = true;
            break;
            case 4:
                sumando1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese numero"));
                sumando2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese otro numero"));
                resultado = sumando1 / sumando2;
                JOptionPane.showMessageDialog(null,"Resultado: " + resultado);
                concretado = true;
            break;
            case 5:
                sumando1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero"));
                resultado = Math.sqrt(sumando1);
                JOptionPane.showMessageDialog(null,"Resultado: " + resultado);
                concretado = true;
            default:
                if(!concretado)
                    JOptionPane.showConfirmDialog(null, "No se a logrado seleccionar un numero correcto");

        }

    }
}
