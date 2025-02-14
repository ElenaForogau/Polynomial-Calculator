package polinom;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
    //repr polinomul ca mapa a coeficientilor si puterilor
    private Map<Integer, Double> polynomial;

    public Polinom() {
        this.polynomial = new TreeMap<Integer, Double>();
    }

    //constructorul implicit care initializeaza mapa cu obiectul de tip TreeMap
    public Polinom(String p) {
        this.polynomial = new TreeMap<>();
        parsePolynomial(p);
    }

    //seteaza coeficientul pentru puterea data
    public void setCoefficient(int power, double coefficient) {

        polynomial.put(power, coefficient);
    }

    //returneaza coeficientul pentru o putere data
    public double getCoefficient(int power) {

        return polynomial.getOrDefault(power, 0.0);
    }

    //returneaza mapa ce reprezinta polinomul
    public Map<Integer, Double> getPolynomial() {

        return polynomial;
    }


    //sterge toti coeficientii din map
    public void clear() {

        polynomial.clear();
    }

    /*primeste un sir de caractere care contine un polinom iar apoi il descompune in termenii sai
    dupa ce se determina coeficientii si puterile se adauga la map-ul obiectului curent
    */
    private void parsePolynomial(String p) {
        //se defineste o expresie regulata pt a identifica un termenii polinomului
        //se creeaza un obiect matcher pt a cauta in sirul de caractere termenii conform expresiei regulate
        Pattern termPattern = Pattern.compile("([-+]?\\s*)((?:\\d*(?:\\.\\d+)?(?:[Ee][+-]?\\d+)?)*)(x(?:\\^([+-]?\\d+))?)?");
        Matcher termMatcher = termPattern.matcher(p);

        // se parcurg toti termeni gasiti iar pt fiecare dintre ei se extrag coeficientul si puterea
        while (termMatcher.find()) {
            String signStr = termMatcher.group(1).trim();
            String coefStr = termMatcher.group(2).trim();
            String xPowStr = termMatcher.group(3);
            String powStr = termMatcher.group(4);

            double coef = coefStr.isEmpty() ? 1.0 : Double.parseDouble(coefStr);
            int pow = 0;

            if (signStr.equals("-")) {
                coef = -coef;
            }

            if (xPowStr != null) {
                pow = (powStr == null) ? 1 : Integer.parseInt(powStr);
            } else if (coefStr.isEmpty()) {
                continue;
            }

            double existingCoef = polynomial.getOrDefault(pow, 0.0);
            polynomial.put(pow, existingCoef + coef);
        }
    }

    //transforma polinomul intr-un string format, cu coeficientii si puterile ordonate crescator
    //pt ficare termen se adauga o reprezentare sub forma de sir de caractere a termenului la un sir de caractere intermediar
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");

        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Double> sortedPolynomial = new TreeMap<>(Collections.reverseOrder());
        sortedPolynomial.putAll(polynomial);

        for (Map.Entry<Integer, Double> entry : sortedPolynomial.entrySet()) {
            int power = entry.getKey();
            double coeff = entry.getValue();

            if (coeff == 0.0) {
                continue;
            }

            if (sb.length() > 0) {
                if (coeff > 0) {
                    sb.append(" + ");
                } else {
                    sb.append(" - ");
                    coeff = -coeff;
                }
            }

            if (power == 0) {
                sb.append(df.format(coeff));
            } else if (power == 1) {
                if (coeff != 1.0) {
                    sb.append(df.format(coeff)+ "x");
                } else {
                    sb.append("x");
                }
            } else {
                if (coeff != 1.0) {
                    sb.append(df.format(coeff) + "x^" + power);
                } else {
                    sb.append("x^" + power);
                }
            }
        }

        return sb.toString();
    }

}