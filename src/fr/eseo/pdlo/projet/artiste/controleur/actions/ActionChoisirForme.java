package fr.eseo.pdlo.projet.artiste.controleur.actions;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilCarre;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilPolygone;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilRectangle;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilTrace;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ActionChoisirForme extends AbstractAction {
    public static final String NOM_ACTION_ELLIPSE = "Ellipse";
    public static final String NOM_ACTION_LIGNE = "Ligne";
    public static final String NOM_ACTION_CERCLE = "Cercle";
    public static final String NOM_ACTION_RECTANGLE = "Rectangle";
    public static final String NOM_ACTION_CARRE = "Carré";
    public static final String NOM_ACTION_TRACE = "Tracé";
    public static final String NOM_ACTION_POLYGONE = "Polygone";
    public static final String NOM_ACTION_ETOILE = "Etoile";

    private PanneauDessin panneauDessin;
    private PanneauBarreOutils panneauOutils;

    public ActionChoisirForme(PanneauDessin panneauDessin, PanneauBarreOutils panneauOutils, String action) {
        super(action);
        this.panneauDessin = panneauDessin;
        this.panneauOutils = panneauOutils;
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand() == NOM_ACTION_ELLIPSE) {
            panneauDessin.associerOutil(new OutilEllipse());
        } 
        else if (event.getActionCommand() == NOM_ACTION_LIGNE) {
            panneauDessin.associerOutil(new OutilLigne());
        } 
        else if (event.getActionCommand() == NOM_ACTION_CERCLE) {
            panneauDessin.associerOutil(new OutilCercle());
        }
        else if (event.getActionCommand() == NOM_ACTION_RECTANGLE) {
            panneauDessin.associerOutil(new OutilRectangle());
        }
        else if (event.getActionCommand() == NOM_ACTION_CARRE) {
            panneauDessin.associerOutil(new OutilCarre());
        }
        else if (event.getActionCommand() == NOM_ACTION_TRACE) {
            panneauDessin.associerOutil(new OutilTrace());
        }
        else if (event.getActionCommand() == NOM_ACTION_POLYGONE) {
            panneauDessin.associerOutil(new OutilPolygone(panneauOutils.getNombrePoints()));
        }
        else if (event.getActionCommand() == NOM_ACTION_ETOILE) {
            panneauDessin.associerOutil(new OutilPolygone(panneauOutils.getNombrePointsEtoiles()));
        }
    }
}
