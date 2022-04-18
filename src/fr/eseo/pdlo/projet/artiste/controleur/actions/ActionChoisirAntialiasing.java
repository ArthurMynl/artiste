package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirAntialiasing extends AbstractAction {
    public static final String NOM_ACTION = "Anti-aliasing";
    private PanneauDessin panneauDessin;

    public ActionChoisirAntialiasing(PanneauDessin panneauDessin) {
        super(NOM_ACTION);
        this.panneauDessin = panneauDessin;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        panneauDessin.setAliasing(!panneauDessin.getAliasing());
    } 
}
