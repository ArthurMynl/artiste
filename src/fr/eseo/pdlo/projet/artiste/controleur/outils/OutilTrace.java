package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Trace;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueTrace;

import java.awt.event.MouseEvent;

public class OutilTrace extends OutilForme {

    private Trace trace;
    private int cpt;

    @Override
    public void mousePressed(MouseEvent event) {
        trace = new Trace(new Coordonnees(event.getX(), event.getY()), new Coordonnees(event.getX(), event.getY()));
        cpt = 0;
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        if (cpt > 0) {
            getPanneauDessin().getVueFormes().remove(getPanneauDessin().getVueFormes().size() - 1);
        }
        trace.ajoutePoint(new Coordonnees(event.getX(), event.getY()));
        getPanneauDessin().ajouterVueForme(creerVueForme());
        getPanneauDessin().repaint();
        cpt++;
    }


    @Override
    protected VueForme creerVueForme() {
        trace.setCouleur(getPanneauDessin().getCouleurCourante());
        trace.setAliasing(getPanneauDessin().getAliasing());
        return new VueTrace(trace);
    }
}
