package fr.eseo.pdlo.projet.artiste.modele.formes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class RectangleTest {

    @Test
    void testRectangle() {
        Rectangle rectangle = new Rectangle();
        assertEquals(0, rectangle.getPosition().getAbscisse());
        assertEquals(0, rectangle.getPosition().getOrdonnee());
        assertEquals(190, rectangle.getLargeur());
        assertEquals(150, rectangle.getHauteur());
    }

    @Test
    void testRectangle2() {
        Rectangle rectangle = new Rectangle(new Coordonnees(10, 10));
        assertEquals(10, rectangle.getPosition().getAbscisse());
        assertEquals(10, rectangle.getPosition().getOrdonnee());
        assertEquals(190, rectangle.getLargeur());
        assertEquals(150, rectangle.getHauteur());
    }

    @Test
    void testRectangle3() {
        Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 20, 20);
        assertEquals(10, rectangle.getPosition().getAbscisse());
        assertEquals(10, rectangle.getPosition().getOrdonnee());
        assertEquals(20, rectangle.getLargeur());
        assertEquals(20, rectangle.getHauteur());
    }

    @Test
    void testRectangle4() {
        Rectangle rectangle = new Rectangle(10, 20);
        assertEquals(0, rectangle.getPosition().getAbscisse());
        assertEquals(0, rectangle.getPosition().getOrdonnee());
        assertEquals(10, rectangle.getLargeur());
        assertEquals(20, rectangle.getHauteur());
    }

    @Test
    void testAire() {
        Rectangle rectangle = new Rectangle(new Coordonnees(0, 0), 10, 10);
        assertEquals(rectangle.aire(), 100);
    }

    @Test
    void testContient() {
        Rectangle rectangle = new Rectangle(new Coordonnees(0, 0), 10, 10);
        assertEquals(rectangle.contient(new Coordonnees(0, 0)), true);
        assertEquals(rectangle.contient(new Coordonnees(10, 10)), true);
        assertEquals(rectangle.contient(new Coordonnees(10, 0)), true);
        assertEquals(rectangle.contient(new Coordonnees(0, 10)), true);
        assertEquals(rectangle.contient(new Coordonnees(11, 11)), false);
    }

    @Test
    void testGetRemplissage() {
        Rectangle rectangle = new Rectangle(new Coordonnees(0, 0), 10, 10);
        assertEquals(rectangle.getRemplissage(), Remplissage.AUCUNE);
    }

    @Test
    void testPerimetre() {
        Rectangle rectangle = new Rectangle(new Coordonnees(0, 0), 10, 10);
        assertEquals(rectangle.perimetre(), 40);
    }

    @Test
    void testSetHauteur() {
        Rectangle rectangle = new Rectangle(new Coordonnees(0, 0), 10, 10);
        rectangle.setHauteur(20);
        assertEquals(rectangle.getHauteur(), 20);
    }

    @Test
    void testSetLargeur() {
        Rectangle rectangle = new Rectangle(new Coordonnees(0, 0), 10, 10);
        rectangle.setLargeur(20);
        assertEquals(rectangle.getLargeur(), 20);
    }

    @Test
    void testSetRemplissage() {
        Rectangle rectangle = new Rectangle(new Coordonnees(0, 0), 10, 10);
        rectangle.setRemplissage(Remplissage.UNIFORME);
        assertEquals(rectangle.getRemplissage(), Remplissage.UNIFORME);
    }

    @Test
    void testToString() {
        Rectangle rectangle = new Rectangle(new Coordonnees(0, 0), 10, 10);
        assertEquals(rectangle.toString(),
                "[Rectangle aucune] : pos (0,0 , 0,0) largeur 10,0 hauteur 10,0 périmètre : 40,0 aire : 100,0 couleur = R0,V0,B0");
    }
}
