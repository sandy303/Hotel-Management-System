/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel_Management_System;

/**
 *
 * @author HP
 */
 public   class  Person 
{
   private  int ID ;
    String Name;
    public Person ()
    {
        ID = 0;
        Name = null;
    }
    public Person ( int ID , String Name)
    {
       this.ID=ID;
       this.Name=Name;
    }
    public void  SetID ( int ID)
    {
      this.ID=ID;
    }
    public int GetID ()
    {
     return ID;
    }
}