package fr.eseo.pdlo.projet.artiste.controleur.actions;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirRemplissageTest {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new ActionChoisirRemplissageTest();
                }
            });
        }
    
        public ActionChoisirRemplissageTest() {
            testBarreEtat();
        }
    
        private void testBarreEtat() {
            JFrame root = new JFrame("Etre un Artiste");
            PanneauDessin panneauDessin = new PanneauDessin();
            PanneauBarreEtat panneauBarreEtat = new PanneauBarreEtat(panneauDessin);
            PanneauBarreOutils panneauBarreOutil = new PanneauBarreOutils(panneauDessin);
    
            root.add(panneauBarreEtat, BorderLayout.SOUTH);
            root.add(panneauBarreOutil, BorderLayout.EAST);
            root.add(panneauDessin, BorderLayout.CENTER);
    
            root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            root.setLocationRelativeTo(null);
            root.pack();
            root.setVisible(true);
    
            OutilLigne outil = new OutilLigne();
            panneauDessin.associerOutil(outil);
        }
    }