package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;

import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;

public class VueCercle extends VueEllipse {
    public VueCercle(Cercle cercle) {
        super(cercle);
    }

    @Override
    public void affiche(java.awt.Graphics2D g2d) {
        Color context_color = g2d.getColor();
        g2d.setColor(getForme().getCouleur());
        g2d.drawOval((int) Math.round(this.forme.getPosition().getAbscisse()),
                (int) Math.round(this.forme.getPosition().getOrdonnee()),
                (int) Math.round(this.forme.getLargeur()), (int) Math.round(this.forme.getHauteur()));
        g2d.setColor(context_color);
    }
}
