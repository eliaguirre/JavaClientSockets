/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import cliente.Observer.Tiempo;
import cliente.Decorador.Fuentes;
import cliente.Decorador.Colores;
import java.util.*;
import cliente.Decorador.Mensaje;
import cliente.fachada.ClienteGUI;
import cliente.fachada.Lienzo;
import cliente.singleton.Sesion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;

public class Cliente extends javax.swing.JFrame {

    /**
     * Creates new form cliente1
     */
    String texto = "";

    public ClienteGUI fachada;
    private JButton changeColor;
    private JButton clear;
    private Color current = Color.BLACK;
    private static String[] petStrings = {"1px", "2px", "4px", "8px", "16px"};
    private JComboBox petList;

    public Cliente() {
        fachada = new ClienteGUI(this);
        initComponents();
        fachada.iniciar();
        changeColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    current = JColorChooser.showDialog(null, "Choose a color", current);
                    fachada.lienzo.setColor(current);
                    changeColor.setBackground(current);
                    //)/3 = 99

                    if ((current.getRed() + current.getBlue() + current.getGreen()) / 3 < 99) {
                        changeColor.setForeground(Color.WHITE);
                    } else {
                        changeColor.setForeground(Color.BLACK);
                    }
                } catch (Exception e) {
                }
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fachada.sendMensaje(new Mensaje("clear", "", ""));
                fachada.lienzo.clear();
            }
        });
        petList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                int p = cb.getSelectedIndex();
                fachada.lienzo.setGrueso((int) Math.pow(2, p));
            }
        });
    }

    private void initComponents() {
        petList = new JComboBox(petStrings);
        changeColor = new JButton("Color");
        clear = new JButton("Limpiar");
        changeColor.setBackground(Color.BLACK);
        changeColor.setForeground(Color.WHITE);
        this.setSize(800, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 600));
        this.add(fachada.lienzo).setBounds(0, 0, 800, 530);
        this.add(changeColor).setBounds(10, 540, 90, 20);
        this.add(clear).setBounds(120, 540, 90, 20);
        this.add(petList).setBounds(220, 540, 90, 20);
        this.add(new Label("Robert Bosch 2017")).setBounds(450, 540, 200, 20);
        this.setLayout(null);
        pack();
        setLocationRelativeTo(null);
    }

}
