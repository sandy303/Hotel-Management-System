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
public abstract class SuperVisers  extends Person
{
    int ID ;
    String Name ;
    String JobTitle ;
    double Salary;
     public SuperVisers ()
     {
         super();
         JobTitle=null;
         Salary=0.0;
     }
     public SuperVisers( int ID , String Name , String JobTitle , double Salary)
     {
       super(ID,Name);
       this.Salary=Salary;
       this.JobTitle=JobTitle;
     }
     public abstract void Add ();
     public abstract void Edit();
     public abstract void Delete ();
}
