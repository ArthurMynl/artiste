package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class CarreTest {
    @Test
    void testAire() {
        Carre carre = new Carre(10);
        assertEquals(100, carre.aire());
    }

    @Test
    void testContient() {
        Carre carre = new Carre(10);
        assertEquals(true, carre.contient(new Coordonnees(0, 0)));
        assertEquals(true, carre.contient(new Coordonnees(10, 10)));
        assertEquals(true, carre.contient(new Coordonnees(10, 0)));
        assertEquals(true, carre.contient(new Coordonnees(0, 10)));
        assertEquals(false, carre.contient(new Coordonnees(11, 11)));
    }

    @Test
    void testPerimetre() {
        Carre carre = new Carre(10);
        assertEquals(40, carre.perimetre());
    }

    @Test
    void testSetHauteur() {
        Carre carre = new Carre(10);
        carre.setHauteur(20);
        assertEquals(20, carre.getHauteur());
    }

    @Test
    void testSetLargeur() {
        Carre carre = new Carre(10);
        carre.setLargeur(20);
        assertEquals(20, carre.getLargeur());
    }

    @Test
    void testToString() {
        Carre carre = new Carre(10);
        assertEquals("[Carre aucune] : pos (0,0 , 0,0) cote 10,0 périmètre : 40,0 aire : 100,0 couleur = R0,V0,B0", carre.toString());
    }
}
