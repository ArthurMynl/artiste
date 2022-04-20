package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.util.ArrayList;
import java.awt.RenderingHints;
import java.awt.GradientPaint;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Etoile;

public class VueEtoile extends VueForme {
    private Remplissage remplissage;
    private Color couleurRemplissage;
    private Color[] couleurDegrade;
    private Etoile etoile;

    public VueEtoile(Etoile etoile) {
        super(etoile);
        this.etoile = etoile;
        this.remplissage = etoile.getRemplissage();
        this.couleurRemplissage = etoile.getCouleurRemplissage();
        this.couleurDegrade = etoile.getCouleurDegrade();
    }

    @Override
    public void affiche(Graphics2D g2d) {
        Color contextColor = g2d.getColor();
        Paint contextPaint = g2d.getPaint();


        ArrayList<Coordonnees> points = this.etoile.calculPoints();
        int size = points.size();
        int[] xPoints = new int[size];
        int[] yPoints = new int[size];
        for (int i = 0; i < size; i++) {
            xPoints[i] = (int) Math.round(points.get(i).getAbscisse());
            yPoints[i] = (int) Math.round(points.get(i).getOrdonnee());
        }

        g2d.setColor(getForme().getCouleur());
        if (getForme().getAliasing()) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        } else {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        }

        g2d.rotate(this.forme.getAngle(), this.forme.getPosition().getAbscisse() + this.forme.getLargeur() / 2,
                this.forme.getPosition().getOrdonnee() + this.forme.getHauteur() / 2);

        g2d.drawPolygon(xPoints, yPoints, size);

        if (remplissage == Remplissage.UNIFORME) {
            g2d.setColor(couleurRemplissage);
            g2d.fillPolygon(xPoints, yPoints, size);
        }
        else if (remplissage == Remplissage.DEGRADE) {
            g2d.setPaint(new GradientPaint((int) Math.round(this.forme.getPosition().getAbscisse()),
                    (int) Math.round(this.forme.getPosition().getOrdonnee()), couleurDegrade[0],
                    (int) (Math.round(this.forme.getLargeur() + this.forme.getPosition().getAbscisse())),
                    (int) (Math.round(this.forme.getHauteur() + this.forme.getPosition().getOrdonnee())),
                    couleurDegrade[1]));
            g2d.fillPolygon(xPoints, yPoints, size);
        }
        g2d.setColor(contextColor);
        g2d.setPaint(contextPaint);
        g2d.rotate(-this.forme.getAngle(), this.forme.getPosition().getAbscisse() + this.forme.getLargeur() / 2,
                this.forme.getPosition().getOrdonnee() + this.forme.getHauteur() / 2);
    }
}
