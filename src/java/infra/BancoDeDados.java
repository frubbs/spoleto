/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafa
 */
public class BancoDeDados {
   
   private static final String BDPREFIX = "PSW1Data."; 
   
   
   public static boolean salvar(Serializable objeto, String nome)
   {
      try
      {
         String filename =  BDPREFIX + nome;
         FileOutputStream fileOut =
         new FileOutputStream(filename);
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(objeto);
         out.close();
         fileOut.close();
         System.out.println("Serialized data is saved in " + filename);
         return true;
      }catch(IOException i)
      {
          i.printStackTrace();
          return false;
      }
   }
   
   /*
   * Recupera um objeto salvo anteriormente.
   * @param nome String nome do objeto, informado ao salva-lo.
   * @return O objeto, se encontrado. Para utilizar e' preciso fazer Typecast.
   * Exemplo:  Ingrediente ing = (Ingrediente) BancoDeDados.buscar("vodca");
   */
   public static Serializable buscar(String nome)
   {
      Serializable e = null;
      try
      {
         nome = BDPREFIX + nome;
         FileInputStream fileIn = new FileInputStream(nome);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Serializable) in.readObject();
         in.close();
         fileIn.close();
         return e;
      }catch(Exception i)
      {
         //i.printStackTrace();
          System.out.println("******* Não encontrei o item :" + nome );
          return null;
      }
   }
   
   
   public static List<Serializable> listarDados() {
       
       List<Serializable> data = new ArrayList<Serializable>();
       
       File folder = new File(".");
       File[] listOfFiles = folder.listFiles();

       for (int i = 0; i < listOfFiles.length; i++) {
         if (listOfFiles[i].isFile()) {
           // System.out.println("File " + listOfFiles[i].getName());
            if(listOfFiles[i].getName().contains(BDPREFIX))
            {
                String nome = listOfFiles[i].getName().substring(listOfFiles[i].getName().indexOf(BDPREFIX)+BDPREFIX.length());
                Serializable obj = buscar(nome);
                data.add(obj);
            }
         }/* else if (listOfFiles[i].isDirectory()) {
             System.out.println("Directory " + listOfFiles[i].getName());
         }*/
      }
       
       return data;
   }
   
   
   public static List<Serializable> listarDados(Class<?> cls) {
     List<Serializable> itens = listarDados();
     
     List<Serializable> dadosFiltrados = new ArrayList<Serializable>();
     
     for (Serializable item : itens) 
     {
        if (item != null && item.getClass().equals(cls)) {
            dadosFiltrados.add(item);
        }
     }
     return dadosFiltrados;   
   }
   
   
    public static void limparBanco() {
       
       
       File folder = new File(".");
       File[] listOfFiles = folder.listFiles();

       for (int i = 0; i < listOfFiles.length; i++) {
         if (listOfFiles[i].isFile()) {
            System.out.println("File " + listOfFiles[i].getName());
            if(listOfFiles[i].getName().contains(BDPREFIX))
            {
                if(listOfFiles[i].delete())
                {
    			System.out.println(listOfFiles[i].getName() + " is deleted!");
    		}
                else
                {
    			System.out.println("Delete operation is failed.");
    		}
            }
         } else if (listOfFiles[i].isDirectory()) {
             System.out.println("Directory " + listOfFiles[i].getName());
         }
      }
       
       
   }
   
}