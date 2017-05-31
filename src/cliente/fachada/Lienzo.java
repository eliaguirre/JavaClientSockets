/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.fachada;

import cliente.singleton.Sesion;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javax.swing.JPanel;

/**
 *
 * @author felix
 */
public class Lienzo extends JPanel implements Observable, MouseListener, MouseMotionListener {

    public ArrayList<Linea> lines;
    private boolean painter = false;
    private int top_lines = -1;
    private Color color = Color.BLACK;
    private int grueso = 1;
    private Sesion sesion;

    public Lienzo(Sesion sesion) {
        this.sesion = sesion;
        lines = new ArrayList<Linea>();
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void setGrueso(int c) {
        this.grueso = c;
    }

    public void clear() {
        top_lines = -1;
        this.lines.clear();
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Linea line : lines) {
            int c = 1;
            Punto ant = null;

            for (Punto point : line) {
                g.setColor(point.color);
                g2d.setStroke(new BasicStroke(point.grueso));
                if (c >= 2) {
                    g.drawLine(ant.x, ant.y, point.x, point.y);
                }
                ant = point;

                c++;
            }
        }
    }

    public void addLine(Linea l) {
        this.lines.add(l);
        top_lines++;
        this.repaint();
    }

    @Override
    public void addListener(InvalidationListener il) {

    }

    @Override
    public void removeListener(InvalidationListener il) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        painter = true;
        this.lines.add(new Linea());
        top_lines++;

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        painter = false;
        sesion.sendMensaje(lines.get(top_lines));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (painter) {
            Punto p = new Punto(e.getPoint().x, e.getPoint().y, color);
            p.setGrueso(grueso);
            lines.get(top_lines).add(p);

            this.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
