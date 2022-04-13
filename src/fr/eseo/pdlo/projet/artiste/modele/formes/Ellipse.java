package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
// import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
// import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class Ellipse extends Forme {
    // private Remplissage remplissage;

    public Ellipse() {
        super();
        // remplissage = Remplissage.AUCUNE;
    }

    public Ellipse(double largeur, double hauteur) {
        super(largeur, hauteur);
        if (largeur < 0) {
            throw new IllegalArgumentException("La largeur doit être positive.");
        } else if (hauteur < 0) {
            throw new IllegalArgumentException("La hauteur doit être positive.");
        }
        // remplissage = Remplissage.AUCUNE;
    }

    public Ellipse(Coordonnees position) {
        super(position);
        // remplissage = Remplissage.AUCUNE;
    }

    public Ellipse(Coordonnees position, double largeur, double hauteur) {
        super(position, largeur, hauteur);
        if (largeur < 0) {
            throw new IllegalArgumentException("La largeur doit être positive.");
        } else if (hauteur < 0) {
            throw new IllegalArgumentException("La hauteur doit être positive.");
        }
        // remplissage = Remplissage.AUCUNE;
    }

    public void setLargeur(double largeur) {
        if (largeur < 0) {
            throw new IllegalArgumentException("La largeur doit être positive.");
        }
        super.setLargeur(largeur);
    }

    public void setHauteur(double hauteur) {
        if (hauteur < 0) {
            throw new IllegalArgumentException("La hauteur doit être positive.");
        }
        super.setHauteur(hauteur);
    }

    @Override
    public String toString() {
        String formatPattern = "0.0#";
        Locale currentLocale = Locale.getDefault();
        DecimalFormat formatDecimal = null;
        DecimalFormatSymbols symbols = null;
        String rgb;

        double petitRayon = Math.min(this.getHauteur(), this.getLargeur()) / 2;
        double grandRayon = Math.max(this.getHauteur(), this.getLargeur()) / 2;

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

        return "[Ellipse] : pos (" + formatDecimal.format(this.getPosition().getAbscisse()) + " , "
                + formatDecimal.format(this.getPosition().getOrdonnee()) + ") petit rayon "
                + formatDecimal.format(petitRayon) + " grand rayon "
                + formatDecimal.format(grandRayon) + " périmètre : "
                + formatDecimal.format(this.perimetre()) + " aire : " + formatDecimal.format(this.aire())
                + " couleur = " + rgb;
    }

    @Override
    public double aire() {
        return this.getHauteur() / 2 * this.getLargeur() / 2 * Math.PI;
    }

    @Override
    public double perimetre() {
        double petitRayon = Math.min(this.getHauteur(), this.getLargeur()) / 2;
        double grandRayon = Math.max(this.getHauteur(), this.getLargeur()) / 2;
        double h = Math.pow((petitRayon - grandRayon) / (petitRayon + grandRayon), 2);
        return Math.PI * (petitRayon + grandRayon) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
    }

    @Override
    public boolean contient(Coordonnees coordonnees) {
        double petitRayon;
        double grandRayon;
        Coordonnees centre;
        if (this.getHauteur() < this.getLargeur()) {
            petitRayon = this.getHauteur() / 2;
            grandRayon = this.getLargeur() / 2;
            centre = new Coordonnees(this.getPosition().getAbscisse() + grandRayon,
                    this.getPosition().getOrdonnee() + petitRayon);
            double eq1 = Math.pow(coordonnees.getAbscisse() - centre.getAbscisse(), 2)
                    / Math.pow(grandRayon, 2);
            double eq2 = Math.pow(coordonnees.getOrdonnee() - centre.getOrdonnee(), 2)
                    / Math.pow(petitRayon, 2);
            return eq1 + eq2 <= 1;
        } else {
            petitRayon = this.getLargeur() / 2;
            grandRayon = this.getHauteur() / 2;
            centre = new Coordonnees(this.getPosition().getAbscisse() + petitRayon,
                    this.getPosition().getOrdonnee() + grandRayon);
            double eq1 = Math.pow(coordonnees.getAbscisse() - centre.getAbscisse(), 2)
                    / Math.pow(petitRayon, 2);
            double eq2 = Math.pow(coordonnees.getOrdonnee() - centre.getOrdonnee(), 2) / Math.pow(grandRayon, 2);
            return eq1 + eq2 <= 1;
        }

    }
    /*
     * @Override
     * public Remplissage getRemplissage() {
     * return remplissage;
     * }
     * 
     * @Override
     * public void setRemplissage(Remplissage remplissage) {
     * this.remplissage = remplissage;
     * 
     * }
     */
}
