package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirModeRemplissage extends AbstractAction {

    private PanneauDessin panneauDessin;

    public final static String NOM_ACTION_REMPLISSAGE_UNIFORME = "uniforme";
    public final static String NOM_ACTION_REMPLISSAGE_AUCUNE = "aucune";

    public ActionChoisirModeRemplissage(PanneauDessin panneauDessin, Remplissage remplissage) {
        super(remplissage.getMode());
        this.panneauDessin = panneauDessin;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand() == NOM_ACTION_REMPLISSAGE_UNIFORME) {
            panneauDessin.setModeRemplissageCourant(Remplissage.UNIFORME);
        }
        else if (event.getActionCommand() == NOM_ACTION_REMPLISSAGE_AUCUNE) {
            panneauDessin.setModeRemplissageCourant(Remplissage.AUCUNE);
        }
    }
    
}
