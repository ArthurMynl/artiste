package fr.eseo.pdlo.projet.artiste.vue.ihm;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;

public class PanneauBarreEtatTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PanneauBarreEtatTest();
            }
        });
    }

    public PanneauBarreEtatTest() {
        testBarreEtat();
    }

    private void testBarreEtat() {
        JFrame root = new JFrame("Etre un Artiste");
        PanneauDessin panneauDessin = new PanneauDessin();
        PanneauBarreEtat panneauBarreEtat = new PanneauBarreEtat(panneauDessin);

        root.add(panneauBarreEtat, BorderLayout.SOUTH);
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setLocationRelativeTo(null);
        root.add(panneauDessin);
        root.pack();
        root.setVisible(true);
    }
}
