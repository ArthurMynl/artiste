package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;


public class OutilEllipse extends OutilForme  {

    @Override
    protected VueForme creerVueForme() {
        double largeur = getFin().getAbscisse() - getDebut().getAbscisse();
        double hauteur = getFin().getOrdonnee() - getDebut().getOrdonnee();
        VueEllipse ret;
        Ellipse ellipse;

        if (largeur < 0 && hauteur < 0) {
            ellipse = new Ellipse(getFin(), -largeur, -hauteur);
            ellipse.setCouleur(getPanneauDessin().getCouleurCourante());
            ret = new VueEllipse(ellipse);
        } else if (largeur < 0) {
            ellipse = new Ellipse(new Coordonnees(getDebut().getAbscisse() + largeur, getDebut().getOrdonnee()), -largeur, hauteur);
            ellipse.setCouleur(getPanneauDessin().getCouleurCourante());
            ret = new VueEllipse(ellipse);
        } else if (hauteur < 0) {
            ellipse = new Ellipse(new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee() + hauteur),
                    largeur, -hauteur);
            ellipse.setCouleur(getPanneauDessin().getCouleurCourante());
            ret = new VueEllipse(ellipse);
        } else { 
            ellipse = new Ellipse(getDebut(), largeur, hauteur);
            ellipse.setCouleur(getPanneauDessin().getCouleurCourante());
            ret = new VueEllipse(ellipse);
        }
        return ret;
    }
}
