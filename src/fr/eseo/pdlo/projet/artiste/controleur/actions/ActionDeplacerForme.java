package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilDeplacer;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionDeplacerForme extends AbstractAction {
    public static final String NOM_ACTION = "Déplacer";
    private PanneauDessin panneauDessin;

    public ActionDeplacerForme(PanneauDessin panneauDessin) {
        super(NOM_ACTION);
        this.panneauDessin = panneauDessin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        OutilDeplacer outil = new OutilDeplacer();
        panneauDessin.associerOutil(outil);
    }
    
}
