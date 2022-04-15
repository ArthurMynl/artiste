package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import java.awt.RenderingHints;

public class VueCercle extends VueEllipse {
    private Remplissage remplissage;

    public VueCercle(Cercle cercle) {
        super(cercle);
        this.remplissage = cercle.getRemplissage();
    }

    @Override
    public void affiche(java.awt.Graphics2D g2d) {
        Color contextColor = g2d.getColor();
        g2d.setColor(getForme().getCouleur());
        if (getForme().getAliasing()) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        else {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        }
        g2d.drawOval((int) Math.round(this.forme.getPosition().getAbscisse()),
                (int) Math.round(this.forme.getPosition().getOrdonnee()),
                (int) Math.round(this.forme.getLargeur()), (int) Math.round(this.forme.getHauteur()));
        if (remplissage == Remplissage.UNIFORME) {
            g2d.fillOval((int) Math.round(this.forme.getPosition().getAbscisse()),
                    (int) Math.round(this.forme.getPosition().getOrdonnee()),
                    (int) Math.round(this.forme.getLargeur()), (int) Math.round(this.forme.getHauteur()));
        }
        g2d.setColor(contextColor);
    }
}
