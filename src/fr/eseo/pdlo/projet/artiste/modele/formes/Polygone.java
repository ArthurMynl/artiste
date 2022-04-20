package fr.eseo.pdlo.projet.artiste.modele.formes;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class Polygone extends Forme implements Remplissable {
    private Remplissage remplissage;
    private Color couleurRemplissage;
    private Color[] couleurDegrade;
    private int nombrePoints;

    public Polygone(int nombrePoints) {
        super();
        remplissage = Remplissage.AUCUNE;
        couleurRemplissage = COULEUR_PAR_DEFAUT;
        this.nombrePoints = nombrePoints;
    }

    public Polygone(double largeur, int nombrePoints) {
        super(largeur, largeur);
        if (largeur < 0) {
            throw new IllegalArgumentException("La largeur doit être positive.");
        }
        remplissage = Remplissage.AUCUNE;
        couleurRemplissage = COULEUR_PAR_DEFAUT;
        this.nombrePoints = nombrePoints;
    }

    public Polygone(Coordonnees position, double largeur, int nombrePoints) {
        super(position, largeur, largeur);
        if (largeur < 0) {
            throw new IllegalArgumentException("La largeur doit être positive.");
        }
        remplissage = Remplissage.AUCUNE;
        couleurRemplissage = COULEUR_PAR_DEFAUT;
        this.nombrePoints = nombrePoints;
    }

    public Polygone(Coordonnees position, int nombrePoints) {
        super(position);
        remplissage = Remplissage.AUCUNE;
        couleurRemplissage = COULEUR_PAR_DEFAUT;
        this.nombrePoints = nombrePoints;
    }

    public void setNombrePoints(int nombre) {
        this.nombrePoints = nombre;
    }

    public int getNombrePoints() {
        return this.nombrePoints;
    }

    public ArrayList<Coordonnees> calculPoints() {
        // return a list of all the points of the polygon in a circle of largeur/2
        // radius
        ArrayList<Coordonnees> points = new ArrayList<Coordonnees>();
        double angle = 2 * Math.PI / this.nombrePoints;
        // calculate center of circle
        double x = this.getPosition().getAbscisse() + this.getLargeur() / 2;
        double y = this.getPosition().getOrdonnee() + this.getHauteur() / 2;
        Coordonnees centre = new Coordonnees(x, y);
        for (int i = 0; i < this.nombrePoints; i++) {
            points.add(new Coordonnees(
                    centre.getAbscisse() + this.getLargeur() / 2 * Math.cos(i * angle),
                    centre.getOrdonnee() + this.getHauteur() / 2 * Math.sin(i * angle)));
        }
        return points;
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

        return "[Polygone " + getRemplissage().getMode() + "] : pos ("
                + df.format(this.getPosition().getAbscisse()) + " , "
                + df.format(this.getPosition().getOrdonnee()) + ") largeur "
                + df.format(this.getLargeur()) + " nombre de points " + df.format(this.getNombrePoints())
                + " périmètre : " + df.format(this.perimetre()) + " aire : "
                + df.format(this.aire()) + " couleur = " + rgb;
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
    public double aire() {
        ArrayList<Coordonnees> points = calculPoints();
        Coordonnees centre = new Coordonnees(this.getPosition().getAbscisse() + this.getLargeur() / 2,
                this.getPosition().getOrdonnee() + this.getHauteur() / 2);

        double aire = Math.pow(points.get(0).distanceVers(centre), 2) * Math.sin(2 * Math.PI / this.nombrePoints);
        return aire * points.size() / 2;
    }

    @Override
    public double perimetre() {
        ArrayList<Coordonnees> points = calculPoints();
        double perimetre = 0;
        for (int i = 0; i < points.size(); i++) {
            perimetre += this.calculPoints().get(i).distanceVers(this.calculPoints().get((i + 1) % this.nombrePoints));
        }
        return perimetre;
    }

    @Override
    public boolean contient(Coordonnees coordonnees) {
        Coordonnees p = rotation(coordonnees);
        ArrayList<Coordonnees> points = calculPoints();
        Coordonnees p3 = new Coordonnees(this.getPosition().getAbscisse() + this.getLargeur() / 2,
                this.getPosition().getOrdonnee() + this.getHauteur() / 2);
        for (int i = 0; i < points.size(); i++) {
            Coordonnees p1 = points.get(i);
            Coordonnees p2 = points.get((i + 1) % points.size());

            double alpha = ((p2.getOrdonnee() - p3.getOrdonnee()) * (p.getAbscisse() - p3.getAbscisse())
                    + (p3.getAbscisse() - p2.getAbscisse()) * (p.getOrdonnee() - p3.getOrdonnee())) /
                    ((p2.getOrdonnee() - p3.getOrdonnee()) * (p1.getAbscisse() - p3.getAbscisse())
                            + (p3.getAbscisse() - p2.getAbscisse()) * (p1.getOrdonnee() - p3.getOrdonnee()));
            double beta = ((p3.getOrdonnee() - p1.getOrdonnee()) * (p.getAbscisse() - p3.getAbscisse())
                    + (p1.getAbscisse() - p3.getAbscisse()) * (p.getOrdonnee() - p3.getOrdonnee())) /
                    ((p2.getOrdonnee() - p3.getOrdonnee()) * (p1.getAbscisse() - p3.getAbscisse())
                            + (p3.getAbscisse() - p2.getAbscisse()) * (p1.getOrdonnee() - p3.getOrdonnee()));
            double gamma = 1 - alpha - beta;

            if (alpha >= 0 && beta >= 0 && gamma >= 0) {
                return true;
            }
        }
        return false;
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
