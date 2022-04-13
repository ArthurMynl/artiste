package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;

import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;

public class VueLigne extends VueForme {
    public VueLigne(Ligne ligne) {
        super(ligne);
    }

    @Override
    public void affiche(java.awt.Graphics2D g2d) {
        Color context_color = g2d.getColor();
        g2d.setColor(getForme().getCouleur());
        g2d.drawLine((int) Math.round(this.forme.getPosition().getAbscisse()),
                (int) Math.round(this.forme.getPosition().getOrdonnee()),
                (int) Math.round(this.forme.getPosition().getAbscisse() + this.forme.getLargeur()),
                (int) Math.round(this.forme.getPosition().getOrdonnee() + this.forme.getHauteur()));
        g2d.setColor(context_color);
    }
}
