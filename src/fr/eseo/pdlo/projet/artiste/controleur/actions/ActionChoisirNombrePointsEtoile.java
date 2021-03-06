package fr.eseo.pdlo.projet.artiste.controleur.actions;

import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;
import javax.swing.JSpinner;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilEtoile;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirNombrePointsEtoile implements ChangeListener {

    private PanneauDessin panneauDessin;
    private JToggleButton boutonEtoile;
    private PanneauBarreOutils panneauBarreOutils;
    

    public ActionChoisirNombrePointsEtoile(PanneauDessin panneauDessin, PanneauBarreOutils panneauBarreOutils, JToggleButton boutonEtoile) {
        this.panneauDessin = panneauDessin;
        this.panneauBarreOutils = panneauBarreOutils;
        this.boutonEtoile = boutonEtoile;
    }


    @Override
    public void stateChanged(javax.swing.event.ChangeEvent event) {
        int nombrePoints = Integer.parseInt(((JSpinner) event.getSource()).getValue().toString());
        this.panneauBarreOutils.setNombrePointsEtoiles(nombrePoints);
        if(boutonEtoile.isSelected()) {
            this.panneauDessin.associerOutil(new OutilEtoile(nombrePoints));
        }
    }
}
