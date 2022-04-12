package fr.eseo.pdlo.projet.artiste.vue.ihm;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;

public class PanneauBarreOutils extends JPanel {

    PanneauDessin panneauDessin;

    public PanneauBarreOutils(PanneauDessin panneauDessin) {
        super();
        this.panneauDessin = panneauDessin;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        initComponents();
    }

    private void initComponents() {
        ButtonGroup buttonGroup = new ButtonGroup();
        JToggleButton boutonLigne = new JToggleButton(
                new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.ACTION_LIGNE));
        JToggleButton boutonEllipse = new JToggleButton(
                new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.ACTION_ELLIPSE));
        JToggleButton boutonCercle = new JToggleButton(
                new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.ACTION_CERCLE));
        JToggleButton boutonSelectionner = new JToggleButton(new ActionSelectionner(panneauDessin));
        JButton boutonEfface = new JButton(new ActionEffacer(panneauDessin));


        boutonLigne.setText(ActionChoisirForme.ACTION_LIGNE);
        boutonEllipse.setText(ActionChoisirForme.ACTION_ELLIPSE);
        boutonCercle.setText(ActionChoisirForme.ACTION_CERCLE);
        boutonEfface.setText(ActionEffacer.NOM_ACTION);
        boutonSelectionner.setText(ActionSelectionner.NOM_ACTION);

        buttonGroup.add(boutonLigne);
        buttonGroup.add(boutonEllipse);
        buttonGroup.add(boutonCercle);

        panneauDessin.add(boutonLigne);
        panneauDessin.add(boutonEllipse);
        panneauDessin.add(boutonCercle);
        panneauDessin.add(boutonEfface);
        panneauDessin.add(boutonSelectionner);
    }

}
