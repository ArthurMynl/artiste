package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse {

    public Cercle() {
        super(Forme.LARGEUR_PAR_DEFAUT, Forme.LARGEUR_PAR_DEFAUT);
    }

    public Cercle(double largeur) {
        super(largeur, largeur);
        if (largeur < 0) {
            throw new IllegalArgumentException("La largeur doit être positive.");
        }
    }

    public Cercle(Coordonnees position) {
        super(position, Forme.LARGEUR_PAR_DEFAUT, Forme.LARGEUR_PAR_DEFAUT);
    }

    public Cercle(Coordonnees position, double largeur) {
        super(position, largeur, largeur);
        if (largeur < 0) {
            throw new IllegalArgumentException("La largeur doit être positive.");
        }
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
        String formatPattern = "0.0#";
        Locale currentLocale = Locale.getDefault();
        DecimalFormat formatDecimal = null;
        DecimalFormatSymbols symbols = null;
        String rgb;

        if (currentLocale.getLanguage().equals(new Locale("fr").getLanguage())) {
            symbols = new DecimalFormatSymbols(Locale.FRANCE);
        }
        if (currentLocale.getLanguage().equals(new Locale("en").getLanguage())) {
            symbols = new DecimalFormatSymbols(Locale.ENGLISH);
        }

        formatDecimal = new DecimalFormat(formatPattern, symbols);

        if (Locale.getDefault().getLanguage().equals("fr")) {
            rgb = "R" + getCouleur().getRed() + ",V" + getCouleur().getGreen() + ",B"
                    + getCouleur().getBlue();
        } else {
            System.out.println("Locale.getDefault() = " + Locale.getDefault());
            rgb = "R" + getCouleur().getRed() + ",G" + getCouleur().getGreen() + ",B"
                    + getCouleur().getBlue();
        }

        return "[Cercle " + getRemplissage().getMode() + "] : pos ("
                + formatDecimal.format(this.getPosition().getAbscisse()) + " , "
                + formatDecimal.format(this.getPosition().getOrdonnee()) + ") rayon "
                + formatDecimal.format(this.getLargeur() / 2) + " périmètre : "
                + formatDecimal.format(this.perimetre()) + " aire : " + formatDecimal.format(this.aire())
                + " couleur = " + rgb;
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
