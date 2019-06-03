/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel_Management_System;
import javax.swing.JOptionPane;
import Hotel_Management_System.EmployeesForm;
/**
 *
 * @author HP
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
 public  class  Employee  extends Person
   {
     private int ID ;
     String Name;
  public double Salary ;
  public  String JobTitle ;
 public Employee()
 {
   super ();
 }
   public  Employee ( int ID, String Name , Double Salary , String JobTitle)
  {
     super (ID,Name);
     this.JobTitle=JobTitle ;
      this.Salary=Salary ;
  }
   public int GetID()
   {
    return this.ID;
   }
   public void SetID( int ID)
   {
    this.ID=ID;
   }
}
