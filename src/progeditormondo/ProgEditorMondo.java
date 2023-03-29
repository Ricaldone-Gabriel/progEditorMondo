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
    Piattaforma[][] mondo;
    int grandezzaX = 26, grandezzaY = 14;

    ProgEditorMondo() {
        mondo = new Piattaforma[grandezzaY][grandezzaX];
        JPanel[][] mondoEditor = new JPanel[grandezzaY][grandezzaX];

        for (int i = 0; i < grandezzaX; i++) {
            for (int j = 0; j < grandezzaY; j++) {
                mondo[j][i] = new Piattaforma("terra", j, i);
                mondoEditor[j][i] = new JPanel();
                mondoEditor[j][i].setBackground(new Color(155, 90, 60));
                mondoEditor[j][i].setBounds(i * 37 + 5, j * 37 + 5, 30, 30);
                int k = j, l = i;
                mondoEditor[j][i].addMouseListener(new MouseAdapter() {

                    @Override
                    public void mousePressed(MouseEvent e) {
                        Color colore;
                        mondo[k][l].terreno = scelta;

                        switch (scelta) {
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
                            default:
                                colore = new Color(255, 255, 255);
                                break;
                        }
                        mondoEditor[k][l].setBackground(colore);
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }
                });
            }
        }

        JFrame frame = new JFrame("Editor");

        JPanel pannelloSceltaTerreno = new JPanel();
        JPanel pannelloMondo = new JPanel();
        JPanel contenutoPannelloTerreno = new JPanel();
        JPanel pannelloStrumenti = new JPanel();
        JLabel titoloTerreno = new JLabel("Terreni");
        
        JButton terra = new JButton("Terra");
        JButton acquaP = new JButton("Acqua profonda");
        JButton acquaS = new JButton("Acqua spiaggia");
        JButton acqua = new JButton("Acqua");
        JButton erba = new JButton("Erba");
        JButton erbaC = new JButton("Erba chiara");
        JButton salva = new JButton("Salva");
        JButton carica = new JButton("Carica");
        JButton cancella = new JButton("Cancella");
        
        //Si salva su mondo.txt
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 1280, 720);

        pannelloStrumenti.setBounds(0,frame.getHeight()-179,frame.getWidth()-300,200);
        pannelloStrumenti.setBackground(new Color(200,200,200));
        pannelloStrumenti.setBorder(BorderFactory.createLoweredBevelBorder());
        pannelloStrumenti.setLayout(new GridLayout(4,0));
        
        pannelloMondo.setBounds(0, 0, frame.getWidth() - 300, frame.getHeight() - 200);
        pannelloMondo.setLayout(null);
        pannelloMondo.setBackground(new Color(240, 240, 240));
        
        pannelloSceltaTerreno.setBounds(frame.getWidth() - 300, -1, 300, frame.getHeight());
        pannelloSceltaTerreno.setBackground(new Color(200, 200, 200));
        pannelloSceltaTerreno.setBorder(BorderFactory.createLoweredBevelBorder());
        
        contenutoPannelloTerreno.setLayout(new GridLayout(3,0));
        
        
        for (int i = 0; i < grandezzaX; i++) {
            for (int j = 0; j < grandezzaY; j++) {
                pannelloMondo.add(mondoEditor[j][i]);

            }
        }

        titoloTerreno.setBorder(new EmptyBorder(10, 10, 30, 10));
        titoloTerreno.setFont(new Font("Calibri", Font.PLAIN, 30));

        titoloTerreno.setAlignmentX(Component.CENTER_ALIGNMENT);
        pannelloSceltaTerreno.add(titoloTerreno);
        pannelloSceltaTerreno.add(contenutoPannelloTerreno);
        
        contenutoPannelloTerreno.add(terra);
        contenutoPannelloTerreno.add(acqua);
        contenutoPannelloTerreno.add(acquaP);
        contenutoPannelloTerreno.add(acquaS);
        contenutoPannelloTerreno.add(erba);
        contenutoPannelloTerreno.add(erbaC);
        
        pannelloStrumenti.add(salva);
        pannelloStrumenti.add(carica);
        pannelloStrumenti.add(cancella);

        terra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                scelta = "terra";
            }

        });

        acqua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                scelta = "acqua";
            }

        });

        acquaP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                scelta = "acquaP";
            }

        });

        acquaS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                scelta = "acquaS";
            }

        });

        erba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                scelta = "erba";
            }

        });

        erbaC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                scelta = "erbaC";
            }

        });

        salva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    FileWriter fOut = new FileWriter("mondo.txt");
                    PrintWriter write = new PrintWriter(fOut);
                    for (int i = 0; i < grandezzaY; i++) {
                        for (int j = 0; j < grandezzaX; j++) {
                            write.println(mondo[i][j].terreno);
                        }
                    }
                    write.close();
                } catch (IOException ex) {
                    Logger.getLogger(ProgEditorMondo.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        carica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String terreno = "";
                Color colore;
                FileReader fIn;
                try {
                    fIn = new FileReader("mondo.txt");
                    BufferedReader read = new BufferedReader(fIn);

                    for (int i = 0; i < grandezzaY; i++) {
                        for (int j = 0; j < grandezzaX; j++) {
                            terreno = read.readLine();
                            mondo[i][j].terreno = terreno;

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
                                default:
                                    colore = new Color(255, 255, 255);
                                    break;
                            }
                            mondoEditor[i][j].setBackground(colore);
                        }

                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ProgEditorMondo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ProgEditorMondo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        
        cancella.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(int i = 0; i < grandezzaY; i++) {
                    for(int j = 0; j < grandezzaX; j++) {
                        mondo[i][j].terreno = "terra";
                        mondoEditor[i][j].setBackground(new Color(155, 90, 60));
                    }
                }
            }
        });

        frame.add(pannelloSceltaTerreno);
        frame.add(pannelloStrumenti);
        frame.add(pannelloMondo);

        frame.setVisible(true);
    }

    public static void main(String[] args) {

        new ProgEditorMondo();
    }

}
