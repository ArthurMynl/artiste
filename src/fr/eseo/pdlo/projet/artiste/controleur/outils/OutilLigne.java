package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueLigne;

public class OutilLigne extends OutilForme {

    @Override
    protected VueForme creerVueForme() {
        if (this.getFin() != null) {
            double largeur = getFin().getAbscisse() - getDebut().getAbscisse();
            double hauteur = getFin().getOrdonnee() - getDebut().getOrdonnee();
            return new VueLigne(new Ligne(getDebut(), largeur, hauteur));
        }
        else {
            return new VueLigne(new Ligne(getDebut()));
        }
    }
    
}
