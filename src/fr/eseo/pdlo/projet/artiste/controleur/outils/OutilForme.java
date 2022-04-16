package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;


public abstract class OutilForme extends Outil {
    @Override
    public void mouseClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
            setDebut(new Coordonnees(event.getX(), event.getY()));
            setFin(new Coordonnees(event.getX() + Forme.LARGEUR_PAR_DEFAUT, event.getY() + Forme.HAUTEUR_PAR_DEFAUT));
            this.getPanneauDessin().ajouterVueForme(this.creerVueForme());
            this.getPanneauDessin().setVueFormeTemporaire(null);
            this.getPanneauDessin().repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        setFin(new Coordonnees(event.getX(), event.getY()));
        this.getPanneauDessin().setVueFormeTemporaire(this.creerVueForme()); 
        this.getPanneauDessin().repaint();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        super.mouseReleased(event);
        if (!this.getDebut().equals(this.getFin())) {
            this.getPanneauDessin().ajouterVueForme(this.creerVueForme());
            this.getPanneauDessin().setVueFormeTemporaire(null);
            this.getPanneauDessin().repaint();
        }
    }

    protected abstract VueForme creerVueForme();

}
