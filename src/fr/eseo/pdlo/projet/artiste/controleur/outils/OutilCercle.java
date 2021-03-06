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
        VueCercle ret;
        Cercle cercle;

        double largeur = getFin().getAbscisse() - getDebut().getAbscisse();
        double hauteur = getFin().getOrdonnee() - getDebut().getOrdonnee();
        double taille = Math.max(Math.abs(largeur), Math.abs(hauteur));

        if (largeur < 0 && hauteur < 0) {
            cercle = new Cercle(new Coordonnees(getDebut().getAbscisse() - taille, getDebut().getOrdonnee() - taille),
                    taille);
        } else if (largeur < 0) {
            cercle = new Cercle(new Coordonnees(getDebut().getAbscisse() - taille, getDebut().getOrdonnee()), taille);
        } else if (hauteur < 0) {
            cercle = new Cercle(new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee() - taille), taille);
        } else {
            cercle = new Cercle(getDebut(), taille);
        }

        cercle.setCouleur(getPanneauDessin().getCouleurCourante());
        cercle.setRemplissage(getPanneauDessin().getModeRemplissageCourant());
        cercle.setCouleurRemplissage(getPanneauDessin().getCouleurRemplissageCourante());
        cercle.setCouleurDegrade(getPanneauDessin().getCouleurDegrade());
        cercle.setAliasing(getPanneauDessin().getAliasing());
        ret = new VueCercle(cercle);
        return ret;
    }
}
