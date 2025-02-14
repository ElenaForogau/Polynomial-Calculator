package GUI;

import operatii.Operatii;
import polinom.Polinom;

import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame implements ActionListener {
    //cream containere pt componente
    private static final long serialVersionUID = 1L;

    private Operatii operatii = new Operatii();
    private JPanel pane = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    private JPanel window = new JPanel();

    private JPanel panel3 = new JPanel();
    private JButton adunare = new JButton("Adunare");
    private JButton scadere = new JButton("Scadere");
    private JButton inmultire = new JButton("Inmultire");
    private JButton impartire = new JButton("Impartire");
    private JButton derivare = new JButton("Derivare");
    private JButton integrare = new JButton("Integrare");

    private JPanel panel1 = new JPanel();
    private JLabel l1 = new JLabel("Polinom 1: ");
    private JTextField textPol1 = new JTextField("", 20);

    private JPanel panel2 = new JPanel();
    private JLabel l2 = new JLabel("Polinom 2: ");
    private JTextField textPol2 = new JTextField("", 20);

    private JPanel panel4 = new JPanel();
    private JLabel l3 = new JLabel("Rezultat =");
    private JTextField rez = new JTextField("", 20);
    private JButton resetare = new JButton("Reset");

    public View() {

        super();
        window.setLayout(new BoxLayout(window, BoxLayout.PAGE_AXIS));
        panel1.add(l1);
        panel1.add(textPol1);
        panel2.add(l2);
        panel2.add(textPol2);
        panel3.add(adunare);
        adunare.addActionListener(this);
        panel3.add(scadere);
        scadere.addActionListener(this);
        panel3.add(inmultire);
        inmultire.addActionListener(this);
        panel3.add(impartire);
        impartire.addActionListener(this);
        panel3.add(derivare);
        derivare.addActionListener(this);
        panel3.add(integrare);
        integrare.addActionListener(this);
        panel4.add(l3);
        panel4.add(rez);
        panel4.add(resetare);
        resetare.addActionListener(this);

        adunare.setBackground(new Color(255, 239, 213));
        scadere.setBackground(new Color(255, 239, 213));
        inmultire.setBackground(new Color(255, 239, 213));
        impartire.setBackground(new Color(255, 239, 213));
        derivare.setBackground(new Color(255, 239, 213));
        integrare.setBackground(new Color(255, 239, 213));
        resetare.setBackground(new Color(255, 239, 213));

        window.add(panel1);
        window.add(panel2);
        window.add(panel3);
        window.add(panel4);

        add(window);

    }

    //primeste evenimentele si le proceseaza
    //daca se apasa unul dintre butoane pt operatii, atunci se va valida textul
    //introdus in campurile de text pt polinoame, daca este valid, atunci se vor crea doua obiecte
    //si se va apela metoda corespunzatoare din clasa "Operatii".
    //rezultatul va fi afisat in campul de text de afisare a rezultatului
    @Override
    public void actionPerformed(ActionEvent e) {
        //"fa ceva" cand se apasa butonul
        Object source = e.getSource(); //obiectul care a declansat evenimentul de actiune
        try {
            Polinom p1 = new Polinom(textPol1.getText().trim());
            Polinom p2 = new Polinom(textPol2.getText().trim());
            Polinom result = null;

            // se verifica care buton a fost apasat si se efectueaza operatia corespunzatoare
            if (source == adunare) {
                result = operatii.adunare(p1, p2);
            } else if (source == scadere) {
                result = operatii.scadere(p1, p2);
            } else if (source == inmultire) {
                result = operatii.inmultire(p1, p2);
            } else if (source == impartire) {
                result = operatii.impartire(p1, p2);
            } else if (source == derivare) {
                result = operatii.derivare(p1);
            } else if (source == integrare) {
                result = operatii.integrare(p1);
            } else if (source == resetare) {
                textPol1.setText("");
                textPol2.setText("");
                rez.setText("");
                return;
            }
            if (result != null) {
                rez.setText(result.toString());
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Introduceți polinoame valide.");
        }
    }
}
