package fr.eseo.pdlo.projet.artiste.modele.formes;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public abstract class Forme {
    public static final double LARGEUR_PAR_DEFAUT = 150;
    public static final double HAUTEUR_PAR_DEFAUT = 190;
    public static final java.awt.Color COULEUR_PAR_DEFAUT;
    private double largeur;
    private double hauteur;
    private Coordonnees position;

    public Forme() {
        this.largeur = LARGEUR_PAR_DEFAUT;
        this.hauteur = HAUTEUR_PAR_DEFAUT;
        this.position = new Coordonnees();
    }

    public Forme(double largeur, double hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.position = new Coordonnees();
    }

    public Forme(Coordonnees position) {
        this.largeur = LARGEUR_PAR_DEFAUT;
        this.hauteur = HAUTEUR_PAR_DEFAUT;
        this.position = position;
    }

    public Forme(Coordonnees position, double largeur, double hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.position = position;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public Coordonnees getPosition() {
        return position;
    }

    public void setPosition(Coordonnees position) {
        this.position = position;
    }

    public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
        this.getPosition().deplacerVers(nouvelleAbscisse, nouvelleOrdonnee);
    }

    public void deplacerDe(double deltaX, double deltaY) {
        this.getPosition().deplacerDe(deltaX, deltaY);
    }

    public double getCadreMinX() {
        if(largeur < 0) {
            return position.getAbscisse() + largeur;
        } else {
            return position.getAbscisse();
        }
    }

    public double getCadreMaxX() {
        if(largeur < 0) {
            return position.getAbscisse();
        } else {
            return position.getAbscisse() + largeur;
        }
    }

    public double getCadreMinY() {
        if (hauteur < 0) {
            return this.getPosition().getOrdonnee() + hauteur;
        } else {
            return this.getPosition().getOrdonnee();
        }
    }

    public double getCadreMaxY() {
        if (hauteur < 0) {
            return this.getPosition().getOrdonnee();
        } else {
            return this.getPosition().getOrdonnee() + hauteur;
        }
    }
    
    public abstract double aire();

    public abstract double perimetre();

    public abstract boolean contient(Coordonnees coordonnees);
}
