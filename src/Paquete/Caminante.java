
package Paquete;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Caminante implements Runnable {

    PanelSnake panel;
    boolean estado=true;
    
    public Caminante(PanelSnake panel){
        // Constructor que recibe una instancia de PanelSnake
        this.panel=panel;
    
    }
    @Override
    public void run(){
        // Método principal que se ejecuta en el hilo
        while(estado){
            panel.avanzar();// Avanzar la serpiente en el panel
            panel.repaint();// Volver a dibujar el panel
            try {
                Thread.sleep(100);// Pausar el hilo por 100 milisegundos (0.1 segundos)
            } catch (InterruptedException ex) {
                Logger.getLogger(Caminante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    public void parar(){
         // Método para detener el hilo
        this.estado=false;
    }
    

}
