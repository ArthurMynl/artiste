package fr.eseo.pdlo.projet.artiste.controleur.actions;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilGomme;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class ActionGomme extends AbstractAction {
    private PanneauDessin panneauDessin;
    public static final String NOM_ACTION = "Gomme";

    public ActionGomme(PanneauDessin panneauDessin) {
        this.panneauDessin = panneauDessin;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        OutilGomme outil = new OutilGomme();
        panneauDessin.associerOutil(outil);
    }
}
