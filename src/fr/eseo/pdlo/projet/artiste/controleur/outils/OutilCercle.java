package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;

public class OutilCercle extends OutilForme {
    
    @Override
    protected VueForme creerVueForme() {
        double largeur = getFin().getAbscisse() - getDebut().getAbscisse();
        double hauteur = getFin().getOrdonnee() - getDebut().getOrdonnee();
        if (largeur < 0 && hauteur < 0) {
            return new VueCercle(new Cercle(getFin(), Math.max(-largeur, -hauteur)));
        } else if (largeur < 0) {
            return new VueCercle(new Cercle(
                    new Coordonnees(getDebut().getAbscisse() + largeur, getDebut().getOrdonnee()), Math.max(-largeur, hauteur)));
        } else if (hauteur < 0) {
            return new VueCercle(new Cercle(
                    new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee() + hauteur), Math.max(largeur, -hauteur)));
        } else {
            return new VueCercle(new Cercle(getDebut(), Math.max(largeur, hauteur)));
        }
    }
    
}
