package fr.eseo.pdlo.projet.artiste.vue.ihm;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class PanneauBarreEtat extends JPanel implements java.awt.event.MouseMotionListener {
    private JLabel valeurX;
    private JLabel valeurY;

    public PanneauBarreEtat(PanneauDessin panneauDessin) {
        setLayout(new java.awt.FlowLayout());
        valeurX = new JLabel("x: 0");
        valeurY = new JLabel("y: 0");
        add(valeurX);
        add(valeurY);
        panneauDessin.addMouseMotionListener(this);
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        Coordonnees coordonnees = new Coordonnees(event.getX(), event.getY());
        mettreAJourAffichage(coordonnees);
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        Coordonnees coordonnees = new Coordonnees(event.getX(), event.getY());
        mettreAJourAffichage(coordonnees);
    }

    
    private void mettreAJourAffichage(Coordonnees coordonnees) { 
        valeurX.setText("x: " + coordonnees.getAbscisse());
        valeurY.setText("y: " + coordonnees.getOrdonnee());
    }

}
