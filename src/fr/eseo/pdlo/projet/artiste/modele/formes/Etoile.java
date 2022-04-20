package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Etoile extends Polygone {

    public Etoile(int nombrePoints) {
        super(nombrePoints);
    }

    public Etoile(double largeur, int nombrePoints) {
        super(largeur, nombrePoints);
    }

    public Etoile(Coordonnees position, double largeur, int nombrePoints) {
        super(position, largeur, nombrePoints);
    }

    public Etoile(Coordonnees position, int nombrePoints) {
        super(position, nombrePoints);
    }

    @Override
    public ArrayList<Coordonnees> calculPoints() {
        ArrayList<Coordonnees> points = new ArrayList<>();
        double angle = 2 * Math.PI / getNombrePoints();

        double x = this.getPosition().getAbscisse() + this.getLargeur() / 2;
        double y = this.getPosition().getOrdonnee() + this.getHauteur() / 2;
        Coordonnees centre = new Coordonnees(x, y);

        double petitRayon = (this.getLargeur() / 2) / ((1 + Math.sqrt(5) / 2));
        double rayon = this.getLargeur() / 2;

        for (int i = 0; i < getNombrePoints(); i++) {
            points.add(new Coordonnees(
                    centre.getAbscisse() + rayon * Math.cos(i * angle),
                    centre.getOrdonnee() + rayon * Math.sin(i * angle)));
            points.add(new Coordonnees(centre.getAbscisse() + petitRayon * Math.cos((i + 0.5) * angle),
                    centre.getOrdonnee() + petitRayon * Math.sin((i + 0.5) * angle)));
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

        return "[Etoile " + getRemplissage().getMode() + "] : pos ("
                + df.format(this.getPosition().getAbscisse()) + " , "
                + df.format(this.getPosition().getOrdonnee()) + ") largeur "
                + df.format(this.getLargeur()) + " nombre de branches " + df.format(this.getNombrePoints())
                + " périmètre : " + df.format(this.perimetre()) + " aire : "
                + df.format(this.aire()) + " couleur = " + rgb;
    }
}
