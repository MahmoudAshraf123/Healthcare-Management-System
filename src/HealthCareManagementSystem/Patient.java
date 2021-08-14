/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HealthCareManagementSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
/**
 *
 * @author mahmoud
 */
public class Patient extends Data{
    private char gender;
    private String Symptoms;
    private String payment_methode;
    private String diagnosis;
    private int room_num;
    private List<String[]> d = new ArrayList<>();
    private boolean isemergency;
    private String DoctorID;
    public char getGender() {
        return gender;
    }

    public boolean isIsemergency() {
        return isemergency;
    }

    public String getSymptoms() {
        return Symptoms;
    }

    public String getPayment_methode() {
        return payment_methode;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public int getRoom_num() {
        return room_num;
    }

    public List<String[]> getD() {
        return d;
    }
    
    public Patient()
    {
        
    }
    public Patient(char gender, String Symptoms, String payment_methode, String diagnosis, int room_num, int Id, String Name, String Address, int Phone,boolean Emergency) {
        super(Id, Name, Address, Phone);
        this.gender = gender;
        this.Symptoms = Symptoms;
        this.payment_methode = payment_methode;
        if(Emergency==false)
            this.room_num = 0;
        else
            this.room_num = room_num;
        this.diagnosis = diagnosis;
        this.isemergency=Emergency;
    }

    @Override
    public void WriteToFile() {
        try{
        File f = new File("PatientData.txt");
        BufferedWriter b = new BufferedWriter(new FileWriter(f,true));
        b.write(Id + "-" + Name + "-" + Address + "-" + Phone + "-" + gender + "-" + Symptoms + "-" + payment_methode + "-" + diagnosis + "-" +isemergency+"-" +room_num );
        b.newLine();
        b.close();
                }
        catch(Exception e)
        {
            
        }    
    }

    public void WriteToFileWithAppointment(String DocId) {
        try{
        File f = new File("PatientData.txt");
        this.DoctorID=DocId;
        BufferedWriter b = new BufferedWriter(new FileWriter(f,true));
        b.write(Id + "-" + Name + "-" + Address + "-" + Phone + "-" + gender + "-" + Symptoms + "-" + payment_methode + "-" + diagnosis + "-" +isemergency+"-" +room_num + "- Appointmentwith -" + DoctorID );
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
        File f = new File("PatientData.txt");
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
        File f = new File("PatientData.txt");
        File tempFile = new File("myTempFile.txt");

        Scanner reader = new Scanner(f);
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile,true));
        
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
        File f = new File("PatientData.txt");
        
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
           
           return false;
       
       }
        }
        catch(Exception e)
        {
            System.err.println("Error");
            return false;
        }
    }
    
    public Patient Get(int ID)
    {
         try{
        File f = new File("PatientData.txt");
        
        
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
              this.gender= end[4].charAt(0);
              this.Symptoms=end[5];
              this.payment_methode=end[6];
              this.diagnosis=end[7];
              if(Integer.parseInt(end[9])==0)
                  this.isemergency=false;
              else
                  this.isemergency=true;
              this.room_num=Integer.valueOf(end[9]);
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
