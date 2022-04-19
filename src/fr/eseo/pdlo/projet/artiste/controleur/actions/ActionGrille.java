package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionGrille extends AbstractAction {

    private PanneauDessin panneauDessin;
    public static final String NOM_ACTION = "Grille";
    
    public ActionGrille(PanneauDessin panneauDessin) {
        super(NOM_ACTION);
        this.panneauDessin = panneauDessin;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        panneauDessin.setGrille();
    }
    
}
