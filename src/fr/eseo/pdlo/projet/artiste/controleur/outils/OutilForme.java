package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public abstract class OutilForme extends Outil {

    @Override
    public void mouseClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
            setDebut(new Coordonnees(event.getX(), event.getY()));
            setFin(null);
            super.getPanneauDessin().ajouterVueForme(creerVueForme());
            super.getPanneauDessin().repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        super.mouseReleased(event);
        if (this.getDebut() != this.getFin()) {
            super.getPanneauDessin().ajouterVueForme(creerVueForme());
            super.getPanneauDessin().repaint();
        }
    }
    
    protected abstract VueForme creerVueForme();


}
