package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse {
    public Cercle() {
        super(Forme.LARGEUR_PAR_DEFAUT, Forme.LARGEUR_PAR_DEFAUT);
    }

    public Cercle(double largeur) {
        super(largeur, largeur);
    }

    public Cercle(Coordonnees position) {
        super(position, Forme.LARGEUR_PAR_DEFAUT, Forme.LARGEUR_PAR_DEFAUT);
    }

    public Cercle(Coordonnees position, double largeur) {
        super(position, largeur, largeur);
    }

    public void setLargeur(double largeur) {
        if (largeur < 0) {
            throw new IllegalArgumentException("La largeur doit être positive.");
        }
        super.setLargeur(largeur);
        super.setHauteur(largeur);
    }

    public void setHauteur(double hauteur) {
        if (hauteur < 0) {
            throw new IllegalArgumentException("La hauteur doit être positive.");
        }
        super.setHauteur(hauteur);
        super.setLargeur(hauteur);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(1);
        df.setGroupingUsed(false);
        return "[Cercle] : pos " + this.getPosition().toString() + " rayon " + df.format(this.getLargeur() / 2)
                + " périmètre : " + df.format(this.perimetre()) + " aire : " + df.format(this.aire());
    }

    @Override
    public double perimetre() {
        return 2 * Math.PI * this.getLargeur() / 2;
    }

    @Override
    public double aire() {
        return Math.PI * Math.pow(this.getLargeur() / 2, 2);
    }

    @Override
    public boolean contient(Coordonnees coordonnees) {
        Coordonnees centre = new Coordonnees(this.getPosition().getAbscisse() + this.getLargeur() / 2,
                this.getPosition().getOrdonnee() + this.getLargeur() / 2);
        return centre.distanceVers(coordonnees) <= this.getLargeur() / 2;
    }
}
