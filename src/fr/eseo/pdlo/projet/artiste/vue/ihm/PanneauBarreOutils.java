package fr.eseo.pdlo.projet.artiste.vue.ihm;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirModeRemplissage;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class PanneauBarreOutils extends JPanel {

    PanneauDessin panneauDessin;

    public PanneauBarreOutils(PanneauDessin panneauDessin) {
        super();
        this.panneauDessin = panneauDessin;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents();
    }

    private void initComponents() {
        ButtonGroup buttonGroup = new ButtonGroup();
        ButtonGroup boutonsRemplissage = new ButtonGroup();

        JToggleButton boutonLigne = new JToggleButton(
                new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_LIGNE));
        JToggleButton boutonEllipse = new JToggleButton(
                new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_ELLIPSE));
        JToggleButton boutonCercle = new JToggleButton(
                new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_CERCLE));
        JToggleButton boutonSelectionner = new JToggleButton(new ActionSelectionner(panneauDessin));

        JButton boutonEfface = new JButton(new ActionEffacer(panneauDessin));
        JButton boutonCouleur = new JButton(new ActionChoisirCouleur(panneauDessin));

        JToggleButton boutonRemplissageUniforme = new JToggleButton(
                new ActionChoisirModeRemplissage(panneauDessin, Remplissage.UNIFORME));
        JToggleButton boutonRemplissageAucun = new JToggleButton(
                new ActionChoisirModeRemplissage(panneauDessin, Remplissage.AUCUNE));

        boutonLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
        boutonEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
        boutonCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
        boutonEfface.setName(ActionEffacer.NOM_ACTION);
        boutonCouleur.setName(ActionChoisirCouleur.NOM_ACTION);
        boutonRemplissageUniforme.setName(ActionChoisirModeRemplissage.NOM_ACTION_REMPLISSAGE_UNIFORME);
        boutonRemplissageAucun.setName(ActionChoisirModeRemplissage.NOM_ACTION_REMPLISSAGE_AUCUNE);

        boutonRemplissageAucun.setSelected(true);

        boutonSelectionner.setName(ActionSelectionner.NOM_ACTION);
        boutonSelectionner.setText(ActionSelectionner.NOM_ACTION);

        buttonGroup.add(boutonLigne);
        buttonGroup.add(boutonEllipse);
        buttonGroup.add(boutonCercle);
        buttonGroup.add(boutonSelectionner);

        boutonsRemplissage.add(boutonRemplissageAucun);
        boutonsRemplissage.add(boutonRemplissageUniforme);

        this.add(boutonLigne);
        this.add(boutonEllipse);
        this.add(boutonCercle);
        this.add(boutonEfface);
        this.add(boutonSelectionner);
        this.add(boutonCouleur);
        this.add(boutonRemplissageAucun);
        this.add(boutonRemplissageUniforme);
    }

}
