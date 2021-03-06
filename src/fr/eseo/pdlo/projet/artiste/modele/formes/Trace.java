package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Trace extends Forme {

    private ArrayList<Coordonnees> points;

    public Trace(Coordonnees pos1, Coordonnees pos2) {
        super(new Coordonnees(Math.min(pos1.getAbscisse(), pos2.getAbscisse()),
                Math.min(pos1.getOrdonnee(), pos2.getOrdonnee())),
                Math.max(pos1.getAbscisse(), pos2.getAbscisse()) - Math.min(pos1.getAbscisse(), pos2.getAbscisse()),
                Math.max(pos1.getOrdonnee(), pos2.getOrdonnee()) - Math.min(pos1.getOrdonnee(), pos2.getOrdonnee()));
        this.points = new ArrayList<Coordonnees>();
        this.points.add(pos1);
        this.points.add(pos2);
    }

    public ArrayList<Coordonnees> getPoints() {
        return this.points;
    }

    public void ajoutePoint(Coordonnees pos) {
        if (this.getPoints().get(this.getPoints().size() - 1).equals(pos)) {
            return;
        }
        this.points.add(pos);
        if (this.getPosition().getAbscisse() > pos.getAbscisse()) {
            super.setLargeur(this.getLargeur() + Math.abs(this.getPosition().getAbscisse() - pos.getAbscisse()));
            super.getPosition().setAbscisse(pos.getAbscisse());
        }
        if (this.getPosition().getOrdonnee() > pos.getOrdonnee()) {
            super.setHauteur(this.getHauteur() + Math.abs(this.getPosition().getOrdonnee() - pos.getOrdonnee()));
            super.getPosition().setOrdonnee(pos.getOrdonnee());
        }
        if (this.getPosition().getAbscisse() + this.getLargeur() < pos.getAbscisse()) {
            super.setLargeur(pos.getAbscisse() - this.getPosition().getAbscisse());
        }
        if (this.getPosition().getOrdonnee() + this.getHauteur() < pos.getOrdonnee()) {
            super.setHauteur(pos.getOrdonnee() - this.getPosition().getOrdonnee());
        }
    }

    /*
    public void setPosition(Coordonnees pos) {
        this.deplacerVers(pos.getAbscisse(), pos.getOrdonnee());
    }
    */
    
    public void setLargeur(double largeur) {
        for (Coordonnees pos : this.getPoints()) {
            pos.setAbscisse(this.getPosition().getAbscisse()
                    + (pos.getAbscisse() - this.getPosition().getAbscisse()) * (largeur / this.getLargeur()));
        }
        super.setLargeur(largeur);
    }

    public void setHauteur(double hauteur) {
        for (Coordonnees pos : this.getPoints()) {
            pos.setOrdonnee(this.getPosition().getOrdonnee()
                    + (pos.getOrdonnee() - this.getPosition().getOrdonnee()) * (hauteur / this.getLargeur()));
        }
        super.setLargeur(hauteur);
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

        return  "[Trac??] : pos (" + df.format(this.getPosition().getAbscisse()) + " , "
                + df.format(this.getPosition().getOrdonnee()) + ") largeur " + df.format(this.getLargeur())
                + " hauteur " + df.format(this.getHauteur()) + " p??rim??tre : " + df.format(this.perimetre())
                + " nombre points : " + (this.points.size() - 1) + " couleur = " + rgb;

    }

    @Override
    public double aire() {
        return 0;
    }

    @Override
    public double perimetre() {
        double longueur = 0;
        for (int i = 0; i < this.points.size() - 1; i++) {
            longueur += this.points.get(i).distanceVers(this.points.get(i + 1));
        }
        return longueur;
    }

    @Override
    public boolean contient(Coordonnees coordonnees) {
        Rectangle rectangle = new Rectangle(this.getPosition(), this.getLargeur(), this.getHauteur());
        if (!rectangle.contient(coordonnees)) {
            return false;
        } else {
            for (int i = 0; i < this.points.size() - 2; i++) {
                Ligne ligne = new Ligne(this.points.get(i));
                ligne.setC2(this.points.get(i + 1));
                if (ligne.contient(coordonnees)) {
                    return true;
                }
            }
            return false;
        }
    }
}
