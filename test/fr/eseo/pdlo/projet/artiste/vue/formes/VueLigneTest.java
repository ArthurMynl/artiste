package fr.eseo.pdlo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueLigneTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueLigneTest();
            }
        });
    }

    public VueLigneTest() {
        testDessin();
    }

    private void testDessin() {
        JFrame root = new JFrame("Etre un Artiste");
        PanneauDessin panneauDessin = new PanneauDessin();
        panneauDessin.ajouterVueForme(new VueLigne(new Ligne(100, 50)));
        panneauDessin.ajouterVueForme(new VueLigne(new Ligne(5, 10)));
        panneauDessin.ajouterVueForme(new VueLigne(new Ligne(new Coordonnees(300, 200), 100, 100)));
        panneauDessin.ajouterVueForme(new VueLigne(new Ligne()));

        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setLocationRelativeTo(null);
        root.add(panneauDessin);
        root.pack();
        root.setVisible(true);
    }
}