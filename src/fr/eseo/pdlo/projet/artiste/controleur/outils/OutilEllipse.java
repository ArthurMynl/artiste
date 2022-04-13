package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme {

    @Override
    protected VueForme creerVueForme() {
        double largeur = getFin().getAbscisse() - getDebut().getAbscisse();
        double hauteur = getFin().getOrdonnee() - getDebut().getOrdonnee();

        if (largeur < 0 && hauteur < 0) {
            return new VueEllipse(new Ellipse(getFin(), -largeur, -hauteur));
        } else if (largeur < 0) {
            return new VueEllipse(new Ellipse(
                    new Coordonnees(getDebut().getAbscisse() + largeur, getDebut().getOrdonnee()), -largeur, hauteur));
        } else if (hauteur < 0) {
            return new VueEllipse(new Ellipse(
                    new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee() + hauteur), largeur, -hauteur));
        } else {
            return new VueEllipse(new Ellipse(getDebut(), largeur, hauteur));
        }
    }
}
