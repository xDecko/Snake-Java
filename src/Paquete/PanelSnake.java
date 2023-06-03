
package Paquete;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelSnake extends JPanel {
    
    public boolean juegoTerminado = false; // se llama en avanzar para terminar el juego y que no salga mas el JOPanel
    Color colorsnake=new Color(96, 96, 96);
    Color colorcomida=Color.red;
    int tammax,tam,can,res;
    
    List<int[]> snake = new ArrayList<>();// Lista que representa las posiciones de las partes del snake
    int [] comida=new int[2]; // Arreglo que representa la posición de la comida
    String direccion="de"; // Dirección actual del snake
    String direccionproxima="de"; // Dirección actual del snake
    
    Thread hilo;
    Caminante camino;
    
    public PanelSnake(int tammax, int can){
        
        this.tammax=tammax;
        this.can=can;
        this.tam=tammax/can;  
        this.res=tammax%can;
        
        int[] a={can/2-1,can/2-1};
        int[] b={can/2,can/2-1};
        
        snake.add(a);
        snake.add(b);
        generarcomida();
        
        
        camino=new Caminante(this);
        hilo=new Thread(camino);
        hilo.start();
        
        
                
     
        
    }
    
    @Override
    public void paint(Graphics pintor){
        
        super.paint(pintor);
        pintor.setColor(colorsnake);
        
//        for (int i=0;i< snake.size();i++){
//            pintor.fillRect( res/2 + snake.get(i)[0]*tam , res/2 + snake.get(i)[1] *tam, tam -1, tam-1);        
//        }


        //Pintar serpiente
        for (int[] par:snake){
            pintor.fillRect( res/2 + par[0]*tam , res/2 + par[1] *tam, tam -1, tam-1);       
        }
        
        //Pintando comida
        pintor.setColor(colorcomida);
        pintor.fillRect( res/2 + comida[0]*tam , res/2 + comida[1] *tam, tam -1, tam-1);    
        
        
    }
    
    public void avanzar(){
        

        igualardir();

        int [] ultimo=snake.get(snake.size()-1);
        int agregarx=0;
        int agregary=0;

         // Actualizar las coordenadas del snake en función de la dirección
        switch(direccion){
            case "de":agregarx=1;break;
            case "iz":agregarx=-1;break;
            case "ar":agregary=-1;break;
            case "ab":agregary=1;break;
        }
        int[] nuevo={Math.floorMod (ultimo[0]+agregarx,can), Math.floorMod (ultimo[1]+agregary,can)};
        
        boolean existe=false;
        for(int i = 0 ; i<snake.size();i++){
            if(nuevo[0]==snake.get(i)[0]&&nuevo[1]==snake.get(i)[1]){
                existe=true;
                break;           
            }     
        }

        // Actualizar las coordenadas del snake en función de la dirección
        if (existe) {
            if (!juegoTerminado) {
                juegoTerminado = true;

                int opcion = JOptionPane.showOptionDialog(
                    this,
                    "Perdiste. ¿Deseas reiniciar el juego?",
                    "Juego Terminado",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Aceptar", "Reiniciar"},
                    "Aceptar"
                );

                if (opcion == JOptionPane.YES_OPTION) {
                    // Cerrar la ventana o realizar cualquier otra acción necesaria
                   // dispose(); // Cierra la ventana principal, por ejemplo
                } else if (opcion == JOptionPane.NO_OPTION) {
                    // Reiniciar el juego o realizar cualquier otra acción necesaria
                   // reiniciarJuego();
                }
            }


                

            
        }else{
            if(nuevo[0]==comida[0]&&nuevo[1]==comida[1]){
                snake.add(nuevo);
                generarcomida();
            }else{
                snake.add(nuevo);
                snake.remove(0);    
            }
        }
    }
    
    
    public void generarcomida(){
        boolean existe=false;
        int a = (int)(Math.random()*can);
        int b = (int)(Math.random()*can);
        for (int[] par:snake){
            if(par[0]==a&&par[1]==b){
                existe=true;
                generarcomida();
                break;
            }
        }
        if(!existe){
            this.comida[0]=a;
            this.comida[1]=b;
        }
    
    
    }
    
    public void cambiardireccion(String dir){
         // Cambiar la dirección próxima del snake solo si es una dirección válida
        if ((this.direccion.equals("de") || this.direccion.equals("iz")) && (dir.equals("ar") || dir.equals("ab"))){
            this.direccionproxima=dir;
        }
        if ((this.direccion.equals("ar") || this.direccion.equals("ab")) && (dir.equals("iz") || dir.equals("de"))){
            this.direccionproxima=dir;
        }
    }
    public void igualardir(){
          // Actualizar la dirección actual del snake
        this.direccion=direccionproxima;
    }

}
    
    


    
    
       
    

