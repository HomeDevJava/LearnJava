/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosasdejava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static javafx.scene.input.KeyCode.F;

/**
 *
 * @author 50098250
 */
public class cosas {
    
    public static void main(String[] args) throws IOException{
        getBIOS();
    }
    
    public static void getapps(){
        
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperties().getProperty("user.name"));
        Runtime aplicacion = Runtime.getRuntime(); 
        
        String s,v;        
        Map<String, String> m= new HashMap<>();
        
  
        try{
           Process p=Runtime.getRuntime().exec("CMD /C \"wmic PRODUCT GET NAME\"");
           BufferedReader stdinput= new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            Process version=aplicacion.exec("CMD /C \"wmic PRODUCT GET VERSION\"");
            BufferedReader ver= new BufferedReader(new InputStreamReader(version.getInputStream()));
            
            while((v=ver.readLine())!=null && (s=stdinput.readLine())!=null){
                //System.out.println(s);
                m.put(v,s);
            }
            
            m.entrySet().forEach((entrada) -> {
                System.out.printf("App: %s  Version: %s \n",   entrada.getValue(),entrada.getKey());
            });
            
            //System.out.println(m);
        }
        catch(Exception e){}

    }
    
    public static void getBIOS() throws IOException{
        Process p;
        BufferedReader input;
        
        String s = null;
        p= Runtime.getRuntime().exec("CMD /C \"wmic CSPRODUCT GET IdentifyingNumber\"");
        
        
        InputStreamReader i= new InputStreamReader(p.getInputStream());
        input= new BufferedReader(i);
        
        Reader r=new BufferedReader(i);
        List lista=new ArrayList();
        int b=r.read();
        while(b != -1){
            b=r.read();
            char letra=(char) b;           
                
            if(b!=32){
                s+=letra;
            }else{
                //s+=":";
            }
               
            
            
        }
        String trim = s.trim().substring(23);
        for(int l=0; trim.length()>l; l++){
    
            System.out.println(trim.chars());
            
            switch (trim.charAt(l)) {
                case '\n':
                    
                    System.out.println(trim.length());
                    break;
                case ' ':
                    System.out.println("..");
                    break;
                
                default:
                    //System.out.println(trim.charAt(l));
                    break;
            }
               
            
        }
        //s.split(":",10);
        String gg=trim;
        
        System.out.println("SERIE: "+gg.substring(0, gg.length()-3));
        System.out.println(gg.length());
        
        System.out.println();
//        
//        while((s=input.readLine())!= null){
//            System.out.println(s);
//        }
        
    }

    
}
//CMD /C "wmic PRODUCT GET NAME"