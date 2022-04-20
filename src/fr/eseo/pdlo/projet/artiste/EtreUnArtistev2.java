package fr.eseo.pdlo.projet.artiste;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutilsImproved;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class EtreUnArtistev2 {
    public static String titre = "Etre un Artiste";
    public static int largeur = 640;
    public static int hauteur = 480;

    public static void main(String[] args) {
        if(args.length == 3) {
            titre = args[0];
            try { 
                largeur = Integer.parseInt(args[1]);
            } catch(NumberFormatException e) {
                System.out.println("Erreur de format de la largeur, valeur par defaut utilisée");
            }
            try { 
                hauteur = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Erreur de format de la largeur, valeur par defaut utilisée");
            }
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EtreUnArtistev2();
            }
        });
    }

    public EtreUnArtistev2() {
        testEtreUnArtiste();
    }

    private void testEtreUnArtiste() {
        JFrame root = new JFrame(titre);
        PanneauDessin panneauDessin = new PanneauDessin(largeur, hauteur, java.awt.Color.WHITE);
        PanneauBarreEtat panneauBarreEtat = new PanneauBarreEtat(panneauDessin);
        PanneauBarreOutilsImproved panneauBarreOutilImproved = new PanneauBarreOutilsImproved(panneauDessin);

        root.add(panneauBarreEtat, BorderLayout.SOUTH);
        root.add(panneauBarreOutilImproved, BorderLayout.EAST);
        root.add(panneauDessin, BorderLayout.CENTER);

        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setLocationRelativeTo(null);
        root.pack();
        root.setVisible(true);
    }
}