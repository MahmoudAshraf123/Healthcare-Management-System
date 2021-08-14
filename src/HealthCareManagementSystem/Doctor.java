/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HealthCareManagementSystem;

import java.io.*;
import java.util.Scanner;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author mahmoud
 */
public class Doctor extends Data {
    
     //Variables:
    private String Specialityinmedecin;
    private List<String[]> d = new ArrayList<>();
    
    //Functions:

    public Doctor()
    {
        
    }
    public Doctor(String medecin, int Id, String Name, String Address, int Phone) {
        super(Id, Name, Address, Phone);
        this.Specialityinmedecin = medecin;
    }
   

    public String getSpecialityinmedecin() {
        return Specialityinmedecin;
    }

    public List<String[]> getD() {
        return d;
    }

    @Override
    public void WriteToFile() {
        
        try{
        File f = new File("DoctorData.txt");
        BufferedWriter b = new BufferedWriter(new FileWriter(f,true));
        b.write(Id + "-" + Name + "-" + Address + "-" + Phone + "-" + Specialityinmedecin);
        b.newLine();
        b.close();
                }
        catch(Exception e)
        {
            
        }
        
    }

    @Override
    public List Display() {
        
        try{
        File f = new File("DoctorData.txt");
        Scanner myReader = new Scanner(f); 
        
        while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String end[] = data.split("-");
        d.add(end);
         }
      myReader.close();
        
        }
        catch(Exception e)
        {
            
        }
        return d;
    }
    
    
    @Override
    public boolean delete(String id)
    {
         boolean IdExist = false;
        try{
        File f = new File("DoctorData.txt");
        File tempFile = new File("myTempFile.txt");

        Scanner reader = new Scanner(f);
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile,true));

       // String lineToRemove;
       // String currentLine;
       
        while(reader.hasNextLine()) {
         
         String data = reader.nextLine();
         String end[] = data.split("-");
          if(end[0].equals(id)) 
          {
              IdExist = true;
              continue;
          }
          writer.write(data);
          writer.newLine();
        }
        writer.close(); 
        reader.close(); 
       
        f.delete();
          boolean successful = tempFile.renameTo(f);
        if(IdExist == true)
            return true;
        else
            return false;
        }
        catch(Exception e)
        {
            
        }
        
        return IdExist;
    }
    
    public boolean Search(int ID)
    {
         try{
        File f = new File("DoctorData.txt");
        
        boolean IdExist=false;
        Scanner reader = new Scanner(f);
        
        while(reader.hasNextLine()) {
         
         String data = reader.nextLine();
         String end[] = data.split("-");
          if(end[0].equals(String.valueOf(ID))) 
          {
              IdExist = true;
              
              break;
          }
          
        }
        
        reader.close(); 
       if(IdExist == true)
           return true;
       else{
           System.out.println("Errorrrrrrr");
           return false;
       
       }
        }
        catch(Exception e)
        {
            System.out.println("Errorrrrrrr");
            return false;
        }
    }
    
    public Doctor Get(int ID)
    {
         try{
        File f = new File("DoctorData.txt");
        
        
        Scanner reader = new Scanner(f);
        
        while(reader.hasNextLine()) {
         
         String data = reader.nextLine();
         String end[] = data.split("-");
          if(end[0].equals(String.valueOf(ID))) 
          {
              this.Id=Integer.parseInt(end[0]);
              this.Name=end[1];
              this.Address=end[2];
              this.Phone=Integer.parseInt(end[3]);
              this.Specialityinmedecin=end[4];
              break;
          }
          
        }
        
        reader.close(); 
       return this;
        }
        catch(Exception e)
        {
            return this;
        }
    }
           
}
