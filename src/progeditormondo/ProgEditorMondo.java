/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progeditormondo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author gabriel.ricaldone
 */
public class ProgEditorMondo extends JFrame {

    String scelta = "terra";
    int grandezzaX = 26, grandezzaY = 14;

    MondoEditor[][] casella;
    ActionHandler handler = new ActionHandler();

    JButton terra;
    JButton acquaP;
    JButton acquaS;
    JButton acqua;
    JButton erba;
    JButton erbaC;
    JButton muro;
    JButton salva;
    JButton carica;
    JButton cancella;
    JButton cancellaTutto;
    JButton nemico;

    JFrame frame = new JFrame("Editor");
    JPanel pannelloSceltaTerreno = new JPanel();
    JPanel pannelloMondo = new JPanel();
    JPanel contenutoPannelloTerreno = new JPanel();
    JPanel pannelloStrumenti = new JPanel();

    JLabel titoloTerreno = new JLabel("Terreni");

    ProgEditorMondo() {
        casella = new MondoEditor[grandezzaY][grandezzaX];
        for (int i = 0; i < grandezzaX; i++) {
            for (int j = 0; j < grandezzaY; j++) {

                casella[j][i] = new MondoEditor("terra", j, i);

                casella[j][i].casellaEditor.setBounds(i * 37 + 5, j * 37 + 5, 30, 30);
                int k = j, l = i;
                casella[j][i].casellaEditor.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mousePressed(MouseEvent e) {
                        casella[k][l].modify(scelta);
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }
                });
            }
        }

        terra = new JButton("Terra");
        acquaP = new JButton("Acqua profonda");
        acquaS = new JButton("Acqua spiaggia");
        acqua = new JButton("Acqua");
        erba = new JButton("Erba");
        erbaC = new JButton("Erba chiara");
        muro = new JButton("Muro");
        salva = new JButton("Salva");
        carica = new JButton("Carica");
        cancella = new JButton("Cancella");
        cancellaTutto = new JButton("Cancella tutto");
        nemico = new JButton("Nemico");

        //Si salva su mondo.txt
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 1280, 720);

        pannelloStrumenti.setLayout(new GridLayout(4, 0));
        pannelloStrumenti.setBounds(0, frame.getHeight() - 179, frame.getWidth() - 300, 200);
        pannelloStrumenti.setBackground(new Color(200, 200, 200));
        pannelloStrumenti.setBorder(BorderFactory.createLoweredBevelBorder());

        pannelloMondo.setLayout(null);
        pannelloMondo.setBounds(0, 0, frame.getWidth() - 300, frame.getHeight() - 200);
        pannelloMondo.setBackground(new Color(240, 240, 240));

        pannelloSceltaTerreno.setBounds(frame.getWidth() - 300, -1, 300, frame.getHeight());
        pannelloSceltaTerreno.setBackground(new Color(200, 200, 200));
        pannelloSceltaTerreno.setBorder(BorderFactory.createLoweredBevelBorder());

        contenutoPannelloTerreno.setLayout(new GridLayout(6, 0));

        titoloTerreno.setBorder(new EmptyBorder(10, 10, 30, 10));
        titoloTerreno.setFont(new Font("Calibri", Font.PLAIN, 30));
        titoloTerreno.setAlignmentX(Component.CENTER_ALIGNMENT);

        pannelloSceltaTerreno.add(titoloTerreno);
        pannelloSceltaTerreno.add(contenutoPannelloTerreno);

        for (int i = 0; i < grandezzaX; i++) {
            for (int j = 0; j < grandezzaY; j++) {
                pannelloMondo.add(casella[j][i].casellaEditor);
            }
        }

        contenutoPannelloTerreno.add(terra);
        contenutoPannelloTerreno.add(acqua);
        contenutoPannelloTerreno.add(acquaP);
        contenutoPannelloTerreno.add(acquaS);
        contenutoPannelloTerreno.add(erba);
        contenutoPannelloTerreno.add(erbaC);
        contenutoPannelloTerreno.add(muro);
        contenutoPannelloTerreno.add(cancella);
        contenutoPannelloTerreno.add(nemico);

        pannelloStrumenti.add(salva);
        pannelloStrumenti.add(carica);
        pannelloStrumenti.add(cancellaTutto);

        terra.addActionListener(handler);
        acqua.addActionListener(handler);
        acquaP.addActionListener(handler);
        acquaS.addActionListener(handler);
        erba.addActionListener(handler);
        erbaC.addActionListener(handler);
        salva.addActionListener(handler);
        carica.addActionListener(handler);
        cancella.addActionListener(handler);
        cancellaTutto.addActionListener(handler);
        muro.addActionListener(handler);
        nemico.addActionListener(handler);

        frame.add(pannelloSceltaTerreno);
        frame.add(pannelloStrumenti);
        frame.add(pannelloMondo);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ProgEditorMondo();
    }

    public class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == terra) {
                scelta = "terra";
            }
            if (e.getSource() == cancella) {
                scelta = "cancella";
            }
            if (e.getSource() == erba) {
                scelta = "erba";
            }
            if (e.getSource() == erbaC) {
                scelta = "erbaC";
            }
            if (e.getSource() == acqua) {
                scelta = "acqua";
            }
            if (e.getSource() == acquaS) {
                scelta = "acquaS";
            }
            if (e.getSource() == acquaP) {
                scelta = "acquaP";
            }
            if (e.getSource() == muro) {
                scelta = "muro";
            }
            if (e.getSource() == nemico) {
                scelta = "nemico";
            }
            if (e.getSource() == cancellaTutto) {
                for (int i = 0; i < grandezzaY; i++) {
                    for (int j = 0; j < grandezzaX; j++) {
                        casella[i][j].modify("cancella");
                    }
                }
            }
            if (e.getSource() == carica) {

                String terreno = "";
                FileReader fIn;
                try {
                    fIn = new FileReader("mondo.txt");
                    BufferedReader read = new BufferedReader(fIn);

                    for (int i = 0; i < grandezzaY; i++) {
                        for (int j = 0; j < grandezzaX; j++) {
                            terreno = read.readLine();
                            casella[i][j].modify(terreno);
                        }

                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ProgEditorMondo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ProgEditorMondo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (e.getSource() == salva) {
                try {
                    FileWriter fOut = new FileWriter("mondo.txt");
                    FileWriter fOutNem = new FileWriter("nemico.txt");
                    PrintWriter write = new PrintWriter(fOut);
                    PrintWriter writeNemico = new PrintWriter(fOutNem);

                    for (int i = 0; i < grandezzaY; i++) {
                        for (int j = 0; j < grandezzaX; j++) {
                            write.println(casella[i][j].casella.terreno);
                        }
                    }
                    write.close();

                    int cont = 0;
                    for (int i = 0; i < grandezzaY; i++) {
                        for (int j = 0; j < grandezzaX; j++) {
                            if (casella[i][j].nemico != null) {
                                writeNemico.print(casella[i][j].nemico.domanda + "®");
                                
                                cont = 0;
                                for (String risposta : casella[i][j].nemico.risposte) {
                                    writeNemico.print(risposta);
                                    cont++;
                                    if (cont < casella[i][j].nemico.risposte.size()) {
                                        writeNemico.print("|");
                                    }
                                }
                                cont = 0;
                                writeNemico.print("®");
                                for (Boolean corretto : casella[i][j].nemico.corrette) {
                                    writeNemico.print(corretto);
                                    cont++;
                                    if (cont < casella[i][j].nemico.risposte.size()) {
                                        writeNemico.print("|");
                                    }
                                }
                                writeNemico.println("®" + casella[i][j].nemico.posX + "®" + casella[i][j].nemico.posY);
                            }
                        }
                    }
                    writeNemico.close();
                } catch (IOException ex) {
                    Logger.getLogger(ProgEditorMondo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
