/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.marianetbai.vista;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Maria
 */
public class GestorFacturas extends JPanel{
        public GestorFacturas(){
            JButton botonLogin = new JButton("Log in");
            //añadimos tooltip
            botonLogin.setToolTipText("Log in to your account");
            botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //abro la ventana de login al hacer clic en el botón
                Login loginPanel = new Login();
                JFrame loginFrame = new JFrame("Log in");
                
                //para eliminar la barra de título de la ventana de login
                loginFrame.setUndecorated(true);
                
                loginFrame.setContentPane(loginPanel);
                loginFrame.setSize(1040, 570); // Ajusta el tamaño según tus necesidades
                loginFrame.setVisible(true);
                loginFrame.setLocationRelativeTo(null);
                loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo la ventana de login al presionar cerrar
            }
            });
            //añadimos el botón en la pantalla
            add(botonLogin);
        }
        
        @Override
        public void paint (Graphics g){
            ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/fndo1.png"));
            g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }   
    
        public static void main(String args[]) {
            JFrame ventana = new JFrame("NetFacturing");
            GestorFacturas fondo = new GestorFacturas();
            ventana.setContentPane(fondo);
            ventana.setSize(1040, 570);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}
