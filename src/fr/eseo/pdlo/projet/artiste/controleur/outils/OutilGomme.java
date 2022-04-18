package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class OutilGomme extends Outil {
    

    @Override
    public void mouseClicked(MouseEvent event) {
        for (int i = getPanneauDessin().getVueFormes().size() - 1; i >= 0; i--) {
            if (getPanneauDessin().getVueFormes().get(i).getForme()
                    .contient(new Coordonnees(event.getX(), event.getY()))) {
                getPanneauDessin().getVueFormes().remove(i);
                break;
            }
        }
        getPanneauDessin().repaint();
    }
}
