package fr.eseo.pdlo.projet.artiste.vue.ihm;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionEffacer;

public class PanneauBarreOutilsImproved extends JToolBar {

    private PanneauDessin panneauDessin;

    public PanneauBarreOutilsImproved(PanneauDessin panneauDessin) {
        super();
        this.panneauDessin = panneauDessin;
        this.setOrientation(VERTICAL);
        this.ajouterOutils();
    }

    public void ajouterOutils() {
        JButton buttonEfface = new JButton();
        buttonEfface.setAction(new ActionEffacer(panneauDessin));
        buttonEfface.setName(ActionEffacer.NOM_ACTION);
        this.add(buttonEfface);

        JComboBox<String> comboBox = new JComboBox<String>(
                new String[] { ActionChoisirForme.NOM_ACTION_CARRE,
                        ActionChoisirForme.NOM_ACTION_CERCLE,
                        ActionChoisirForme.NOM_ACTION_ELLIPSE,
                        ActionChoisirForme.NOM_ACTION_LIGNE,
                        ActionChoisirForme.NOM_ACTION_RECTANGLE });
        comboBox.getSelectedIndex();
        this.add(comboBox);
    }
}
