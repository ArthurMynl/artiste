package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChangerPlan;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

import java.awt.event.MouseEvent;

public class OutilChangerPlan extends Outil {
    
    private VueForme vueFormeSelectionnee;
    private int index;
    private String plan;

    public OutilChangerPlan(String plan) {
        super();
        this.plan = plan;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        for (int i = getPanneauDessin().getVueFormes().size() - 1; i >= 0; i--) {
            if (getPanneauDessin().getVueFormes().get(i).getForme()
                    .contient(new Coordonnees(event.getX(), event.getY()))) {
                vueFormeSelectionnee = getPanneauDessin().getVueFormes().get(i);
                index = i;
                break;
            }
        }
        
        if (plan == ActionChangerPlan.NOM_ACTION_ARRIERE_PLAN) {
            getPanneauDessin().getVueFormes().remove(vueFormeSelectionnee);
            getPanneauDessin().getVueFormes().add(0, vueFormeSelectionnee);
        }
        else if (plan == ActionChangerPlan.NOM_ACTION_PREMIER_PLAN) {
            getPanneauDessin().getVueFormes().remove(vueFormeSelectionnee);
            getPanneauDessin().getVueFormes().add(vueFormeSelectionnee);
        }
        else if (plan == ActionChangerPlan.NOM_ACTION_PLAN_SUPERIEUR) {
            if (index < getPanneauDessin().getVueFormes().size() - 1) {
                getPanneauDessin().getVueFormes().remove(vueFormeSelectionnee);
                getPanneauDessin().getVueFormes().add(index + 1, vueFormeSelectionnee);
            }
        }
        else if (plan == ActionChangerPlan.NOM_ACTION_PLAN_INFERIEUR) {
            if (index > 0) {
                getPanneauDessin().getVueFormes().remove(vueFormeSelectionnee);
                getPanneauDessin().getVueFormes().add(index - 1, vueFormeSelectionnee);
            }
        }
        getPanneauDessin().repaint();
    }
}
