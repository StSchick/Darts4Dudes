package dartsdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stefan
 */
public class Throw {
    
       
    public Scanner newScanner() {
            Scanner x=null;
        try{
            x = new Scanner(new File("/home/stefan/NetBeansProjects/DartsDemo/src/dartsdemo/Finish"));
            
        
    } catch(Exception e){
        System.out.println("could not find file");
    }
        return x;

}
    public String getComb(int i){
        Scanner x=this.newScanner();
        String a=null;
        for(int l=0;l<i;l++){
            a=x.next();
        }
       
        
        return a;
    }
    public String [] splitComb(String s){
        String split []=new String[3];
        int k=0;
        int pos=0;
        split[0]=split[1]=split[2]="";
        
        while (s.charAt(k)!=','){
            split[pos]=split[pos]+s.charAt(k);
            k++;
        }
        k++;
        pos++;
        try{
        while (s.charAt(k)!=','){
            split[pos]=split[pos]+s.charAt(k);
            k++;
        }    
        
        
        }catch(Exception e){
              split[1]="0";
           // split[2]="0";
            
        }
        k++;
        pos++;
        
        try{
            while (s.charAt(k)!=','){
            split[pos]=split[pos]+s.charAt(k);
            k++;
        }    
        
        
        }catch(Exception e){
           split[2]="0";
            
        }
        
        
        
        return split;
    }
    public String[] gettwoDartComb(int i){
    String[] a=new String[2];
            a[0]=this.splitComb(this.getComb(i))[0];
            a[1]=this.splitComb(this.getComb(i))[1];
            return a;
    }
    
    public boolean isPossible(int i, int darts){
        boolean poss=false;
        
        switch(darts){
            
            case 1: 
             if(this.splitComb(this.getComb(i))[1]=="0"){
                    if (this.splitComb(this.getComb(i))[2]=="0") {
                            poss=true;
            }
}                break;
                
            case 2: if(this.splitComb(this.getComb(i))[2]=="0"){poss=true;};
                break;
                
            case 3: if(this.splitComb(this.getComb(i))[0]!="0"){poss=true;};
                break;    
        }
        
        
        return poss;
    }
    public boolean verify(int z){
     boolean cor=false;
     int array[]=new int[3];
     for(int i=0;i<3;i++){
         char begin=this.splitComb(getComb(z))[i].charAt(0);

         switch(begin){
             case 'S':
                 
                 try{
                     array[i]= Character.getNumericValue(this.splitComb(getComb(z))[i].charAt(1));
                     array[i]= array[i]*10+Character.getNumericValue(this.splitComb(getComb(z))[i].charAt(2));        
             
             }catch(Exception e){
                     array[i]= Character.getNumericValue(this.splitComb(getComb(z))[i].charAt(1));

                         }
             
                 break;
                 
             case 'D':
                 try{
                     array[i]= Character.getNumericValue(this.splitComb(getComb(z))[i].charAt(1));
                     array[i]= 2*(array[i]*10+Character.getNumericValue(this.splitComb(getComb(z))[i].charAt(2)));        
             
             }catch(Exception e){
                     array[i]= 2*(Character.getNumericValue(this.splitComb(getComb(z))[i].charAt(1)));

                         }
                 break;
                 
             case 'T':
                 try{
                     array[i]= Character.getNumericValue(this.splitComb(getComb(z))[i].charAt(1));
                     array[i]= 3*(array[i]*10+Character.getNumericValue(this.splitComb(getComb(z))[i].charAt(2)));        
             
             }catch(Exception e){
                     array[i]= 3*(Character.getNumericValue(this.splitComb(getComb(z))[i].charAt(1)));

                         }
                 break;
             case '0': cor=true;    
                 
         }
     }
     if(array[0]+array[1]+array[2]==z){
         cor=true;
     }
        return cor;
    }
            
}