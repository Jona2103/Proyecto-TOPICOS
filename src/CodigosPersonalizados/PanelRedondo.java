/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodigosPersonalizados;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Jonathan Viera
 */
public class PanelRedondo extends JPanel{
    private int esquina = 15;

    public PanelRedondo(int redondo) {
        super();
        this.esquina = redondo;
        setOpaque(false);
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), esquina, esquina);
    }
}
