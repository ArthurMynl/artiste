package fr.eseo.pdlo.projet.artiste.controleur.outils;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilLigneTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OutilLigneTest();
            }
        });
    }

    public OutilLigneTest() {
        testDessin();
    }

    private void testDessin() {
        JFrame root = new JFrame("Etre un Artiste");
        PanneauDessin panneauDessin = new PanneauDessin();
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setLocationRelativeTo(null);
        root.add(panneauDessin);
        root.pack();
        root.setVisible(true);

        OutilLigne outil = new OutilLigne();
        outil.setPanneauDessin(panneauDessin);
        panneauDessin.associerOutil(outil);
    }
}
