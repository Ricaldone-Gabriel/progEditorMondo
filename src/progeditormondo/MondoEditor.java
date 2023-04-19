/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progeditormondo;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author gabriel.ricaldone
 */
public class MondoEditor {

    public Piattaforma casella;
    public JPanel casellaEditor;
    public Nemico nemico;
    int posX, posY;

    private JTextField domanda;

    private ArrayList<JCheckBox> check;
    private ArrayList<JTextField> risposte;
    private ArrayList<JPanel> contRisp;

    private JButton aggiungiRisp;

    private JPanel pannelloPopUp;

    public boolean nem;

    MondoEditor(String terreno, int i, int j) {
        casella = new Piattaforma(terreno, i, j);

        posX = i;
        posY = j;

        nemico = null;
        nem = false;
        casellaEditor = new JPanel();
        casellaEditor.setBackground(terrainColor(terreno));

        check = new ArrayList<JCheckBox>();
        risposte = new ArrayList<JTextField>();
        contRisp = new ArrayList<JPanel>();

        domanda = new JTextField(15);
        check.add(new JCheckBox());
        risposte.add(new JTextField(15));
        contRisp.add(new JPanel());
        contRisp.get(0).setLayout(new FlowLayout());

        aggiungiRisp = new JButton("Aggiungi risposta");
        aggiungiRisp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check.add(new JCheckBox());
                risposte.add(new JTextField(15));
                contRisp.add(new JPanel());

                contRisp.get(contRisp.size() - 1).setLayout(new FlowLayout());
                contRisp.get(contRisp.size() - 1).add(new JLabel("Riposta " + risposte.size() + ":"));
                contRisp.get(contRisp.size() - 1).add(check.get(check.size() - 1));
                contRisp.get(contRisp.size() - 1).add(risposte.get(risposte.size() - 1));
                pannelloPopUp.add(contRisp.get(contRisp.size() - 1));

                SwingUtilities.getWindowAncestor((Component) e.getSource()).pack();
            }
        });

        pannelloPopUp = new JPanel();
        pannelloPopUp.setLayout(new BoxLayout(pannelloPopUp, BoxLayout.Y_AXIS));
        pannelloPopUp.add(new JLabel("Domanda:"));
        pannelloPopUp.add(domanda);
        pannelloPopUp.add(aggiungiRisp);

        contRisp.get(0).add(new JLabel("Riposta 1:"));
        contRisp.get(0).add(check.get(0));
        contRisp.get(0).add(risposte.get(0));
        pannelloPopUp.add(contRisp.get(0));

    }

    public void modify(String terreno) {
        if (!(terreno.equals("cancella") || terreno.equals("nemico"))) {
            casella.terreno = terreno;
        } else if (!terreno.equals("nemico")){
            casella.terreno = "terra";
            nemico = null;
            nem = false;
        }
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
                colore = new Color(90, 90, 90);
                break;
            case "nemico":
                creaNemico();

                if (nem) {
                    colore = Color.red;
                } else {
                    colore = new Color(155, 90, 60);
                }
                System.out.println(terreno);
                break;
            case "nemicoC":
                colore = Color.red;
                nem = true;
                break;
            case "cancella":
                colore = new Color(155, 90, 60);
                break;
            default:
                colore = new Color(0, 0, 0);
                break;
        }
        return colore;
    }

    private void creaNemico() {
        
        creaPopUp();
        pulisciPopUp();
    }

    private void creaPopUp() {
        int result;

        String domandaTemp;
        ArrayList<String> risposteTemp = new ArrayList<String>();
        ArrayList<Boolean> corretteTemp = new ArrayList<Boolean>();

        result = JOptionPane.showConfirmDialog(null, pannelloPopUp,
                "Aggiungi nemico", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println(posX + " " + posY);
            if (!(domanda.getText().matches("\\p{IsWhite_Space}*") || domanda.getText().isEmpty())) {
                domandaTemp = domanda.getText();

                for (JTextField risposta : risposte) {
                    risposteTemp.add(risposta.getText());
                }
                for (JCheckBox checkSing : check) {
                    corretteTemp.add(checkSing.isSelected());
                }

                nemico = new Nemico(domandaTemp, risposteTemp, corretteTemp, posY, posX);
                nem = true;
            }
        }
    }

    private void pulisciPopUp() {

        for (int i = 0; i < contRisp.size(); i++) {
            pannelloPopUp.remove(contRisp.get(i));
        }
        contRisp.clear();
        risposte.clear();
        check.clear();

        check.add(new JCheckBox());
        risposte.add(new JTextField(15));
        contRisp.add(new JPanel());
        contRisp.get(0).setLayout(new FlowLayout());

        contRisp.get(0).add(new JLabel("Riposta 1:"));
        contRisp.get(0).add(check.get(0));
        contRisp.get(0).add(risposte.get(0));
        pannelloPopUp.add(contRisp.get(0));

        domanda.setText(null);
    }
}
