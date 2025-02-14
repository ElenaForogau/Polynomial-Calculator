package org.example;
import operatii.Operatii;
import org.junit.*;
import polinom.Polinom;

import static org.junit.Assert.assertEquals;

public  class AppTest {
        Polinom p1=new Polinom("x^2+1");
        Polinom p2=new Polinom("x^2");

        @Test
        public void TestAdunare()
        {
            Operatii op=new Operatii();
            Polinom rez = new Polinom("2.0x^2+1");
            Polinom rezint=op.adunare(p1,p2);
            assertEquals(rezint.toString(),rez.toString());
            System.out.println("Adunarea s-a efectuat corect");

        }

       @Test
        public void TestScadere()
       {
           Operatii op=new Operatii();
           Polinom rez = new Polinom("+1");
           Polinom rezint=op.scadere(p1,p2);
           assertEquals(rezint.toString(),rez.toString());
           System.out.println("Scaderea s-a efectuat corect");

       }

       @Test
        public void TestInmutire()
       {
           Operatii op=new Operatii();
           Polinom rez = new Polinom("x^4+x^2");
           Polinom rezint=op.inmultire(p1,p2);
           assertEquals(rezint.toString(),rez.toString());
           System.out.println("Inmultirea s-a efectuat corect");
       }

       @Test
        public void TestImpartire()
       {
           Operatii op=new Operatii();
           Polinom rez = new Polinom("");
           Polinom rezint=op.impartire(p1,p2);
           assertEquals(rezint.toString(),rez.toString());
           System.out.println("Impartirea s-a efectuat corect");
       }

       @Test
        public void TestDerivare()
       {
           Operatii op=new Operatii();
           Polinom rez = new Polinom("2x");
           Polinom rezint=op.derivare(p1);
           assertEquals(rezint.toString(),rez.toString());
           System.out.println("Derivarea s-a efectuat corect");
       }

       @Test
       public void TestIntegrare()
       {
           Operatii op=new Operatii();
           Polinom rez = new Polinom("0.33x^3");
           Polinom rezint=op.integrare(p2);
           assertEquals(rezint.toString(),rez.toString());
           System.out.println("Integrarea s-a efectuat corect");
       }

}

