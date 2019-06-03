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
 public class Resident extends Person
{
     Room  R;
    int Num ; 
    String RoomInfo;
    String ServiceType ;
    double AccommodationCOST; 
    String EMail ;
    String Address ;
    int PhoneNum;
    String Nationality;
    String Gender ;
         String Date1 ;
          String Date2;
          int DurationDays;//= calDays(Date1,Date2);
     public Resident (int ID , String Name , String ServiceType, String RoomInfo , int DurationDays , int Num , String EMail, String Address , int PhoneNum, String Nationality,String Gender,String Date1,String Date2)
    {
      super (ID,Name);
      this.ServiceType=ServiceType;
      this.RoomInfo=RoomInfo;
      this.EMail=EMail;
      this.Address=Address;
      this.PhoneNum=PhoneNum;
      this.Nationality=Nationality; 
      this.Gender=Gender;
      R= new Room ( RoomInfo, Num, DurationDays);
      this.DurationDays=calDays(Date1,Date2);
      
    }
     public Resident ()
     {
     }
     public int CalcAccomodationCost ( String RoomInfo , int DurationDays, String ServiceType , String Date1 , String Date2 )
    {
        DurationDays = calDays(Date1 , Date2);
         int RoomCost=0;
         int ServiceCost=0;
//        if (RoomInfo.equals("single"))
//        {
//             RoomCost = 1000;
//        }
//        else if (RoomInfo.equals("double"))
//        {
//         RoomCost = 2000;
//        }
//        else if (RoomInfo.equals("triple"))
//        {
//            RoomCost=3000;
//        }
         RoomCost=(int)R.RoomPrice(RoomInfo);
        if (ServiceType.equals("allinclusive"))
        {
            ServiceCost =1500;
        }
        else if (ServiceType.equals("halfboard"))
        {
            ServiceCost=1000;
        }
        else if (ServiceType.equals("breakfast"))
        {
            ServiceCost=600;
        }
        int Cost = RoomCost*DurationDays+ServiceCost;
                return Cost ;
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
        int Days = 1;
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