package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;

public class OutilRotation extends Outil {

    private Forme formeSelectionnee;
    private Coordonnees debut;
    private double angleInitial;

    public void mousePressed(MouseEvent event) {
        if (getPanneauDessin().getVueFormes().size() != 0) {
            for (int i = getPanneauDessin().getVueFormes().size() - 1; i >= 0; i--) {
                if (getPanneauDessin().getVueFormes().get(i).getForme()
                        .contient(new Coordonnees(event.getX(), event.getY()))) {
                    formeSelectionnee = getPanneauDessin().getVueFormes().get(i).getForme();
                    debut = new Coordonnees(event.getX(), event.getY());
                    angleInitial = formeSelectionnee.getAngle();
                    break;
                }
            }
        }
    }

    public void mouseDragged(MouseEvent event) {
        if (formeSelectionnee != null) {
            double ecartAngle = debut.angleVers(new Coordonnees(event.getX(), event.getY()));
            formeSelectionnee.setAngle(angleInitial + ecartAngle);
            getPanneauDessin().repaint();
        }
    }

    public void mouseReleased(MouseEvent event) {
        formeSelectionnee = null;
        debut = null;
    }
}