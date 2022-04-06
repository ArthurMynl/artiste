package fr.eseo.pdlo.projet.artiste.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {
    @Test
    void testCoordonnees() {
        Coordonnees coordonnees = new Coordonnees();
        assertEquals(0, coordonnees.getAbscisse());
        assertEquals(0, coordonnees.getOrdonnee());
    }

    @Test
    void testCoordonnees2() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        assertEquals(1, coordonnees.getAbscisse());
        assertEquals(2, coordonnees.getOrdonnee());
    }

    @Test
    void testAngleVers() {
        Coordonnees coordonnees = new Coordonnees(1, 1);
        Coordonnees coordonnees2 = new Coordonnees(0, 1);
        Coordonnees coordonnees3 = new Coordonnees(1, 0);
        Coordonnees coordonnees4 = new Coordonnees(2, 2);
        assertEquals(0, coordonnees.angleVers(coordonnees2));
        assertEquals(-Math.PI / 2, coordonnees.angleVers(coordonnees3));
        assertEquals(Math.PI / 4, coordonnees.angleVers(coordonnees4));
    }

    @Test
    void testDeplacerDe() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        coordonnees.deplacerDe(1, 1);
        assertEquals(1, coordonnees.getAbscisse());
        assertEquals(1, coordonnees.getOrdonnee());
    }

    @Test
    void testDeplacerVers() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        coordonnees.deplacerVers(1, 1);
        assertEquals(1, coordonnees.getAbscisse());
        assertEquals(1, coordonnees.getOrdonnee());
    }

    @Test
    void testDistanceVers() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        Coordonnees coordonnees2 = new Coordonnees(1, 1);
        assertEquals(Math.sqrt(2), coordonnees.distanceVers(coordonnees2));
    }

    @Test
    void testGetAbscisse() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        assertEquals(0, coordonnees.getAbscisse());
    }

    @Test
    void testGetOrdonnee() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        assertEquals(0, coordonnees.getOrdonnee());
    }

    @Test
    void testSetAbscisse() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        coordonnees.setAbscisse(1);
        assertEquals(1, coordonnees.getAbscisse());
    }

    @Test
    void testSetOrdonnee() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        coordonnees.setOrdonnee(1);
        assertEquals(1, coordonnees.getOrdonnee());
    }

    @Test
    void testToString() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        assertEquals("(0,0 , 0,0)", coordonnees.toString());
    }

    @Test
    void testEquals() { 
        Coordonnees coordonnees = new Coordonnees(0, 0);
        Coordonnees coordonnees2 = new Coordonnees(0, 0);
        Coordonnees coordonnees3 = new Coordonnees(1, 0);
        Coordonnees coordonnees4 = new Coordonnees(0, 1);
        assertEquals(true, coordonnees.equals(coordonnees2));
        assertEquals(false, coordonnees.equals(null));
        assertEquals(false, coordonnees.equals(8));
        assertEquals(false, coordonnees.equals(coordonnees3));
        assertEquals(false, coordonnees.equals(coordonnees4));
    }
}
