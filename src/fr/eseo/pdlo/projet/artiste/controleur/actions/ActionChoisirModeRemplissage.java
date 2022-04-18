package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.AbstractAction;
import javax.swing.JColorChooser;


import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;


public class ActionChoisirModeRemplissage extends AbstractAction {

    private PanneauDessin panneauDessin;

    public final static String NOM_ACTION_REMPLISSAGE_UNIFORME = "Uniforme";
    public final static String NOM_ACTION_REMPLISSAGE_AUCUNE = "Aucune";
    public final static String NOM_ACTION_REMPLISSAGE_DEGRADE = "Dégradé";

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
        else if (event.getActionCommand() == NOM_ACTION_REMPLISSAGE_DEGRADE) {
            panneauDessin.setModeRemplissageCourant(Remplissage.DEGRADE);
            Color couleur1 = JColorChooser.showDialog(panneauDessin, "Couleur 1 du dégradé",
                    panneauDessin.getCouleurDegrade()[0]);
            Color couleur2 = JColorChooser.showDialog(panneauDessin, "Couleur 2 du dégradé",
                    panneauDessin.getCouleurDegrade()[1]);
            panneauDessin.setCouleurDegrade(new Color[] { couleur1, couleur2 });
        }
        else { 
            System.out.println(event.getActionCommand());
        }
    }
    
}
