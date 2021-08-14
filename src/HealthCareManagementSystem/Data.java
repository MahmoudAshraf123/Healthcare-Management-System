package HealthCareManagementSystem;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mahmoud
 */
public abstract class Data {
    
    //Variables:
    protected int Id;
    protected String Name;
    protected String Address;
    protected int Phone ;
  
    
    
    //Functions:
    public Data()
    {
    
    }
    public Data(int Id, String Name, String Address, int Phone) {
        this.Id = Id;
        this.Name = Name;
        this.Address = Address;
        this.Phone = Phone;
    }
    public abstract void WriteToFile();
    public abstract List Display();
    public abstract boolean delete(String id);
    
    
    
    
}
