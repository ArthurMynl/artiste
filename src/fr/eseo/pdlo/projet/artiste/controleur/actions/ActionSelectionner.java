
package fr.eseo.pdlo.projet.artiste.controleur.actions;

import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionSelectionner extends AbstractAction {

    private PanneauDessin panneauDessin;
    public static final String NOM_ACTION = "Selectionner";


    public ActionSelectionner(PanneauDessin panneauDessin) {
        this.panneauDessin = panneauDessin;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        OutilSelectionner outil = new OutilSelectionner();
        panneauDessin.associerOutil(outil);
    }    
}
