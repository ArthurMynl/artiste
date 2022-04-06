package fr.eseo.pdlo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCercleTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueCercleTest();
            }
        });
    }

    public VueCercleTest() {
        testDessin();
    }

    private void testDessin() {
        JFrame root = new JFrame("Etre un Artiste");
        PanneauDessin panneauDessin = new PanneauDessin();
        panneauDessin.ajouterVueForme(new VueCercle(new Cercle(100)));
        panneauDessin.ajouterVueForme(new VueCercle(new Cercle(50)));
        panneauDessin.ajouterVueForme(new VueCercle(new Cercle(new Coordonnees(300, 200), 100)));
        panneauDessin.ajouterVueForme(new VueCercle(new Cercle()));

        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setLocationRelativeTo(null);
        root.add(panneauDessin);
        root.pack();
        root.setVisible(true);
    }
}
