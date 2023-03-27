package progeditormondo;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Piattaforma extends JPanel {

    String terreno;
    int posX, posY;
    int size;
    
    class GUIEditor {
        JFrame frame;
    }

    Piattaforma(String terreno, int posX, int posY) {
        this.terreno = terreno;
        this.posX = posX;
        this.posY = posY;
        size = 50;
    }

}
