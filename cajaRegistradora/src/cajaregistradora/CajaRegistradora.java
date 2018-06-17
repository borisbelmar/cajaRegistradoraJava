/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajaregistradora;
import java.util.*;
/**
 *
 * @author Boris Belmar
 */
public class CajaRegistradora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Variables Globales
        int columnas = 5;
        int filas = 0;
        int precio = 0;
        int cantidad = 0;
        int neto = 0;
        int totalNeto = 0;
        double iva = 0;
        int ivaRnd = 0;
        int totalIVA = 0;
        int total = 0;
        int totalPagar = 0;
        int pago = 0;
        int vuelto = 0;
        
        Scanner entrada = new Scanner(System.in);
        
        // Código
        
        System.out.println("Bienvenido a la Caja Registradora");
        System.out.println("Por favor, ingrese la cantidad de productos diferentes a pagar:");
        filas = entrada.nextInt();
        int[][] caja = new int[filas][columnas];
        System.out.println("-----");
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                switch(j) {
                    case 0:
                        System.out.println("Ingrese precio del producto:");
                        precio = entrada.nextInt();
                        caja[i][j] = precio;
                        break;
                    case 1:
                        System.out.println("Ingrese la cantidad:");
                        cantidad = entrada.nextInt();
                        if (cantidad <= 0) {
                            do {
                                System.out.println("Ha ingresado una cantidad inválida de productos, ingrese nuevamente");
                                cantidad = entrada.nextInt();
                            } while (cantidad <= 0);
                        }
                        caja[i][j] = cantidad;
                        break;
                    case 2:
                        neto = precio * cantidad;
                        caja[i][j] = neto;
                        break;
                    case 3:
                        iva = neto * 0.19;
                        Math.round(iva);
                        ivaRnd = (int)iva;
                        caja[i][j] = ivaRnd;
                        break;
                    case 4:
                        total = neto + ivaRnd;
                        caja[i][j] = total;
                        break;
                }
            }
            if (cantidad == 1) {
                System.out.println("Ha ingresado " + cantidad + " producto que da un subtotal de $" + neto + " neto. Se debe considerar un IVA de $" + ivaRnd);
            }
            else {
                System.out.println("Ha ingresado " + cantidad + " productos que da un subtotal de $" + neto + " neto. Se debe considerar un IVA de $" + ivaRnd);
            }
            System.out.println("-----");
        }
        
        for (int i = 0; i < filas; i++) {
            totalNeto += caja[i][2];
        }
        System.out.println("El total Neto corresponde a $" + totalNeto);
        
        for (int i = 0; i < filas; i++) {
            totalIVA += caja[i][3];
        }
        System.out.println("El IVA total corresponde a $" + totalIVA);
        
        for (int i = 0; i < filas; i++) {
            totalPagar += caja[i][4];
        }
        System.out.println("El total a pagar corresponde a $" + totalPagar);
        
        System.out.println("-----");
        
        System.out.println("¿Con cuanto paga?");
        pago = entrada.nextInt();
        if (pago < totalPagar) {
            do {
                System.out.println("El monto ingresado no alcanza para pagar, ingreselo nuevamente");
                pago = entrada.nextInt();
            } while (pago < totalPagar); 
        }
        vuelto = pago - totalPagar;
        System.out.println("El vuelto es $" + vuelto + " pesos");
    }
    
}
