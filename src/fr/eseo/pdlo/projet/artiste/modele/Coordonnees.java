package fr.eseo.pdlo.projet.artiste.modele;

import java.text.DecimalFormat;

public class Coordonnees {

    public static final double ABSCISSE_PAR_DEFAUT = 0;
    public static final double ORDONNEE_PAR_DEFAUT = 0;
    private double abscisse;
    private double ordonnee;

    public Coordonnees() {
        this.abscisse = ABSCISSE_PAR_DEFAUT;
        this.ordonnee = ORDONNEE_PAR_DEFAUT;
    }

    public Coordonnees(double abscisse, double ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    public double getAbscisse() {
        return abscisse;
    }

    public void setAbscisse(double abscisse) {
        this.abscisse = abscisse;
    }

    public double getOrdonnee() {
        return ordonnee;
    }

    public void setOrdonnee(double ordonnee) {
        this.ordonnee = ordonnee;
    }

    public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
        this.abscisse = nouvelleAbscisse;
        this.ordonnee = nouvelleOrdonnee;
    }

    public void deplacerDe(double deltaX, double deltaY) {
        this.abscisse += deltaX;
        this.ordonnee += deltaY;
    }

    public double angleVers(Coordonnees nouvelleCoordonnee) {
        double angle = Math.atan2(this.ordonnee - nouvelleCoordonnee.ordonnee,
                this.abscisse - nouvelleCoordonnee.abscisse);
        
        if (this.ordonnee < nouvelleCoordonnee.ordonnee) {
            angle += Math.PI;
        }
        
        else if (this.ordonnee > nouvelleCoordonnee.ordonnee) {
            angle -= Math.PI;
        }
        return angle;
    }

    
    public double distanceVers(Coordonnees autreCoordonnees) {
        return Math.sqrt(Math.pow(this.abscisse - autreCoordonnees.abscisse, 2)
                + Math.pow(this.ordonnee - autreCoordonnees.ordonnee, 2));
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(1);
        return "(" + df.format(this.abscisse) + " , " + df.format(this.ordonnee) + ")";
    }


    @Override
    public boolean equals(Object obj) {
        boolean equals = true;            
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordonnees other = (Coordonnees) obj;
        if (Double.doubleToLongBits(abscisse) != Double.doubleToLongBits(other.abscisse))
            return false;
        if (Double.doubleToLongBits(ordonnee) != Double.doubleToLongBits(other.ordonnee))
            return false;
        return equals;
    }

    
}
