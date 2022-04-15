package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Carre extends Rectangle {
    public Carre() {
        super();
    }

    public Carre(Coordonnees position, double largeur) {
        super(position, largeur, largeur);
    }

    public Carre(Coordonnees position) {
        super(position);
    }

    public Carre(double largeur) {
        super(largeur, largeur);
    }

    @Override
    public String toString() {
        String formatPattern = "0.0#";
        Locale locale = Locale.getDefault();
        DecimalFormat df = null;
        DecimalFormatSymbols symbols = null;
        String rgb = null;

        if (locale.getLanguage().equals(new Locale("fr").getLanguage())) {
            symbols = new DecimalFormatSymbols(Locale.FRANCE);
            rgb = "R" + getCouleur().getRed() + ",V" + getCouleur().getGreen() + ",B"
                    + getCouleur().getBlue();
        }
        if (locale.getLanguage().equals(new Locale("en").getLanguage())) {
            symbols = new DecimalFormatSymbols(Locale.ENGLISH);
            rgb = "R" + getCouleur().getRed() + ",G" + getCouleur().getGreen() + ",B"
                    + getCouleur().getBlue();
        }

        df = new DecimalFormat(formatPattern, symbols);

        return "[Carre " + getRemplissage().getMode() + "] : pos ("
                + df.format(this.getPosition().getAbscisse()) + " , "
                + df.format(this.getPosition().getOrdonnee()) + ") cote "
                + df.format(this.getLargeur()) + " périmètre : "
                + df.format(this.perimetre()) + " aire : " + df.format(this.aire())
                + " couleur = " + rgb;
    }

    @Override
    public void setLargeur(double largeur) {
        if (largeur < 0) {
            throw new IllegalArgumentException("La largeur doit être positive.");
        }
        super.setLargeur(largeur);
        super.setHauteur(largeur);
    }

    @Override
    public void setHauteur(double hauteur) {
        if (hauteur < 0) {
            throw new IllegalArgumentException("La hauteur doit être positive.");
        }
        super.setHauteur(hauteur);
        super.setLargeur(hauteur);
    }

    @Override
    public double perimetre() {
        return 4 * this.getLargeur();
    }

    @Override
    public double aire() {
        return this.getLargeur() * this.getLargeur();
    }

    @Override
    public boolean contient(Coordonnees coordonnees) {
        return coordonnees.getAbscisse() >= getPosition().getAbscisse()
                && coordonnees.getAbscisse() <= getPosition().getAbscisse() + getLargeur()
                && coordonnees.getOrdonnee() >= getPosition().getOrdonnee()
                && coordonnees.getOrdonnee() <= getPosition().getOrdonnee() + getHauteur();
    }
}
