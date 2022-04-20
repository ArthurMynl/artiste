package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionEnregistrer extends AbstractAction {

    private PanneauDessin panneauDessin;
    public static final String NOM_ACTION = "Enregistrer";

    public ActionEnregistrer(PanneauDessin panneauDessin) {
        super("Enregistrer");
        this.panneauDessin = panneauDessin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BufferedImage image = new BufferedImage(panneauDessin.getWidth(), panneauDessin.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        panneauDessin.update(g);
        g.dispose();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Enregistrer");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.showSaveDialog(panneauDessin);
        
        File file = fileChooser.getSelectedFile();
        File file2 = new File(file.getAbsolutePath() + ".png");

        try {
            ImageIO.write(image, "png", file2);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
