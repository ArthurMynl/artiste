package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleur extends AbstractAction {
    private PanneauDessin panneauDessin;

    public static final String NOM_ACTION = "Couleur";

    public ActionChoisirCouleur(PanneauDessin panneauDessin) {
        super(NOM_ACTION);
        this.panneauDessin = panneauDessin;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        java.awt.Color color = JColorChooser.showDialog(panneauDessin, NOM_ACTION, panneauDessin.getCouleurCourante());
        if (color != null) {
            panneauDessin.setCouleurCourante(color);
            panneauDessin.setCouleurRemplissageCourante(color);
        }
    }
}
