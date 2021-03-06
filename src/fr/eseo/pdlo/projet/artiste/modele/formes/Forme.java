package fr.eseo.pdlo.projet.artiste.modele.formes;

import fr.eseo.pdlo.projet.artiste.modele.Aliasing;
import fr.eseo.pdlo.projet.artiste.modele.Coloriable;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import java.awt.Color;

public abstract class Forme implements Coloriable, Aliasing {
    public static final double LARGEUR_PAR_DEFAUT = 190;
    public static final double HAUTEUR_PAR_DEFAUT = 150;
    public static final Color COULEUR_PAR_DEFAUT = javax.swing.UIManager.getColor("Panel.foreground");
    private double largeur;
    private double hauteur;
    private Coordonnees position;
    private Color couleur;
    private boolean aliasing;
    private double angle;

    public Forme() {
        this.largeur = LARGEUR_PAR_DEFAUT;
        this.hauteur = HAUTEUR_PAR_DEFAUT;
        this.position = new Coordonnees();
        this.couleur = COULEUR_PAR_DEFAUT;
        this.angle = 0;
    }

    public Forme(double largeur, double hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.position = new Coordonnees();
        this.couleur = COULEUR_PAR_DEFAUT;
        this.angle = 0;
    }

    public Forme(Coordonnees position) {
        this.largeur = LARGEUR_PAR_DEFAUT;
        this.hauteur = HAUTEUR_PAR_DEFAUT;
        this.position = position;
        this.couleur = COULEUR_PAR_DEFAUT;
        this.angle = 0;
    }

    public Forme(Coordonnees position, double largeur, double hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.position = position;
        this.couleur = COULEUR_PAR_DEFAUT;
        this.angle = 0;
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

    public Coordonnees rotation(Coordonnees coordonnees) {
        Coordonnees centre = new Coordonnees(getPosition().getAbscisse() + getLargeur() / 2, getPosition().getOrdonnee() + getHauteur() / 2);
    
        double deltaX = coordonnees.getAbscisse() - centre.getAbscisse();
        double deltaY = coordonnees.getOrdonnee() - centre.getOrdonnee();

        double x = deltaX * Math.cos(getAngle()) + deltaY * Math.sin(getAngle()) + centre.getAbscisse();
        double y = - deltaX * Math.sin(getAngle()) + deltaY * Math.cos(getAngle()) + centre.getOrdonnee();

        return new Coordonnees(x, y);
    }

    public double getCadreMaxY() {
        if (hauteur < 0) {
            return this.getPosition().getOrdonnee();
        } else {
            return this.getPosition().getOrdonnee() + hauteur;
        }
    }

    public java.awt.Color getCouleur() {
        return couleur;
    }

    public void setCouleur(java.awt.Color couleur) {
        this.couleur = couleur;
    }

    public boolean getAliasing() {
        return aliasing;
    }

    public void setAliasing(boolean aliasing) {
        this.aliasing = aliasing;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }
    
    public abstract double aire();

    public abstract double perimetre();

    public abstract boolean contient(Coordonnees coordonnees);
}
