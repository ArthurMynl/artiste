package fr.eseo.pdlo.projet.artiste.controleur.actions;

import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilPolygone;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;


public class ActionChoisirNombrePoints implements ChangeListener {

    private PanneauDessin panneauDessin;
    private JToggleButton boutonPolygone;
    private PanneauBarreOutils panneauBarreOutils;
    

    public ActionChoisirNombrePoints(PanneauDessin panneauDessin, PanneauBarreOutils panneauBarreOutils, JToggleButton boutonPolygone) {
        this.panneauDessin = panneauDessin;
        this.panneauBarreOutils = panneauBarreOutils;
        this.boutonPolygone = boutonPolygone;
    }


    @Override
    public void stateChanged(javax.swing.event.ChangeEvent event) {
        int nombrePoints = Integer.parseInt(((JSpinner) event.getSource()).getValue().toString());
        this.panneauBarreOutils.setNombrePoints(nombrePoints);
        if(boutonPolygone.isSelected()) {
            this.panneauDessin.associerOutil(new OutilPolygone(nombrePoints));
        }
    }

}
