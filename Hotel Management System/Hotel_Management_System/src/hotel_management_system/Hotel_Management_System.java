/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_management_system;
import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author HP
 */
public class Hotel_Management_System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame fram =new JFrame ("Hotel Management System");
      JPanel panel = new JPanel();
      fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fram.setLayout(new FlowLayout());
      fram.setSize(1600, 1000);
      fram.setVisible(true);
      JButton b1 = new JButton ("Manager");
      fram.add(b1);
     // JLabel l1 = new JLabel ("");
      Room r = new Room (123,"sameh",3,"halfboard,","single",34);
      if (r.GetRoomNum(34))
      {
       JOptionPane.showMessageDialog(fram, "NO ROOMS ARE VAILBLE ANY MORE !!");
      }
 
    }

 static public class Resident 
{
    int ID ;
    String Name ;
    int DurationDays ;
    String RoomInfo;
  //  String RoomNum;
    String ServiceType;
    double AccommodationCOST;
    Resident (int ID , String Name , int DurationDays , String ServiceType, String RoomInfo )
    {
      this.ID=ID;
      this.Name=Name;
      this.DurationDays=DurationDays;
      this.ServiceType=ServiceType;
      this.RoomInfo=RoomInfo;
    }
    double CalcAccomodatioCost ( String RoomInfo , int DurationDays, String ServiceType )
    {
        double RoomCost=0.0;
        double ServiceCost=0.0;
        if (RoomInfo.equals("single"))
        {
             RoomCost = 1000;
        }
        else if (RoomInfo.equals("double"))
        {
         RoomCost = 2000;
        }
        else if (RoomInfo.equals("trible"))
        {
            RoomCost=3000;
        }
        else if (RoomInfo.equals("familyroom"))
        {
            RoomCost=3500;
        }
        else if (RoomInfo.equals("sweat"))
        {
            RoomCost=4000;
        }
        if (ServiceType.equals("allinclusive"))
        {
            ServiceCost =1500;
        }
        else if (ServiceType.equals("halfboard"))
        {
            ServiceCost=1000;
        }
        else if (ServiceType.equals("breakfastonly"))
        {
            ServiceCost=600;
        }
        if (ServiceType.equals("Harddrink"))
        {
            ServiceCost+=300;
        }
        Double Cost = RoomCost*DurationDays+ServiceCost;
                return Cost ;
    }
}
 static public class Room extends Resident
{
     int [] RoomNum  = new int [350] ;
     int Num ;
    //String RoomType ;
  Room ( int ID , String Name , int DurationDays , String ServiceType,String RoomInfo, int Num)
  {
      super( ID ,  Name ,  DurationDays , ServiceType, RoomInfo);
     // RoomNum = new int [350] ;
  }
    boolean GetRoomNum (int num)
  {
      num = Num ;
       for (int i = 0 ; i < RoomNum.length ; i++ )
      {
           RoomNum[i]=num;    
           if (RoomNum.length==0)
               return true;
      }
       return false;
  }
}
}