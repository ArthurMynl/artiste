package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueRectangle;

public class OutilRectangle extends OutilForme {
    @Override
    protected VueForme creerVueForme() {
        double largeur = getFin().getAbscisse() - getDebut().getAbscisse();
        double hauteur = getFin().getOrdonnee() - getDebut().getOrdonnee();
        VueRectangle ret;
        Rectangle rectangle;

        if (largeur < 0 && hauteur < 0) {
            rectangle = new Rectangle(getFin(), -largeur, -hauteur);
        } else if (largeur < 0) {
            rectangle = new Rectangle(new Coordonnees(getDebut().getAbscisse() + largeur, getDebut().getOrdonnee()),
                    -largeur, hauteur);
        } else if (hauteur < 0) {
            rectangle = new Rectangle(new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee() + hauteur),
                    largeur, -hauteur);
        } else {
            rectangle = new Rectangle(getDebut(), largeur, hauteur);
        }

        rectangle.setCouleur(getPanneauDessin().getCouleurCourante());
        rectangle.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
        rectangle.setCouleurRemplissage(getPanneauDessin().getCouleurRemplissageCourante());
        rectangle.setCouleurDegrade(getPanneauDessin().getCouleurDegrade());
        rectangle.setAliasing(getPanneauDessin().getAliasing());
        ret = new VueRectangle(rectangle);
        return ret;
    }
}
