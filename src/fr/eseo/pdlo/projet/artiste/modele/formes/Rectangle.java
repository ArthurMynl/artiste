package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.awt.Color;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class Rectangle extends Forme implements Remplissable {
    private Remplissage remplissage;
    private Color couleurRemplissage;
    private Color[] couleurDegrade;

    public Rectangle() {
        super();
        remplissage = Remplissage.AUCUNE;
        couleurRemplissage = COULEUR_PAR_DEFAUT;
    }

    public Rectangle(Coordonnees position, double largeur, double hauteur) {
        super(position, largeur, hauteur);
        remplissage = Remplissage.AUCUNE;
        couleurRemplissage = COULEUR_PAR_DEFAUT;
    }

    public Rectangle(Coordonnees position) {
        super(position);
        remplissage = Remplissage.AUCUNE;
        couleurRemplissage = COULEUR_PAR_DEFAUT;
    }

    public Rectangle(double largeur, double hauteur) {
        super(largeur, hauteur);
        remplissage = Remplissage.AUCUNE;
        couleurRemplissage = COULEUR_PAR_DEFAUT;
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

        return "[Rectangle " + getRemplissage().getMode() + "] : pos ("
                + df.format(this.getPosition().getAbscisse()) + " , "
                + df.format(this.getPosition().getOrdonnee()) + ") largeur "
                + df.format(this.getLargeur()) + " hauteur " + df.format(this.getHauteur())
                + " périmètre : " + df.format(this.perimetre()) + " aire : "
                + df.format(this.aire()) + " couleur = " + rgb;
    }

    @Override
    public double aire() {
        return getLargeur() * getHauteur();
    }

    @Override
    public double perimetre() {
        return 2 * (getLargeur() + getHauteur());
    }

    @Override
    public boolean contient(Coordonnees coordonnees) {
        return coordonnees.getAbscisse() >= getPosition().getAbscisse()
                && coordonnees.getAbscisse() <= getPosition().getAbscisse() + getLargeur()
                && coordonnees.getOrdonnee() >= getPosition().getOrdonnee()
                && coordonnees.getOrdonnee() <= getPosition().getOrdonnee() + getHauteur();
    }

    @Override
    public Remplissage getRemplissage() {
        return remplissage;
    }
    
    @Override
    public void setRemplissage(Remplissage remplissage) {
        this.remplissage = remplissage;
    }

    @Override
    public Color getCouleurRemplissage() {
        return couleurRemplissage;
    }

    @Override
    public void setCouleurRemplissage(Color couleurRemplissage) {
        this.couleurRemplissage = couleurRemplissage;
    }

    @Override
    public void setCouleurDegrade(Color[] couleurDegrade) {
        this.couleurDegrade = couleurDegrade;
    }

    @Override
    public Color[] getCouleurDegrade() {
        return this.couleurDegrade;
    }
}
