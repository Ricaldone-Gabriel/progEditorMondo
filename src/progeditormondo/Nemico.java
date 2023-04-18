/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progeditormondo;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Nemico extends JLabel {

    int livello;
    int posX, posY;
    int size;
    String domanda;
    ArrayList<String> risposte;
    ArrayList<Boolean> corrette;

    //ImageIcon player;
    Nemico(String domanda, ArrayList<String> risposte, ArrayList<Boolean> risposteC, int posX, int posY) {
        this.risposte = risposte;
        corrette = risposteC;
        this.posX = posX;
        this.posY = posY;
        this.domanda = domanda;
        size = 40;
    }
}