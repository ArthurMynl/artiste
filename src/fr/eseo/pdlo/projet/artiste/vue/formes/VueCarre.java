package fr.eseo.pdlo.projet.artiste.vue.formes;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Carre;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class VueCarre extends VueRectangle {
    private Remplissage remplissage;

    public VueCarre(Carre carre) {
        super(carre);
        this.remplissage = carre.getRemplissage();
    }

    @Override
    public void affiche(Graphics2D g2d) {
        Color contextColor = g2d.getColor();
        g2d.setColor(getForme().getCouleur());
        if (getForme().getAliasing()) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        else {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        }
        g2d.drawRect((int) Math.round(this.forme.getPosition().getAbscisse()),
                (int) Math.round(this.forme.getPosition().getOrdonnee()),
                (int) Math.round(this.forme.getLargeur()), (int) Math.round(this.forme.getHauteur()));
        if (remplissage == Remplissage.UNIFORME) {
            g2d.fillRect((int) Math.round(this.forme.getPosition().getAbscisse()),
                    (int) Math.round(this.forme.getPosition().getOrdonnee()),
                    (int) Math.round(this.forme.getLargeur()), (int) Math.round(this.forme.getHauteur()));
        }
        g2d.setColor(contextColor);
    }
}
