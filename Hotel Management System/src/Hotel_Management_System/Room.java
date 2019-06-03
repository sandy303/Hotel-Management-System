/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel_Management_System;

import javax.swing.JOptionPane;
import Hotel_Management_System.RecieptionistForm.*;
import java.awt.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */

  public  class Room 
{
    int [] RoomNum  ;// = new boolean [35] ;
    int Num ;
    int DurationDays ;
    double RoomCost;
    String RoomInfo ;
     int AvailbleCounter ;
     int NonAvailbleCounter;
     String Date1=RecieptionistForm.jTextField7.getText() ;
     String Date2=RecieptionistForm.jTextField8.getText() ;
     public Room()
     {
         Num=0;
         DurationDays=0;
         RoomInfo=null;
     }
   public Room ( String RoomInfo, int Num,int DurationDays  )
  {
        Date1=RecieptionistForm.jTextField7.getText() ;
      Date2=RecieptionistForm.jTextField8.getText() ;
      this.DurationDays=calDays(Date1,Date2);
      this.RoomInfo=RoomInfo;
      this.Num=Num;
      RoomNum = new int [35] ;
  }
   public  boolean GetAvailibility (int num)
  {
      boolean IsAvailble=true;
      num = Num ;
      for (int j =0 ; j < RoomNum.length;j++)
      {
       RoomNum[j]=0;
      }
       for (int i = 0 ; i < RoomNum.length ; i++ )
      {
           if (RoomNum[i]==Num)
           {
            RoomNum[i]=1;
            JOptionPane.showMessageDialog(null,"The reservation is done successfully","Availibility",JOptionPane.INFORMATION_MESSAGE);
           }
      }
       for ( int i = 0 ; i < RoomNum.length ; i++ )
       {
         //  if (RoomNum.length==0)
           if (RoomNum[i]==0)
           {
             IsAvailble = true;
             break;
           }
           else 
            IsAvailble = false ;
       }
           return IsAvailble ;
  }
   public int GetAvailbleCounter()
   {
       for ( int i = 0 ; i < RoomNum.length ; i++)
       {
          if (RoomNum[i]==0)
          {
           AvailbleCounter ++;
          }
        }
       return AvailbleCounter ;
   }
   public int GetNonAvailbleCounter ()
   {
    for ( int i = 0 ; i < RoomNum.length ; i++)
       {
          if (RoomNum[i]==1)
          {
           NonAvailbleCounter ++;
          }
        }
       return NonAvailbleCounter ;
   }
     public double  RoomPrice( String  RoomInfo )
    {   
        RoomInfo=this.RoomInfo;
      if ( RoomInfo== "Single")
      {
          RoomCost = 1000; 
      }
      else if (RoomInfo=="Double")
      {
       RoomCost=2000;
      }
      else if (RoomInfo=="Triple")
      {
      RoomCost = 2500;
      }
      return RoomCost;
    }
    public double CalcMonthlyIncome()
    {
        //int Count =0;
        double Income=0.0;
        //final double Rate = 0.15;
        if (Date1.substring(3,4).equals(EmployeesForm.jTextField11.getText().toString()))
        {
              Resident r = new Resident () ;
            ResidentsFile f = new ResidentsFile();
            ArrayList <Resident> a = new ArrayList();
             try {
                 a=f.load();
             } catch (Exception ex) {
                 Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
             }
         // double tax = Rate*Income;
          //Income -=tax;
          for ( int i = 0 ; i < a.size();i++ )
          {
             if( a.get(11).equals(EmployeesForm.jTextField11.getText().toString()))
             {
              double Total = a.get(i).CalcAccomodationCost(RecieptionistForm.jComboBox3.getSelectedItem().toString(),Integer.valueOf(RecieptionistForm.jTextField5.getText()),RecieptionistForm.jComboBox2.getSelectedItem().toString() ,RecieptionistForm.jTextField11.getText(),RecieptionistForm.jTextField12.getText());
              
           //double Total= r.CalcAccomodationCost(RecieptionistForm.jComboBox3.getSelectedItem().toString(),Integer.valueOf(RecieptionistForm.jTextField5.getText()),RecieptionistForm.jComboBox2.getSelectedItem().toString() ,RecieptionistForm.jTextField11.getText(),RecieptionistForm.jTextField12.getText());
                Income+=Total;
             //   Count ++;
             }
//             for (int j = 0 ; j < Count ; j ++)
//             {
//              double Total= r.CalcAccomodationCost(RoomInfo, DurationDays, Date1, Date1, Date2);
//                Income+=Total;
//             }
          }
         }
        else 
        {
         JOptionPane.showMessageDialog(null,"try Different Month","Monthly Income", JOptionPane.ERROR_MESSAGE);
        }
        return Income;
    }
//   public  double CalcWeeklyIncome()
//     {
//          double Income=1;
//           final double Rate = 0.15;
//         if ()
//         {
//            double tax = Rate*Income;
//           Income -=tax;
//           return Income;
//         }
//         return Income;
//     }
    public  double CalcAnnuallyIncome()
        {
        //int Count =0;
        double Income=0.0;
        //final double Rate = 0.15;
        if (Date1.substring(6,9).equals(EmployeesForm.jTextField11.getText().toString()))
        {
              Resident r = new Resident () ;
            ResidentsFile f = new ResidentsFile();
            ArrayList <Resident> a = new ArrayList();
             try {
                 a=f.load();
             } catch (Exception ex) {
                 Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
             }
         // double tax = Rate*Income;
          //Income -=tax;
          for ( int i = 0 ; i < a.size();i++ )
          {
             if( a.get(11).equals(EmployeesForm.jTextField11.getText().toString()))
             {
              double Total = a.get(i).CalcAccomodationCost(RecieptionistForm.jComboBox3.getSelectedItem().toString(),Integer.valueOf(RecieptionistForm.jTextField5.getText()),RecieptionistForm.jComboBox2.getSelectedItem().toString() ,RecieptionistForm.jTextField11.getText(),RecieptionistForm.jTextField12.getText());           
           //double Total= r.CalcAccomodationCost(RecieptionistForm.jComboBox3.getSelectedItem().toString(),Integer.valueOf(RecieptionistForm.jTextField5.getText()),RecieptionistForm.jComboBox2.getSelectedItem().toString() ,RecieptionistForm.jTextField11.getText(),RecieptionistForm.jTextField12.getText());
                Income+=Total;
             //   Count ++;
             }
//             for (int j = 0 ; j < Count ; j ++)
//             {
//              double Total= r.CalcAccomodationCost(RoomInfo, DurationDays, Date1, Date1, Date2);
//                Income+=Total;
//             }
          }
         }
        else 
        {
         JOptionPane.showMessageDialog(null,"try Different Month","Monthly Income", JOptionPane.ERROR_MESSAGE);
        }
        return Income;
   
        }
      public static int calDays(String date1, String date2)
    {
        int curDay = Integer.valueOf(date1.substring(0, 2)) - 1;
        int curMonth = Integer.valueOf(date1.substring(3, 5)) - 1;
        int curYear = Integer.valueOf(date1.substring(6));
        int lastDay = Integer.valueOf(date2.substring(0, 2)) - 1;
        int lastMonth = Integer.valueOf(date2.substring(3, 5)) - 1;
        int lastYear = Integer.valueOf(date2.substring(6));
        int months[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int Days = 0;
        while(curDay != lastDay || curMonth != lastMonth || curYear != lastYear)
        {
            curDay += 1;
            Days += 1;
            curDay %= months[curMonth]-1;
            if(curDay == 0) curMonth += 1;
            curMonth %= 12;
            if(curMonth == 0 && curDay == 0) curYear += 1;
        }
        return Days;
    }
}