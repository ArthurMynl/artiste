package fr.eseo.pdlo.projet.artiste.controleur.actions;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilResize;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ActionResizeForme extends AbstractAction {
    public static final String NOM_ACTION = "Resize";
    private PanneauDessin panneauDessin;
    
    public ActionResizeForme(PanneauDessin panneauDessin) {
        super(NOM_ACTION);
        this.panneauDessin = panneauDessin;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        OutilResize outil = new OutilResize();
        panneauDessin.associerOutil(outil);
    }
    
}
