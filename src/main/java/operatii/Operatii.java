package operatii;

import polinom.Polinom;

import java.util.Map;

public class Operatii {

    /*
    entrySet - returneaza o colectie de perechi cheie-valoare, reprezentand toate intrarile din map
    getKey - returneaza cheia asociata cu intrarea curenta
    getValue - returneaza valoarea asociata cu intrarea curenta
    */

    //se parcurg coeficientii ambelor polinoame, se adauga termenii de aceeasi putere
    //si se pasteraza restul termenilor
    public Polinom adunare(Polinom p1, Polinom p2)
    {
        Polinom rez= new Polinom();

        for (Map.Entry<Integer, Double> entry : p1.getPolynomial().entrySet()) {
            int power = entry.getKey();
            double coef = entry.getValue();
            rez.setCoefficient(power, coef);
        }

        for (Map.Entry<Integer, Double> entry : p2.getPolynomial().entrySet()) {
            int power = entry.getKey();
            double coef = entry.getValue();
            double resultCoeff = rez.getCoefficient(power);
            rez.setCoefficient(power, resultCoeff + coef);
        }
        return rez;
    }

//se parcurg coeficientii ambelor polinoame, se adauga termenii de aceeasi putere
    //si se pastreaza restul termenilor
    public Polinom scadere(Polinom p1, Polinom p2)
    {
        Polinom rez= new Polinom();

        for (Map.Entry<Integer, Double> entry : p1.getPolynomial().entrySet()) {
            int power = entry.getKey();
            double coef = entry.getValue();
            rez.setCoefficient(power, coef);
        }

        for (Map.Entry<Integer, Double> entry : p2.getPolynomial().entrySet()) {
            int power = entry.getKey();
            double coef = entry.getValue();
            double resultCoeff = rez.getCoefficient(power);
            rez.setCoefficient(power, resultCoeff - coef);
        }

        return rez;
    }

    //se parcurg termrnii ambelor polinoame si se calculeaza puterea si coeficientul rezultat
    //prin inmultirea coeficientilor si adunarea puterilor
    //coeficientul rezultat se adauga la coeficientul deja existent cu aceeasi putere
    public Polinom inmultire(Polinom p1, Polinom p2)
    {
        Polinom rez = new Polinom();
        for (Map.Entry<Integer, Double> entry1 : p1.getPolynomial().entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : p2.getPolynomial().entrySet()) {
                int power = entry1.getKey() + entry2.getKey();
                double coef = entry1.getValue() * entry2.getValue();
                double resultCoeff = rez.getCoefficient(power);
                rez.setCoefficient(power, resultCoeff + coef);
            }
        }
        return rez;
    }

    public Polinom impartire (Polinom p1, Polinom p2)
    {
        Polinom rez = new Polinom();

        return rez;
    }

    //se parcurg coeficientii polinomului si se calculeaza puterea si coeficientul
    //rezultat prin aplicarea formulei pt derivata unui polinom
    public Polinom derivare(Polinom p)
    {
        Polinom rez= new Polinom();

        for (Map.Entry<Integer, Double> entry : p.getPolynomial().entrySet()) {
            int power = entry.getKey();
            double coef = entry.getValue();
            if (power > 0) {
                rez.setCoefficient(power - 1, coef * power);
            }
        }

        return rez;
    }

    // se parcurg coeficientii polinomului si se calculeaza puterea si coeficientul
    //rezultat prin aplicarea formulei pt integrarea unui polinom
    //pt termenii constanti puterea este crescuta cu 1 si coeficientul este adaugat ca termen al polinomului rezultat
    public Polinom integrare(Polinom p)
    {
        Polinom rez= new Polinom();
        double coef;
        int power;

        for (Map.Entry<Integer, Double> entry : p.getPolynomial().entrySet()) {
            power = entry.getKey();
            coef = entry.getValue();

            //integram fiecare termen
            if (power == 0) {
                //daca puterea e 0 adaugam constanta la rezultat
                rez.setCoefficient(power + 1, coef);
                rez.setCoefficient(power, 0.0);
            } else {
                rez.setCoefficient(power + 1, coef / (power + 1));
            }
        }

        //adaugam constanta
        rez.setCoefficient(0, 0.0);

        return rez;
    }
}
