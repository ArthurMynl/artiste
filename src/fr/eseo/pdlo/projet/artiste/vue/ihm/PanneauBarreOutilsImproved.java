package fr.eseo.pdlo.projet.artiste.vue.ihm;

import javax.swing.JToolBar;

public class PanneauBarreOutilsImproved extends JToolBar {

    private 

    public PanneauBarreOutilsImproved(PanneauDessin panneauDessin) {
        super();
        this.panneauDessin = panneauDessin;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents();
}
}
