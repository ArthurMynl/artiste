package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;

public class OutilDeplacer extends Outil {
    private Forme formeSelectionnee;
    private Coordonnees debut;
    private Coordonnees positionInitiale;

    @Override
    public void mousePressed(MouseEvent event) {
        if (getPanneauDessin().getVueFormes().size() != 0) {
            for (int i = getPanneauDessin().getVueFormes().size() - 1; i >= 0; i--) {
                if (getPanneauDessin().getVueFormes().get(i).getForme()
                        .contient(new Coordonnees(event.getX(), event.getY()))) {
                    formeSelectionnee = getPanneauDessin().getVueFormes().get(i).getForme();
                    debut = new Coordonnees(event.getX(), event.getY());
                    positionInitiale = formeSelectionnee.getPosition();
                    break;
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        if (formeSelectionnee != null) {
            double ecartX = event.getX() - debut.getAbscisse();
            double ecartY = event.getY() - debut.getOrdonnee();
            formeSelectionnee.setPosition(
                    new Coordonnees(positionInitiale.getAbscisse() + ecartX, positionInitiale.getOrdonnee() + ecartY));
            getPanneauDessin().repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        formeSelectionnee = null;
        debut = null;
    }
}
