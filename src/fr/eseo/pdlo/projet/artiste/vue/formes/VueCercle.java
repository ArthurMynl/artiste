package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import java.awt.RenderingHints;
import java.awt.GradientPaint;
import java.awt.Paint;

public class VueCercle extends VueEllipse {
    private Remplissage remplissage;
    private Color couleurRemplissage;
    private Color[] couleurDegrade;

    public VueCercle(Cercle cercle) {
        super(cercle);
        this.remplissage = cercle.getRemplissage();
        this.couleurRemplissage = cercle.getCouleurRemplissage();
        this.couleurDegrade = cercle.getCouleurDegrade();
    }

    @Override
    public void affiche(java.awt.Graphics2D g2d) {
        Color contextColor = g2d.getColor();
        Paint contextPaint = g2d.getPaint();
        g2d.setColor(getForme().getCouleur());
        if (getForme().getAliasing()) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        } else {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        }
        g2d.rotate(this.forme.getAngle(), this.forme.getPosition().getAbscisse() + this.forme.getLargeur() / 2,
                this.forme.getPosition().getOrdonnee() + this.forme.getHauteur() / 2);
        g2d.drawOval((int) Math.round(this.forme.getPosition().getAbscisse()),
                (int) Math.round(this.forme.getPosition().getOrdonnee()),
                (int) Math.round(this.forme.getLargeur()), (int) Math.round(this.forme.getHauteur()));
        if (remplissage == Remplissage.UNIFORME) {
            g2d.setColor(couleurRemplissage);
            g2d.fillOval((int) Math.round(this.forme.getPosition().getAbscisse()),
                    (int) Math.round(this.forme.getPosition().getOrdonnee()),
                    (int) Math.round(this.forme.getLargeur()), (int) Math.round(this.forme.getHauteur()));
        }
        else if (remplissage == Remplissage.DEGRADE) {
            g2d.setPaint(new GradientPaint((int) Math.round(this.forme.getPosition().getAbscisse()),
                    (int) Math.round(this.forme.getPosition().getOrdonnee()), couleurDegrade[0],
                    (int) (Math.round(this.forme.getLargeur() + this.forme.getPosition().getAbscisse())),
                    (int) (Math.round(this.forme.getHauteur() + this.forme.getPosition().getOrdonnee())),
                    couleurDegrade[1]));
            g2d.fillOval((int) Math.round(this.forme.getPosition().getAbscisse()),
                    (int) Math.round(this.forme.getPosition().getOrdonnee()),
                    (int) Math.round(this.forme.getLargeur()), (int) Math.round(this.forme.getHauteur()));
        }
        g2d.setColor(contextColor);
        g2d.setPaint(contextPaint);
        g2d.rotate(-this.forme.getAngle(), this.forme.getPosition().getAbscisse() + this.forme.getLargeur() / 2,
                this.forme.getPosition().getOrdonnee() + this.forme.getHauteur() / 2);
    }
}
