package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.pdlo.projet.artiste.modele.formes.Trace;

import java.awt.Color;

public class VueTrace extends VueForme {
    private Trace trace;

    public VueTrace(Trace trace) {
        super(trace);
        this.trace = trace;
    }

    @Override
    public void affiche(Graphics2D g2d) {
        int size = this.trace.getPoints().size();
        int[] xPoints = new int[size];
        int[] yPoints = new int[size];
        for (int i = 0; i < size; i++) {
            xPoints[i] = (int) Math.round(this.trace.getPoints().get(i).getAbscisse());
            yPoints[i] = (int) Math.round(this.trace.getPoints().get(i).getOrdonnee());
        }
        Color contextColor = g2d.getColor();
        g2d.setColor(getForme().getCouleur());
        if (getForme().getAliasing()) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        else {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        }
        g2d.drawPolyline(xPoints, yPoints, size);

        /*
        // trace le rectangle associé à la trace
        Rectangle rectangle = new Rectangle(this.trace.getPosition(), this.trace.getLargeur(), this.trace.getHauteur());
        
        g2d.drawRect((int) Math.round(rectangle.getPosition().getAbscisse()),
                (int) Math.round(rectangle.getPosition().getOrdonnee()),
                (int) Math.round(rectangle.getLargeur()), (int) Math.round(rectangle.getHauteur()));
        */

        g2d.setColor(contextColor);
    }
}

