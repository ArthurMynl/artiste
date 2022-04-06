package fr.eseo.pdlo.projet.artiste.vue.formes;

import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;

public class VueCercle extends VueEllipse {
    public VueCercle(Cercle cercle) {
        super(cercle);
    }

    @Override
    public void affiche(java.awt.Graphics2D g2d) {
        g2d.drawOval((int) Math.round(this.forme.getPosition().getAbscisse()), (int) Math.round(this.forme.getPosition().getOrdonnee()),
                (int) Math.round(this.forme.getLargeur()), (int) Math.round(this.forme.getHauteur()));
    }
}
