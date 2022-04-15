package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Carre;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueCarre;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilCarre extends OutilForme {
    @Override
    protected VueForme creerVueForme() {
        VueCarre ret;
        Carre cercle;

        double largeur = getFin().getAbscisse() - getDebut().getAbscisse();
        double hauteur = getFin().getOrdonnee() - getDebut().getOrdonnee();
        double taille = Math.max(Math.abs(largeur), Math.abs(hauteur));

        if (largeur < 0 && hauteur < 0) {
            cercle = new Carre(new Coordonnees(getDebut().getAbscisse() - taille, getDebut().getOrdonnee() - taille),
                    taille);
            cercle.setCouleur(getPanneauDessin().getCouleurCourante());
            cercle.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
            ret = new VueCarre(cercle);
        } else if (largeur < 0) {
            cercle = new Carre(new Coordonnees(getDebut().getAbscisse() - taille, getDebut().getOrdonnee()), taille);
            cercle.setCouleur(getPanneauDessin().getCouleurCourante());
            cercle.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
            ret = new VueCarre(cercle);
        } else if (hauteur < 0) {
            cercle = new Carre(new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee() - taille), taille);
            cercle.setCouleur(getPanneauDessin().getCouleurCourante());
            cercle.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
            ret = new VueCarre(cercle);
        } else {
            cercle = new Carre(getDebut(), taille);
            cercle.setCouleur(getPanneauDessin().getCouleurCourante());
            cercle.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
            ret = new VueCarre(cercle);
        }
        return ret;
    }
}
