/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progeditormondo;

import java.util.ArrayList;

/**
 *
 * @author gigga
 */
public class Nemico {
    int livello;
    int posX, posY;
    int size;
    String domanda;
    ArrayList<String> risposte;
    
    //ImageIcon player;

    Nemico(String domanda,ArrayList<String> risposte,int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.domanda = domanda;
        this.risposte = risposte;
        size = 40;
    }
}
