package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.eseo.pdlo.projet.artiste.controleur.outils.Outil;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class PanneauDessin extends JPanel {
    public static final int LARGEUR_PAR_DEFAUT = 600;
    public static final int HAUTEUR_PAR_DEFAUT = 400;
    public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(255, 255, 255);

    private final List<VueForme> vueFormes = new ArrayList<VueForme>();
    
    private Outil outilCourant;

    public PanneauDessin() {
        this.setPreferredSize(new Dimension(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT));
        this.setBackground(COULEUR_FOND_PAR_DEFAUT);
    }

    public PanneauDessin(int largeur, int hauteur, Color couleur) {
        this.setPreferredSize(new Dimension(largeur, hauteur));
        this.setBackground(couleur);
    }

    public List<VueForme> getVueFormes() { 
        return vueFormes;
    }

    public void ajouterVueForme(VueForme vueForme) {
        this.vueFormes.add(vueForme);
    }

    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        java.awt.Graphics2D g2D = (java.awt.Graphics2D) g.create();
        for (VueForme vueForme : vueFormes) {
            vueForme.affiche(g2D);
        }
        g2D.dispose();
    }
    
    public void associerOutil(Outil outil) {
        if (getOutilCourant() != null) {
            this.dissocierOutil();
        }
        outil.setPanneauDessin(this);
        setOutilCourant(outil);
        this.addMouseListener(outil);
    }

    public void dissocierOutil() {
        this.removeMouseListener(this.getOutilCourant());
        setOutilCourant(null);
    }

    public Outil getOutilCourant() {
        return outilCourant;
    }

    private void setOutilCourant(Outil outil) {
        outilCourant = outil;
    }

}
