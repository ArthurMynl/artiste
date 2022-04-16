package fr.eseo.pdlo.projet.artiste.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {

    CoordonneesTest() {
    }

    @Test
    void testCoordonnees() {
        Coordonnees coordonnees = new Coordonnees();
        assertEquals(0, coordonnees.getAbscisse(), "La coordonnée X doit être égale à 0");
        assertEquals(0, coordonnees.getOrdonnee(), "La coordonnée Y doit être égale à 0");
    }

    @Test
    void testCoordonnees2() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        assertEquals(1, coordonnees.getAbscisse(), "La coordonnée X doit être égale à 1");
        assertEquals(2, coordonnees.getOrdonnee(), "La coordonnée Y doit être égale à 2");
    }

    @Test
    void testAngleVers() {
        Coordonnees coordonnees = new Coordonnees(1, 1);
        Coordonnees coordonnees2 = new Coordonnees(0, 1);
        Coordonnees coordonnees3 = new Coordonnees(1, 0);
        Coordonnees coordonnees4 = new Coordonnees(2, 2);
        assertEquals(0, coordonnees.angleVers(coordonnees2), "L'angle entre les coordonnées doit être égal à 0");
        assertEquals(-Math.PI / 2, coordonnees.angleVers(coordonnees3),
                "L'angle entre les coordonnées doit être égal à -pi/2");
        assertEquals(Math.PI / 4, coordonnees.angleVers(coordonnees4),
                "L'angle entre les coordonnées doit être égal à pi/4");
    }

    @Test
    void testDeplacerDe() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        coordonnees.deplacerDe(1, 1);
        assertEquals(1, coordonnees.getAbscisse(), "La coordonnée X doit être égale à 1");
        assertEquals(1, coordonnees.getOrdonnee(), "La coordonnée Y doit être égale à 1");
    }

    @Test
    void testDeplacerVers() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        coordonnees.deplacerVers(1, 1);
        assertEquals(1, coordonnees.getAbscisse(), "La coordonnée X doit être égale à 1");
        assertEquals(1, coordonnees.getOrdonnee(), "La coordonnée Y doit être égale à 1");
    }

    @Test
    void testDistanceVers() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        Coordonnees coordonnees2 = new Coordonnees(1, 1);
        assertEquals(Math.sqrt(2), coordonnees.distanceVers(coordonnees2),
                "La distance entre les deux coordonnées doit être égale à √2");
    }

    @Test
    void testGetAbscisse() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        assertEquals(0, coordonnees.getAbscisse(), "La coordonnée X doit être égale à 0");
    }

    @Test
    void testGetOrdonnee() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        assertEquals(0, coordonnees.getOrdonnee(), "La coordonnée Y doit être égale à 0");
    }

    @Test
    void testSetAbscisse() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        coordonnees.setAbscisse(1);
        assertEquals(1, coordonnees.getAbscisse(), "La coordonnée X doit être égale à 1");
    }

    @Test
    void testSetOrdonnee() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        coordonnees.setOrdonnee(1);
        assertEquals(1, coordonnees.getOrdonnee(), "La coordonnée Y doit être égale 1");
    }

    @Test
    void testToString() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        assertEquals("(0,0 , 0,0)", coordonnees.toString(), "La chaîne de caractères doit être égale à '(0,0 , 0,0)'");
    }

    @Test
    void testEquals() {
        Coordonnees coordonnees = new Coordonnees(0, 0);
        Coordonnees coordonnees2 = new Coordonnees(0, 0);
        Coordonnees coordonnees3 = new Coordonnees(1, 0);
        Coordonnees coordonnees4 = new Coordonnees(0, 1);
        assertEquals(true, coordonnees.equals(coordonnees2), "Les coordonnées doivent être égales");
        assertEquals(false, coordonnees.equals(null), "Les coordonnées doivent être différentes de null");
        //assertEquals(false, coordonnees.equals(8), "Le type est different");
        assertEquals(false, coordonnees.equals(coordonnees3), "Les coordonnées doivent être différentes");
        assertEquals(false, coordonnees.equals(coordonnees4), "Les coordonnées doivent être différentes");
    }
}
