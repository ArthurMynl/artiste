package fr.eseo.pdlo.projet.artiste.vue.ihm;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirAntialiasing;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirCouleurRemplissage;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirModeRemplissage;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionDeplacerForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionGomme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionResizeForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionRotationForme;
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
                initBoutonsOutils();
                initBoutonsActionsIndependantes();
        }

        private void initBoutonsActionsIndependantes() {
                ButtonGroup boutonsRemplissage = new ButtonGroup();

                JToggleButton boutonRemplissageUniforme = new JToggleButton(
                                new ActionChoisirModeRemplissage(panneauDessin, Remplissage.UNIFORME));
                JToggleButton boutonRemplissageAucun = new JToggleButton(
                                new ActionChoisirModeRemplissage(panneauDessin, Remplissage.AUCUNE));
                JToggleButton boutonRemplissageDegrade = new JToggleButton(
                                new ActionChoisirModeRemplissage(panneauDessin, Remplissage.DEGRADE));
                
                boutonRemplissageUniforme.setName(ActionChoisirModeRemplissage.NOM_ACTION_REMPLISSAGE_UNIFORME);
                boutonRemplissageAucun.setName(ActionChoisirModeRemplissage.NOM_ACTION_REMPLISSAGE_AUCUNE);
                boutonRemplissageDegrade.setName(ActionChoisirModeRemplissage.NOM_ACTION_REMPLISSAGE_DEGRADE);

                boutonRemplissageAucun.setSelected(true);

                boutonsRemplissage.add(boutonRemplissageAucun);
                boutonsRemplissage.add(boutonRemplissageUniforme);
                boutonsRemplissage.add(boutonRemplissageDegrade);

                this.add(boutonRemplissageAucun);
                this.add(boutonRemplissageUniforme);
                this.add(boutonRemplissageDegrade);

                // boutons action indépendantes
                JButton boutonEfface = new JButton(new ActionEffacer(panneauDessin));
                JButton boutonCouleur = new JButton(new ActionChoisirCouleur(panneauDessin));
                JButton boutonCouleurRemplissage = new JButton(new ActionChoisirCouleurRemplissage(panneauDessin));
                JToggleButton boutonAliasing = new JToggleButton(new ActionChoisirAntialiasing(panneauDessin));

                boutonEfface.setName(ActionEffacer.NOM_ACTION);
                boutonCouleur.setName(ActionChoisirCouleur.NOM_ACTION);
                boutonCouleurRemplissage.setName(ActionChoisirCouleurRemplissage.NOM_ACTION);
                boutonAliasing.setName(ActionChoisirAntialiasing.NOM_ACTION);

                this.add(boutonEfface);
                this.add(boutonCouleur);
                this.add(boutonAliasing);
                this.add(boutonCouleurRemplissage);
        }
        

        private void initBoutonsOutils() {
                ButtonGroup buttonGroup = new ButtonGroup();

                JToggleButton boutonLigne = new JToggleButton(
                                new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_LIGNE));
                JToggleButton boutonEllipse = new JToggleButton(
                                new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_ELLIPSE));
                JToggleButton boutonCercle = new JToggleButton(
                                new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_CERCLE));
                JToggleButton boutonRectangle = new JToggleButton(
                                new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_RECTANGLE));
                JToggleButton boutonCarre = new JToggleButton(
                                new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_CARRE));
                JToggleButton boutonSelectionner = new JToggleButton(new ActionSelectionner(panneauDessin));
                JToggleButton boutonGomme = new JToggleButton(new ActionGomme(panneauDessin));
                JToggleButton boutonTrace = new JToggleButton(
                                new ActionChoisirForme(panneauDessin, this, ActionChoisirForme.NOM_ACTION_TRACE));
                JToggleButton boutonDeplacer = new JToggleButton(new ActionDeplacerForme(panneauDessin));
                JToggleButton boutonResize = new JToggleButton(new ActionResizeForme(panneauDessin));
                JToggleButton boutonRotation = new JToggleButton(new ActionRotationForme(panneauDessin));

                boutonLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
                boutonEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
                boutonCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
                boutonRectangle.setName(ActionChoisirForme.NOM_ACTION_RECTANGLE);
                boutonCarre.setName(ActionChoisirForme.NOM_ACTION_CARRE);
                boutonSelectionner.setName(ActionSelectionner.NOM_ACTION);
                boutonSelectionner.setText(ActionSelectionner.NOM_ACTION);
                boutonGomme.setName(ActionGomme.NOM_ACTION);
                boutonGomme.setText(ActionGomme.NOM_ACTION);
                boutonTrace.setName(ActionChoisirForme.NOM_ACTION_TRACE);
                boutonDeplacer.setName(ActionDeplacerForme.NOM_ACTION);
                boutonResize.setName(ActionResizeForme.NOM_ACTION);
                boutonRotation.setName(ActionRotationForme.NOM_ACTION);


                buttonGroup.add(boutonLigne);
                buttonGroup.add(boutonEllipse);
                buttonGroup.add(boutonCercle);
                buttonGroup.add(boutonRectangle);
                buttonGroup.add(boutonCarre);
                buttonGroup.add(boutonSelectionner);
                buttonGroup.add(boutonGomme);
                buttonGroup.add(boutonTrace);
                buttonGroup.add(boutonDeplacer);
                buttonGroup.add(boutonResize);
                buttonGroup.add(boutonRotation);

                this.add(boutonLigne);
                this.add(boutonEllipse);
                this.add(boutonCercle);
                this.add(boutonRectangle);
                this.add(boutonCarre);
                this.add(boutonTrace);
                this.add(boutonGomme);
                this.add(boutonSelectionner);
                this.add(boutonDeplacer);
                this.add(boutonResize);
                this.add(boutonRotation);
        }
}
