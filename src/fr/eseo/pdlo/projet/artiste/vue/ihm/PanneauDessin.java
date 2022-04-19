package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.eseo.pdlo.projet.artiste.controleur.outils.Outil;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class PanneauDessin extends JPanel {
    public static final int LARGEUR_PAR_DEFAUT = 600;
    public static final int HAUTEUR_PAR_DEFAUT = 400;
    public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(255, 255, 255);

    private final List<VueForme> vueFormes = new ArrayList<VueForme>();

    private VueForme vueFormeTemporaire;

    private Outil outilCourant;
    private Color couleurCourante;
    private Remplissage modeRemplissageCourant;
    private Color couleurRemplissageCourante;
    private Color[] couleurDegrade;
    private boolean aliasing;
    private boolean grille;

    public PanneauDessin() {
        this.setPreferredSize(new Dimension(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT));
        this.setBackground(COULEUR_FOND_PAR_DEFAUT);
        this.setCouleurCourante(Forme.COULEUR_PAR_DEFAUT);
        this.setCouleurRemplissageCourante(Forme.COULEUR_PAR_DEFAUT);
        this.setCouleurDegrade(new Color[] { Forme.COULEUR_PAR_DEFAUT, Forme.COULEUR_PAR_DEFAUT });
        this.setModeRemplissageCourant(Remplissage.AUCUNE);
        this.setAliasing(false);
        this.vueFormeTemporaire = null;
        this.grille = false;
    }

    public PanneauDessin(int largeur, int hauteur, Color couleur) {
        this.setPreferredSize(new Dimension(largeur, hauteur));
        this.setBackground(couleur);
        this.setCouleurCourante(Forme.COULEUR_PAR_DEFAUT);
        this.setCouleurRemplissageCourante(Forme.COULEUR_PAR_DEFAUT);
        this.setModeRemplissageCourant(Remplissage.AUCUNE);
        this.setCouleurDegrade(new Color[] { Forme.COULEUR_PAR_DEFAUT, Forme.COULEUR_PAR_DEFAUT });
        this.setAliasing(false);
        this.vueFormeTemporaire = null;
        this.grille = false;
    }

    public void setGrille() {
        this.grille = !this.grille;
        this.repaint();
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
        if (this.grille) {
            g2D.setColor(new Color(230, 230, 230));
            for (int i = 0; i < this.getWidth(); i += (int) getWidth() / 40) {
                g2D.drawLine(i, 0, i, this.getHeight());
            }
            for (int i = 0; i < this.getHeight(); i += (int) getHeight() / 40) {
                g2D.drawLine(0, i, (int) this.getWidth(), i);
            }
        }
        for (VueForme vueForme : vueFormes) {
            vueForme.affiche(g2D);
        }
        if (vueFormeTemporaire != null) {
            vueFormeTemporaire.affiche(g2D);
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
        this.addMouseMotionListener(outil);
    }

    public void dissocierOutil() {
        this.removeMouseListener(this.getOutilCourant());
        this.removeMouseMotionListener(this.getOutilCourant());
        setOutilCourant(null);
    }

    public Outil getOutilCourant() {
        return outilCourant;
    }

    private void setOutilCourant(Outil outil) {
        outilCourant = outil;
    }

    public Color getCouleurCourante() {
        return couleurCourante;
    }

    public void setCouleurCourante(Color couleur) {
        couleurCourante = couleur;
    }

    public void setCouleurRemplissageCourante(Color couleur) {
        couleurRemplissageCourante = couleur;
    }

    public Color getCouleurRemplissageCourante() {
        return couleurRemplissageCourante;
    }

    public Remplissage getModeRemplissageCourant() {
        return modeRemplissageCourant;
    }

    public void setModeRemplissageCourant(Remplissage remplissage) {
        this.modeRemplissageCourant = remplissage;
    }

    public void setAliasing(boolean aliasing) {
        this.aliasing = aliasing;
    }

    public boolean getAliasing() {
        return aliasing;
    }

    public void setVueFormeTemporaire(VueForme vueForme) {
        this.vueFormeTemporaire = vueForme;
    }

    public VueForme getVueFormeTemporaire() {
        return vueFormeTemporaire;
    }

    public void setCouleurDegrade(Color[] couleur) {
        this.couleurDegrade = couleur;
    }

    public Color[] getCouleurDegrade() {
        return couleurDegrade;
    }
}
