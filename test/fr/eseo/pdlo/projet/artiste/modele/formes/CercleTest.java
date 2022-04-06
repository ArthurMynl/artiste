package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class CercleTest {
    @Test
    void testCercle() {
        Cercle cercle = new Cercle();
        assertEquals(0, cercle.getPosition().getAbscisse());
        assertEquals(0, cercle.getPosition().getOrdonnee());
        assertEquals(150, cercle.getLargeur());
        assertEquals(150, cercle.getHauteur());
    }

    @Test
    void testCercle2() {
        Cercle cercle = new Cercle(new Coordonnees(10, 10));
        assertEquals(10, cercle.getPosition().getAbscisse());
        assertEquals(10, cercle.getPosition().getOrdonnee());
        assertEquals(150, cercle.getLargeur());
        assertEquals(150, cercle.getHauteur());
    }

    @Test
    void testCercle3() {
        Cercle cercle = new Cercle(new Coordonnees(10, 10), 20);
        assertEquals(10, cercle.getPosition().getAbscisse());
        assertEquals(10, cercle.getPosition().getOrdonnee());
        assertEquals(20, cercle.getLargeur());
        assertEquals(20, cercle.getHauteur());
    }

    @Test
    void testCercle4() {
        Cercle cercle = new Cercle(10);
        assertEquals(0, cercle.getPosition().getAbscisse());
        assertEquals(0, cercle.getPosition().getOrdonnee());
        assertEquals(10, cercle.getLargeur());
        assertEquals(10, cercle.getHauteur());
    }

    @Test
    void testAire() {
        Cercle cercle = new Cercle(2);
        assertEquals(Math.PI, cercle.aire());
    }

    @Test
    void testPerimetre() {
        Cercle cercle = new Cercle(2);
        assertEquals(2 * Math.PI, cercle.perimetre());
    }

    @Test
    void testSetHauteur() {
        Cercle cercle = new Cercle(1);
        cercle.setHauteur(10);
        assertEquals(10, cercle.getHauteur());
        assertThrows(IllegalArgumentException.class, () -> {
            cercle.setHauteur(-1);
        });
    }

    @Test
    void testSetLargeur() {
        Cercle cercle = new Cercle();
        cercle.setLargeur(10);
        assertEquals(10, cercle.getLargeur());
        assertThrows(IllegalArgumentException.class, () -> {
            cercle.setLargeur(-1);
        });
    }

    @Test
    void testToString() {
        Cercle cercle = new Cercle(new Coordonnees(10, 10), 50.5);
        assertEquals("[Cercle] : pos (10,0 , 10,0) rayon 25,25 périmètre : 158,65 aire : 2002,96", cercle.toString());
    }

    @Test
    void testDeplacerDe() {
        Cercle cercle = new Cercle(new Coordonnees(10, 10), 50.5);
        cercle.deplacerDe(10, 10);
        assertEquals(20, cercle.getPosition().getAbscisse());
        assertEquals(20, cercle.getPosition().getOrdonnee());
    }

    @Test
    void testDeplacerVers() {
        Cercle cercle = new Cercle(new Coordonnees(10, 10), 50.5);
        cercle.deplacerVers(20, 20);
        assertEquals(20, cercle.getPosition().getAbscisse());
        assertEquals(20, cercle.getPosition().getOrdonnee());
    }

    @Test
    void testSetPosition() {
        Cercle cercle = new Cercle(new Coordonnees(10, 10), 50.5);
        cercle.setPosition(new Coordonnees(20, 20));
        assertEquals(20, cercle.getPosition().getAbscisse());
        assertEquals(20, cercle.getPosition().getOrdonnee());
    }

    @Test
    void testGetCadreMinX() {
        Cercle cercle = new Cercle(new Coordonnees(10, 10), 50.5);
        assertEquals(10, cercle.getCadreMinX());
    }

    @Test
    void testGetCadreMinY() {
        Cercle cercle = new Cercle(new Coordonnees(10, 10), 50.5);
        assertEquals(10, cercle.getCadreMinY());
    }

    @Test
    void testGetCadreMaxX() {
        Cercle cercle = new Cercle(new Coordonnees(10, 10), 50.5);
        assertEquals(60.5, cercle.getCadreMaxX());
    }

    @Test
    void testGetCadreMaxY() {
        Cercle cercle = new Cercle(new Coordonnees(10, 10), 50.5);
        assertEquals(60.5, cercle.getCadreMaxY());
    }

    @Test
    void testGetPosition() {
        Cercle cercle = new Cercle(new Coordonnees(10, 10), 50.5);
        assertEquals(10, cercle.getPosition().getAbscisse());
        assertEquals(10, cercle.getPosition().getOrdonnee());
    }

    @Test 
    void testContient() {
        Cercle cercle = new Cercle(new Coordonnees(10, 10), 50.5);
        assertEquals(true, cercle.contient(new Coordonnees(20, 20)));
        assertEquals(false, cercle.contient(new Coordonnees(0, 0)));
    }
}
