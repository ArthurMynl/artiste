package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public abstract class OutilForme extends Outil {

    @Override
    public void mouseClicked(MouseEvent event) { 
        if (event.getClickCount() == 2) {
            setDebut(new Coordonnees(event.getX(), event.getY()));
            setFin(new Coordonnees(event.getX(), event.getY()));
            super.getPanneauDessin().ajouterVueForme(creerVueForme());
            super.getPanneauDessin().paintComponents(getPanneauDessin().getGraphics());
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        setFin(new Coordonnees(event.getX(), event.getY()));
        if (this.getDebut() != this.getFin()) {
            super.getPanneauDessin().ajouterVueForme(creerVueForme());
        }
    }

    public void mousePressed(MouseEvent event) {
        setDebut(new Coordonnees(event.getX(), event.getY()));
    }
    
    protected abstract VueForme creerVueForme();


}
