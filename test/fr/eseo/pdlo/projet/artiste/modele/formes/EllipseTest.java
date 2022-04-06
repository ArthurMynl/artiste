package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class EllipseTest {

    @Test
    void testEllipse() {
        Ellipse ellipse = new Ellipse();
        assertEquals(0, ellipse.getPosition().getAbscisse());
        assertEquals(0, ellipse.getPosition().getOrdonnee());
        assertEquals(150, ellipse.getLargeur());
        assertEquals(200, ellipse.getHauteur());
    }

    @Test
    void testEllipse2() {
        Ellipse ellipse = new Ellipse(new Coordonnees(10, 10));
        assertEquals(10, ellipse.getPosition().getAbscisse());
        assertEquals(10, ellipse.getPosition().getOrdonnee());
        assertEquals(150, ellipse.getLargeur());
        assertEquals(200, ellipse.getHauteur());
    }

    @Test
    void testEllipse3() {
        Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 20, 20);
        assertEquals(10, ellipse.getPosition().getAbscisse());
        assertEquals(10, ellipse.getPosition().getOrdonnee());
        assertEquals(20, ellipse.getLargeur());
        assertEquals(20, ellipse.getHauteur());
    }

    @Test
    void testEllipse4() {
        Ellipse ellipse = new Ellipse(10, 20);
        assertEquals(0, ellipse.getPosition().getAbscisse());
        assertEquals(0, ellipse.getPosition().getOrdonnee());
        assertEquals(10, ellipse.getLargeur());
        assertEquals(20, ellipse.getHauteur());
    }

    @Test
    void testAire() {
        Ellipse ellipse = new Ellipse(2, 2);
        assertEquals(Math.PI, ellipse.aire());
    }

    @Test
    void testPerimetre() {
        Ellipse ellipse = new Ellipse(1, 2);
        Ellipse ellipse2 = new Ellipse(2, 1);
        assertEquals(4.844224, ellipse.perimetre(), 0.001);
        assertEquals(4.844224, ellipse2.perimetre(), 0.001);
    }

    @Test
    void testSetHauteur() {
        Ellipse ellipse = new Ellipse();
        ellipse.setHauteur(10);
        assertEquals(10, ellipse.getHauteur());
        assertThrows(IllegalArgumentException.class, () -> {
            ellipse.setHauteur(-1);
        });
    }

    @Test
    void testSetLargeur() {
        Ellipse ellipse = new Ellipse();
        ellipse.setLargeur(10);
        assertEquals(10, ellipse.getLargeur());
        assertThrows(IllegalArgumentException.class, () -> {
            ellipse.setLargeur(-1);
        });
    }

    @Test
    void testToString() {
        Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
        Ellipse ellipse2 = new Ellipse(new Coordonnees(10, 10), 15, 25);
        assertEquals("[Ellipse] : pos (10,0 , 10,0) petit rayon 7,5 grand rayon 12,5 périmètre : 63,82 aire : 294,52",
                ellipse.toString());
        assertEquals("[Ellipse] : pos (10,0 , 10,0) petit rayon 7,5 grand rayon 12,5 périmètre : 63,82 aire : 294,52",
                ellipse2.toString());
    }

    @Test
    void testContient() {
        Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 25, 15);
        Ellipse ellipse2 = new Ellipse(new Coordonnees(10, 10), 15, 25);
        assertEquals(true, ellipse.contient(new Coordonnees(15, 15)));
        assertEquals(false, ellipse.contient(new Coordonnees(15, 25)));
        assertEquals(true, ellipse.contient(new Coordonnees(25, 15)));
        assertEquals(true, ellipse2.contient(new Coordonnees(15, 15)));
        assertEquals(true, ellipse2.contient(new Coordonnees(15, 25)));
        assertEquals(false, ellipse2.contient(new Coordonnees(25, 15)));
    }
}
