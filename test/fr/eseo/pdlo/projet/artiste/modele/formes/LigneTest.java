package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class LigneTest {

    LigneTest() {
    }

    @Test
    void testLigne() {
        Ligne ligne = new Ligne();
        assertEquals(0, ligne.getPosition().getAbscisse());
        assertEquals(0, ligne.getPosition().getOrdonnee());
        assertEquals(150, ligne.getLargeur());
        assertEquals(200, ligne.getHauteur());
    }

    @Test
    void testLigne2() {
        Ligne ligne = new Ligne(new Coordonnees(10, 10));
        assertEquals(10, ligne.getPosition().getAbscisse());
        assertEquals(10, ligne.getPosition().getOrdonnee());
        assertEquals(150, ligne.getLargeur());
        assertEquals(200, ligne.getHauteur());
    }

    @Test
    void testLigne3() {
        Ligne ligne = new Ligne(new Coordonnees(10, 10), 20, 20);
        assertEquals(10, ligne.getPosition().getAbscisse());
        assertEquals(10, ligne.getPosition().getOrdonnee());
        assertEquals(20, ligne.getLargeur());
        assertEquals(20, ligne.getHauteur());
    }

    @Test
    void testLigne4() {
        Ligne ligne = new Ligne(10, 20);
        assertEquals(0, ligne.getPosition().getAbscisse());
        assertEquals(0, ligne.getPosition().getOrdonnee());
        assertEquals(10, ligne.getLargeur());
        assertEquals(20, ligne.getHauteur());
    }

    @Test
    void testAire() {
        Ligne ligne = new Ligne();
        assertEquals(0, ligne.aire());
    }

    @Test
    void testDeplacerDe() {
        Ligne ligne = new Ligne();
        ligne.deplacerDe(1, 1);
        assertEquals(1, ligne.getPosition().getAbscisse());
        assertEquals(1, ligne.getPosition().getOrdonnee());
    }

    @Test
    void testDeplacerVers() {
        Ligne ligne = new Ligne();
        ligne.deplacerVers(1, 1);
        assertEquals(1, ligne.getPosition().getAbscisse());
        assertEquals(1, ligne.getPosition().getOrdonnee());
    }

    @Test
    void testGetC1() {
        Ligne ligne = new Ligne();
        assertEquals(0, ligne.getC1().getAbscisse());
        assertEquals(0, ligne.getC1().getOrdonnee());
    }

    @Test
    void testGetC2() {
        Ligne ligne = new Ligne();
        assertEquals(Forme.LARGEUR_PAR_DEFAUT, ligne.getC2().getAbscisse());
        assertEquals(Forme.HAUTEUR_PAR_DEFAUT, ligne.getC2().getOrdonnee());
    }

    @Test
    void testPerimetre() {
        Ligne ligne = new Ligne(3, 4);
        assertEquals(5, ligne.perimetre());
    }

    @Test
    void testSetC1() {
        Ligne ligne = new Ligne();
        ligne.setC1(new Coordonnees(1, 1));
        assertEquals(1, ligne.getC1().getAbscisse());
        assertEquals(1, ligne.getC1().getOrdonnee());
    }

    @Test
    void testSetC2() {
        Ligne ligne = new Ligne();
        ligne.setC2(new Coordonnees(1, 1));
        assertEquals(1, ligne.getC2().getAbscisse());
        assertEquals(1, ligne.getC2().getOrdonnee());
    }

    @Test
    void testToString() {
        Ligne ligne = new Ligne(new Coordonnees(10, 10), -5, 20);
        Ligne ligne2 = new Ligne(new Coordonnees(10, 10), 5, -20);
        assertEquals("[Ligne] c1 : (10,0 , 10,0) c2 : (15,0 , -10,0) longueur : 20,62 angle : 284,04°",
                ligne2.toString());
        assertEquals("[Ligne] c1 : (10,0 , 10,0) c2 : (5,0 , 30,0) longueur : 20,62 angle : 104,04°", ligne.toString());
    }

    @Test
    void testGetCadreMinX() {
        Ligne ligne = new Ligne(new Coordonnees(10, 10), -5, -20);
        assertEquals(5, ligne.getCadreMinX());
    }

    @Test
    void testGetCadreMinY() {
        Ligne ligne = new Ligne(new Coordonnees(10, 10), -5, -20);
        assertEquals(-10, ligne.getCadreMinY());
    }

    @Test
    void testGetCadreMaxX() {
        Ligne ligne = new Ligne(new Coordonnees(10, 10), -5, -20);
        assertEquals(10, ligne.getCadreMaxX());
    }

    @Test
    void testGetCadreMaxY() {
        Ligne ligne = new Ligne(new Coordonnees(10, 10), -5, -20);
        assertEquals(10, ligne.getCadreMaxY());
    }

    @Test
    void testContient() {
        Ligne ligne = new Ligne(0, 2);
        Ligne ligne2 = new Ligne(0, -2);
        assertEquals(true, ligne.contient(new Coordonnees(0, 0)));
        assertEquals(true, ligne.contient(new Coordonnees(0, 2)));
        assertEquals(false, ligne.contient(new Coordonnees(2, 2)));
        assertEquals(true, ligne2.contient(new Coordonnees(0, -2)));
        assertEquals(true, ligne2.contient(new Coordonnees(0, 0)));
        assertEquals(false, ligne2.contient(new Coordonnees(2, -2)));
    }
}
