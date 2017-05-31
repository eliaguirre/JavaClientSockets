/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.Observer;
import cliente.Cliente;
import java.util.*;
/**
 *
 * @author Fermyn
 */
public class Tiempo  implements Runnable,Observer{
    long tiempo,seg=0,min=0,hrs=0;
    Thread h1 = new Thread(this);
    Cliente c;
    
    public void run(){
        Thread ct = Thread.currentThread();
        
        while (ct == h1){
            tiempo = System.currentTimeMillis();
            //seg = tiempo*1000;
            if (tiempo >=1000){
                seg += 1;
                tiempo-=1000;
                if(seg >=60 ){
                    min += 1;
                    seg -=60;
                    if(min >=60){
                        hrs += 1;
                        seg +=60;
                    }
                }

            }
            //c.Tiempo.setText(hrs+":"+min+":"+seg);

            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {}
        }
    }
    public Tiempo(Cliente c1){
        
        c=c1;
        h1.start();
    }

    @Override
    public void update(Observable o, Object arg) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
