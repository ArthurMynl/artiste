package fr.eseo.pdlo.projet.artiste.controleur.actions;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilChangerPlan;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ActionChangerPlan extends AbstractAction {
    

    public static final String NOM_ACTION_PREMIER_PLAN = "Premier plan";
    public static final String NOM_ACTION_ARRIERE_PLAN = "Arriere plan";
    public static final String NOM_ACTION_PLAN_SUPERIEUR = "Plan superieur";
    public static final String NOM_ACTION_PLAN_INFERIEUR = "Plan inferieur";

    private PanneauDessin panneauDessin;

    public ActionChangerPlan(PanneauDessin panneauDessin, String nomAction) {
        super(nomAction);
        this.panneauDessin = panneauDessin;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        OutilChangerPlan outil = new OutilChangerPlan(event.getActionCommand());
        panneauDessin.associerOutil(outil);
    }

    
}
