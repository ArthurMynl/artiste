package fr.eseo.pdlo.projet.artiste.modele;

import java.awt.Color;

public interface Remplissable {
    
    Remplissage getRemplissage();

    void setRemplissage(Remplissage remplissage);

    Color getCouleurRemplissage();

    void setCouleurRemplissage(Color couleurRemplissage);

    Color[] getCouleurDegrade();

    void setCouleurDegrade(Color[] couleur);
}
