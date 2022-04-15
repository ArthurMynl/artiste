package fr.eseo.pdlo.projet.artiste;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class EtreUnArtiste {
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
                new EtreUnArtiste();
            }
        });
    }

    public EtreUnArtiste() {
        testEtreUnArtiste();
    }

    private void testEtreUnArtiste() {
        JFrame root = new JFrame(titre);
        PanneauDessin panneauDessin = new PanneauDessin(largeur, hauteur, java.awt.Color.WHITE);
        PanneauBarreEtat panneauBarreEtat = new PanneauBarreEtat(panneauDessin);
        PanneauBarreOutils panneauBarreOutil = new PanneauBarreOutils(panneauDessin);

        root.add(panneauBarreEtat, BorderLayout.SOUTH);
        root.add(panneauBarreOutil, BorderLayout.EAST);
        root.add(panneauDessin, BorderLayout.CENTER);

        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setLocationRelativeTo(null);
        root.pack();
        root.setVisible(true);
    }
}