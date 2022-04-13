package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public abstract class Outil implements javax.swing.event.MouseInputListener {

    private Coordonnees debut;
    private Coordonnees fin;
    private PanneauDessin panneauDessin;

    public Outil(PanneauDessin panneauDessin) {
        this.setPanneauDessin(panneauDessin);
    }

    public Outil() {
        this.debut = new Coordonnees();
        this.fin = new Coordonnees();
    }
    
    public void setPanneauDessin(PanneauDessin panneau) {
        panneauDessin = panneau;
    }

    public PanneauDessin getPanneauDessin() {
        return panneauDessin;
    }

    public void mouseClicked(MouseEvent event) {
    }

    public void mouseDragged(MouseEvent event) {

    }

    public void mouseEntered(MouseEvent event) {

    }

    public void mouseExited(MouseEvent event) {

    }
    
    public void mouseMoved(MouseEvent event) {

    }

    public void mousePressed(MouseEvent event) {
        setDebut(new Coordonnees(event.getX(), event.getY()));
    }

    public void mouseReleased(MouseEvent event) {
        setFin(new Coordonnees(event.getX(), event.getY()));
    }

    public Coordonnees getDebut() {
        return debut;
    }

    public void setDebut(Coordonnees nouveauDebut) {
        debut = nouveauDebut;
    }
    
    public Coordonnees getFin() {
        return fin;
    }

    public void setFin(Coordonnees nouvelleFin) {
        fin = nouvelleFin;
    }
}
