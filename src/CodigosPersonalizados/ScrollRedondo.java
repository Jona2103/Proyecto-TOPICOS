/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodigosPersonalizados;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ScrollRedondo extends JScrollPane {
    private int esquina = 20; // Valor predeterminado de redondeo

    public ScrollRedondo() {
        super();
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder()); // Elimina el borde predeterminado
    }

    public void setEsquina(int esquina) {
        this.esquina = esquina;
        repaint(); // Actualiza la apariencia cuando cambia el valor de redondeo
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja el fondo redondeado
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), esquina, esquina));

        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar el borde redondeado
        g2.setColor(getForeground());
        g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, esquina, esquina));

        g2.dispose();
    }
}

