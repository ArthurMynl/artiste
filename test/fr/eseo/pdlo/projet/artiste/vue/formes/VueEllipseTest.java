package fr.eseo.pdlo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEllipseTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueEllipseTest();
            }
        });
    }

    public VueEllipseTest() {
        testDessin();
    }

    private void testDessin() {
        JFrame root = new JFrame("Etre un Artiste");
        PanneauDessin panneauDessin = new PanneauDessin();
        panneauDessin.ajouterVueForme(new VueEllipse(new Ellipse(100, 50)));
        panneauDessin.ajouterVueForme(new VueEllipse(new Ellipse(5, 10)));
        panneauDessin.ajouterVueForme(new VueEllipse(new Ellipse(new Coordonnees(300, 200), 150, 100)));
        panneauDessin.ajouterVueForme(new VueEllipse(new Ellipse()));

        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setLocationRelativeTo(null);
        root.add(panneauDessin);
        root.pack();
        root.setVisible(true);
    }
}
