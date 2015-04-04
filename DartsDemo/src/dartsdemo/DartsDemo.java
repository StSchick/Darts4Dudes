/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dartsdemo;

/**
 *
 * @author stefan
 */
public class DartsDemo {

    
    public static void main(String[] args) {

     
    Throw wurf=new Throw();    
  
 for(int i=1;i<=170;i++){
     if(!wurf.verify(i)){
         System.out.println("Wurf "+i+" ist fehlerhaft!");
     }
 }
    

  /*      if (wurf.isPossible(40, 1)) {
            System.out.println(wurf.splitComb(wurf.getComb(20))[0]);
        }*/
    
    
        
    }
    
}
