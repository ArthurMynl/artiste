package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Polygone;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VuePolygone;

public class OutilPolygone extends OutilForme {

    private int nombrePoints;

    public OutilPolygone(int nombrePoints) {
        super();
        this.nombrePoints = nombrePoints;
    }

    @Override
    protected VueForme creerVueForme() {
        VuePolygone ret;
        Polygone polygone;

        double largeur = getFin().getAbscisse() - getDebut().getAbscisse();
        double hauteur = getFin().getOrdonnee() - getDebut().getOrdonnee();
        double taille = Math.max(Math.abs(largeur), Math.abs(hauteur));

        if (largeur < 0 && hauteur < 0) {
            polygone = new Polygone(
                    new Coordonnees(getDebut().getAbscisse() - taille, getDebut().getOrdonnee() - taille),
                    taille, nombrePoints);
        } else if (largeur < 0) {
            polygone = new Polygone(new Coordonnees(getDebut().getAbscisse() - taille, getDebut().getOrdonnee()),
                    taille, nombrePoints);
        } else if (hauteur < 0) {
            polygone = new Polygone(
                    new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee() - taille), taille, nombrePoints);
        } else {
            polygone = new Polygone(getDebut(), taille, nombrePoints);
        }

        polygone.setCouleur(getPanneauDessin().getCouleurCourante());
        polygone.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
        polygone.setCouleurRemplissage(getPanneauDessin().getCouleurRemplissageCourante());
        polygone.setCouleurDegrade(getPanneauDessin().getCouleurDegrade());
        polygone.setAliasing(getPanneauDessin().getAliasing());
        ret = new VuePolygone(polygone);
        return ret;
    }

}
