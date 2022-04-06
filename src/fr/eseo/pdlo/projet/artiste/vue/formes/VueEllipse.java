package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Graphics2D;

import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;

public class VueEllipse extends VueForme {
    public VueEllipse(Ellipse ellipse) {
        super(ellipse);
    }

    @Override
    public void affiche(Graphics2D g2d) {
        g2d.drawOval((int) Math.round(this.forme.getPosition().getAbscisse()), (int) Math.round(this.forme.getPosition().getOrdonnee()),
                (int) Math.round(this.forme.getLargeur()), (int) Math.round(this.forme.getHauteur()));
    }

}
