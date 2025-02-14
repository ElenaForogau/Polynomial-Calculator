package org.example;

import GUI.View;
import operatii.Operatii;
import polinom.Polinom;

import javax.swing.*;
import java.awt.*;


public class App 
{
    public static void main( String[] args )
    {
        View window = new View();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Calculator Polinoame");
        window.setSize(400, 400);
        window.setVisible(true);
        window.getContentPane().setBackground(new Color(253, 191, 183));


        //un exemplu de utilizare a operatiilor
        Polinom p1 = new Polinom("x^2-1");
        Polinom p2 = new Polinom("x+3");

        Operatii op = new Operatii();

        Polinom suma = op.adunare(p1, p2);
        System.out.println("Suma polinoamelor p1 si p2 este: " + suma);

        Polinom diferenta = op.scadere(p1, p2);
        System.out.println("Diferenta polinoamelor p1 si p2 este: " + diferenta);

        Polinom produs = op.inmultire(p1, p2);
        System.out.println("Produsul polinoamelor p1 si p2 este: " + produs);

        Polinom derivata = op.derivare(p1);
        System.out.println("Derivata polinomului p1 este: " + derivata);

        Polinom integrala = op.integrare(p1);
        System.out.println("Integrala polinomului p1 este: " + integrala);

    }
}
