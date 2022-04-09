package fr.eseo.pdlo.projet.artiste.controleur.actions;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ActionChoisirForme extends AbstractAction {
    public static final String ACTION_ELLIPSE = "Ellipse";
    public static final String ACTION_LIGNE = "Ligne";
    public static final String ACTION_CERCLE = "Cercle";

    private PanneauDessin panneauDessin;

    public ActionChoisirForme(PanneauDessin panneauDessin, PanneauBarreOutils panneauOutils, String action) {
        super(action);
        this.panneauDessin = panneauDessin;
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand() == ACTION_ELLIPSE) {
            panneauDessin.associerOutil(new OutilEllipse());
        } 
        else if (event.getActionCommand() == ACTION_LIGNE) {
            panneauDessin.associerOutil(new OutilLigne());
        } 
        else if (event.getActionCommand() == ACTION_CERCLE) {
            panneauDessin.associerOutil(new OutilCercle());
        }
    }
}
