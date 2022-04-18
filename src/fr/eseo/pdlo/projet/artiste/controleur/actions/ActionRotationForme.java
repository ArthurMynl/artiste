package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilRotation;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionRotationForme extends AbstractAction {
    public static final String NOM_ACTION = "Rotation";
    private PanneauDessin panneauDessin;

    public ActionRotationForme(PanneauDessin panneauDessin) {
        super(NOM_ACTION);
        this.panneauDessin = panneauDessin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        OutilRotation outil = new OutilRotation();
        panneauDessin.associerOutil(outil);
    }
    
}
