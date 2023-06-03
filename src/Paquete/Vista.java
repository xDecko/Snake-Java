package Paquete;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.UIManager;
import javax.swing.*;



public class Vista extends javax.swing.JFrame {
    
        PanelSnake panel;
    
        public Vista() {
        
        int tammax=800,can=30;
        
        
        initComponents();
        this.setLocationRelativeTo(null);// Salga en el centro de la pantalla
        
         // Crear el panel de juego Snake y agregarlo a la ventana
        panel= new PanelSnake(tammax,can);
        this.add(panel);
        panel.setBounds(10, 10, 800, 800);
        panel.setOpaque(false);
        
        
        // Crear el panel de fondo y agregarlo a la ventana
        PanelFondo fondo= new PanelFondo(tammax,can);
        this.add(fondo);
        fondo.setBounds(10, 10, 800, 800);
        this.add(fondo, BorderLayout.CENTER);
        fondo.setOpaque(true);
        
        this.requestFocus(true);
        
        
        
        this.setTitle("Decko - Snake 🐍" );
        this.setPreferredSize(new Dimension(tammax+35,tammax+60));

        pack(); 
        


    }
    




    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snakle");
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(10, 10, 10, 10));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(5000, 5000));
        setPreferredSize(new java.awt.Dimension(1100, 850));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 935, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 923, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_formPropertyChange

    // Manejar eventos de teclado para cambiar la dirección del snake
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    panel.cambiardireccion("iz");
                    break;
                case KeyEvent.VK_RIGHT:
                    panel.cambiardireccion("de");
                    break;
                case KeyEvent.VK_UP:
                    panel.cambiardireccion("ar");
                    break;
                case KeyEvent.VK_DOWN:
                    panel.cambiardireccion("ab");
                    break;
                default:
                    break;
            }
    }


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
          // Configurar el aspecto visual de la ventana del juego
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());

                            // Configurar propiedades para un tema oscuro
                            UIManager.put("nimbusBase", java.awt.Color.darkGray);
                            UIManager.put("nimbusBlueGray", java.awt.Color.darkGray);
                            UIManager.put("control", java.awt.Color.white);
                            UIManager.put("text", java.awt.Color.darkGray);

                            break;
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                // Cargar el logo
                String iconPath = "resources/logo.png";
                ImageIcon icon = new ImageIcon(iconPath);

                // Crear la ventana del juego
                Vista vista = new Vista();
                vista.setIconImage(icon.getImage());
                vista.setVisible(true);
            }
        });
    }



}
