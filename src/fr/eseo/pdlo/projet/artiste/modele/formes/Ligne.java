package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Ligne extends Forme {
    public static final double EPSILON = 0.2;
    public Ligne(Coordonnees position, double largeur, double hauteur) {
        super(position, largeur, hauteur);
    }

    public Ligne() {
        this(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
    }

    public Ligne(double largeur, double hauteur) {
        this(new Coordonnees(), largeur, hauteur);
    }

    public Ligne(Coordonnees position) {
        this(position, Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
    }

    public Coordonnees getC1() {
        return this.getPosition();
    }

    public Coordonnees getC2() {
        return new Coordonnees(this.getPosition().getAbscisse() + this.getLargeur(),
                this.getPosition().getOrdonnee() + this.getHauteur());
    }

    public void setC1(Coordonnees c1) {
        setLargeur(getC2().getAbscisse() - c1.getAbscisse());
        setHauteur(getC2().getOrdonnee() - c1.getOrdonnee());
        setPosition(c1);
    }

    public void setC2(Coordonnees c2) {
        this.setLargeur(c2.getAbscisse() - this.getPosition().getAbscisse());
        this.setHauteur(c2.getOrdonnee() - this.getPosition().getOrdonnee());
    }

    public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
        this.setPosition(new Coordonnees(nouvelleAbscisse, nouvelleOrdonnee));
    }

    public void deplacerDe(double deplacementAbscisse, double deplacementOrdonnee) {
        this.setPosition(new Coordonnees(this.getPosition().getAbscisse() + deplacementAbscisse,
                this.getPosition().getOrdonnee() + deplacementOrdonnee));
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(1);
        double angle = getC1().angleVers(getC2()) * 180 / Math.PI;
        if (angle < 0) {
            angle += 360;
        }
        return String.format("[%s] c1 : %S c2 : %S longueur : %s angle : %s\u00B0",
                getClass().getSimpleName(), getC1().toString(), getC2().toString(),
                df.format(perimetre()), df.format(angle));
    }

    @Override
    public double aire() {
        return 0;
    }

    @Override
    public double perimetre() {
        return getC1().distanceVers(getC2());
    }

    @Override
    public boolean contient(Coordonnees coordonnees) {
        return this.getC1().distanceVers(coordonnees) + this.getC2().distanceVers(coordonnees)
                - this.perimetre() < EPSILON;
    }

}
