package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Carre;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueCarre;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilCarre extends OutilForme {
    @Override
    protected VueForme creerVueForme() {
        VueCarre ret;
        Carre carre;

        double largeur = getFin().getAbscisse() - getDebut().getAbscisse();
        double hauteur = getFin().getOrdonnee() - getDebut().getOrdonnee();
        double taille = Math.max(Math.abs(largeur), Math.abs(hauteur));

        if (largeur < 0 && hauteur < 0) {
            carre = new Carre(new Coordonnees(getDebut().getAbscisse() - taille, getDebut().getOrdonnee() - taille),
                    taille);
            carre.setCouleur(getPanneauDessin().getCouleurCourante());
            carre.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
            carre.setAliasing(getPanneauDessin().getAliasing());
            ret = new VueCarre(carre);
        } else if (largeur < 0) {
            carre = new Carre(new Coordonnees(getDebut().getAbscisse() - taille, getDebut().getOrdonnee()), taille);
            carre.setCouleur(getPanneauDessin().getCouleurCourante());
            carre.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
            carre.setAliasing(getPanneauDessin().getAliasing());
            ret = new VueCarre(carre);
        } else if (hauteur < 0) {
            carre = new Carre(new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee() - taille), taille);
            carre.setCouleur(getPanneauDessin().getCouleurCourante());
            carre.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
            carre.setAliasing(getPanneauDessin().getAliasing());
            ret = new VueCarre(carre);
        } else {
            carre = new Carre(getDebut(), taille);
            carre.setCouleur(getPanneauDessin().getCouleurCourante());
            carre.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
            carre.setAliasing(getPanneauDessin().getAliasing());
            ret = new VueCarre(carre);
        }
        return ret;
    }
}
