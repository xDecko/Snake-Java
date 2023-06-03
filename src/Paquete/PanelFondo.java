
package Paquete;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelFondo extends JPanel {

    Color colorfondo=new Color(240, 240, 240);
    
    int tammax,tam,can,res;
    
    public PanelFondo(int tammax, int can){
         // Constructor que recibe el tamaño máximo y la cantidad de cuadros
        this.tammax=tammax;
        this.can=can;
        this.tam=tammax/can;  
        this.res=tammax%can;
     
        
    }
    
    @Override
    public void paint(Graphics pintor){
        // Método para pintar el fondo del panel
        super.paint(pintor);
        pintor.setColor(colorfondo);
        // Pintar el fondo con cuadros de tamaño "tam"
        for(int i= 0;i<can;i++){
            
            for (int j = 0; j<can; j++){
                
                pintor.fillRect( res / 2 +i*tam, res / 2 +j*tam, tam -1, tam-1);
            }
        }
         
    }
    
       
    
}
