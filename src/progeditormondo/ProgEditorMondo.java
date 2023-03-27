/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progeditormondo;

import com.sun.glass.ui.Screen;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author gabriel.ricaldone
 */
public class ProgEditorMondo extends JFrame {
    String scelta = "";
    Piattaforma[][] mondo;
    int grandezzaX = 26, grandezzaY = 14;
    
    ProgEditorMondo() {
        mondo = new Piattaforma[grandezzaY][grandezzaX];
        for(int i = 0; i < grandezzaY; i++) {
            for(int j = 0; j < grandezzaX; j++) {
                mondo[i][j] = new Piattaforma("terra",j,i);
            }
        }

        JFrame frame = new JFrame("Editor");
        
        JPanel pannelloSceltaTerreno = new JPanel();
        JPanel pannelloMondo = new JPanel();
        
        JLabel titoloMenu = new JLabel("Menù");
        
        JButton terra = new JButton("Terra");
        JButton acquaP = new JButton("Acqua profonda");
        JButton acquaS = new JButton("Acqua spiaggia");
        JButton acqua = new JButton("Acqua");
        
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 1280, 720);

        pannelloMondo.setBounds(0, 0, frame.getWidth() - 300, frame.getHeight());
        pannelloMondo.setBackground(new Color(240, 240, 240));

        pannelloSceltaTerreno.setBounds(frame.getWidth() - 300, -1, 300, frame.getHeight());
        pannelloSceltaTerreno.setBackground(new Color(200, 200, 200));
        pannelloSceltaTerreno.setBorder(BorderFactory.createLoweredBevelBorder());

        titoloMenu.setBorder(new EmptyBorder(10, 10, 30, 10));
        titoloMenu.setFont(new Font("Calibri", Font.PLAIN, 30));
        titoloMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        terra.setAlignmentX(Component.CENTER_ALIGNMENT);
        acqua.setAlignmentX(Component.CENTER_ALIGNMENT);
        acquaP.setAlignmentX(Component.CENTER_ALIGNMENT);
        acquaS.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        pannelloSceltaTerreno.add(titoloMenu);
        pannelloSceltaTerreno.add(terra);
        pannelloSceltaTerreno.add(acqua);
        pannelloSceltaTerreno.add(acquaP);
        pannelloSceltaTerreno.add(acquaS);
        pannelloSceltaTerreno.setLayout(new BoxLayout(pannelloSceltaTerreno, BoxLayout.Y_AXIS));

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
        
        frame.add(pannelloSceltaTerreno);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        new ProgEditorMondo();
    }

}
