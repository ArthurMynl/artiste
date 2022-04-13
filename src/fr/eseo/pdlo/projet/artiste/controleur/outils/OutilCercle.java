package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import java.awt.event.MouseEvent;

public class OutilCercle extends OutilForme {

    @Override
    public void mouseClicked(MouseEvent event) {
        super.mouseClicked(event);
    }

    @Override
    protected VueForme creerVueForme() {
        double largeur = getFin().getAbscisse() - getDebut().getAbscisse();
        double hauteur = getFin().getOrdonnee() - getDebut().getOrdonnee();
        double taille = Math.max(Math.abs(largeur), Math.abs(hauteur));

        if (largeur < 0 && hauteur < 0) {
            return new VueCercle(new Cercle(
                    new Coordonnees(getDebut().getAbscisse() - taille, getDebut().getOrdonnee() - taille), taille));
        } else if (largeur < 0) {
            return new VueCercle(new Cercle(
                    new Coordonnees(getDebut().getAbscisse() - taille, getDebut().getOrdonnee()), taille));
        } else if (hauteur < 0) {
            return new VueCercle(new Cercle(
                    new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee() - taille), taille));
        } else {
            return new VueCercle(new Cercle(getDebut(), taille));
        }
    }
}
