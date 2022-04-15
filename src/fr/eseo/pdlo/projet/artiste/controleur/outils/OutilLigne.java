package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueLigne;


public class OutilLigne extends OutilForme {
    @Override
    protected VueForme creerVueForme() {
        
        double largeur = getFin().getAbscisse() - getDebut().getAbscisse();
        double hauteur = getFin().getOrdonnee() - getDebut().getOrdonnee();
        Ligne ligne = new Ligne(getDebut(), largeur, hauteur);
        ligne.setCouleur(getPanneauDessin().getCouleurCourante());
        ligne.setAliasing(getPanneauDessin().getAliasing());
        return new VueLigne(ligne);
    }
}
