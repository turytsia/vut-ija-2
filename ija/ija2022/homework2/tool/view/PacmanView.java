package ija.ija2022.homework2.tool.view;

import ija.ija2022.homework2.tool.common.CommonMazeObject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

/*
 * Třída reprezentující grafickou podobu panáčka (pacmana).
 * Panáček je zobrazen jako kolečko zelené barvy s informací o počtu životů.
 */
public class PacmanView implements ComponentView {
    private CommonMazeObject model;
    private FieldView parent;

    public PacmanView(FieldView parent, CommonMazeObject m) {
        this.model = m;
        this.parent = parent;
    }

    /*
     * Vykreslí grafickou podobu objektu do grafického kontextu g.
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle bounds = this.parent.getBounds();
        double w = bounds.getWidth();
        double h = bounds.getHeight();
        Math.max(h, w);
        double diameter = Math.min(h, w) - 10.0;
        double x = (w - diameter) / 2.0;
        double y = (h - diameter) / 2.0;
        Ellipse2D.Double ellipse = new Ellipse2D.Double(x, y, diameter, diameter);
        g2.setColor(Color.green);
        g2.fill(ellipse);
        g2.setColor(Color.black);
        g2.setFont(new Font("Serif", 1, 20));
        g2.drawString("(" + this.model.getLives() + ")", (int) (x + diameter) / 2, (int) (y + diameter + 10.0) / 2 + 5);
    }
}
