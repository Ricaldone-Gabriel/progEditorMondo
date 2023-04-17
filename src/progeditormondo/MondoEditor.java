/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progeditormondo;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author gabriel.ricaldone
 */
public class MondoEditor {

    public Piattaforma casella;
    public JPanel casellaEditor;
    int posX,posY;
    MondoEditor(String terreno, int i, int j) {
        casella = new Piattaforma(terreno, i, j);
        casellaEditor = new JPanel();
        casellaEditor.setBackground(terrainColor(terreno));
    }

    public void modify(String terreno) {
        casella.terreno = terreno;
        casellaEditor.setBackground(terrainColor(terreno));
    }
    
    public Color terrainColor(String terreno) {
        Color colore;
        switch (terreno) {
            case "acquaP":
                colore = new Color(47, 54, 153);
                break;
            case "acqua":
                colore = new Color(77, 109, 243);
                break;
            case "acquaS":
                colore = new Color(153, 217, 234);
                break;
            case "erbaC":
                colore = new Color(168, 230, 29);
                break;
            case "erba":
                colore = new Color(34, 177, 76);
                break;
            case "terra":
                colore = new Color(155, 90, 60);
                break;
            case "muro":
                colore = new Color(90,90,90);
                break;
            case "nemico":
                colore = Color.red;
                break;
            default:
                colore = new Color(0, 0, 0);
                break;
        }
        return colore;
    }
}
