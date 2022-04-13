package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;

public class VueEllipse extends VueForme {
    public VueEllipse(Ellipse ellipse) {
        super(ellipse);
    }

    @Override
    public void affiche(Graphics2D g2d) {
        Color context_color = g2d.getColor();
        g2d.setColor(getForme().getCouleur());
        g2d.drawOval((int) Math.round(this.forme.getPosition().getAbscisse()),
                (int) Math.round(this.forme.getPosition().getOrdonnee()),
                (int) Math.round(this.forme.getLargeur()), (int) Math.round(this.forme.getHauteur()));
        g2d.setColor(context_color);
    }

}
