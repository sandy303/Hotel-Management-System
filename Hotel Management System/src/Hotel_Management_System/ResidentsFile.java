/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel_Management_System;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author HP
 */
public class ResidentsFile
{
 String FileName;
 public ResidentsFile()
 {
  FileName= "Residents.xml";
 }
 public void savefile (ArrayList<Resident> list) throws Exception 
{
         DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbfactory.newDocumentBuilder();
            try {
                Document doc =db.parse(FileName);
                Element root = doc.getDocumentElement();
                for(int i=0;i<list.size();i++)
                {
                Element resident = doc.createElement("Resident");
  
                Element name = doc.createElement("Name"); 
                name.appendChild(doc.createTextNode(list.get(i).Name));
                resident.appendChild(name);

                Element id = doc.createElement("ID");
                id.appendChild(doc.createTextNode(Integer.toString(list.get(i).GetID())));
                resident.appendChild(id);
                
                Element adress = doc.createElement("Address");
                adress.appendChild(doc.createTextNode(list.get(i).Address));
                resident.appendChild(adress);
                
                Element phonenum = doc.createElement("PhoneNum");
                phonenum.appendChild(doc.createTextNode(Integer.toString(list.get(i).PhoneNum)));
                resident.appendChild(phonenum);
                
                Element nationality = doc.createElement("Nationality");
                nationality.appendChild(doc.createTextNode(list.get(i).Nationality));
                resident.appendChild(nationality);
                
                Element email = doc.createElement("Email");
                email.appendChild(doc.createTextNode(list.get(i).EMail));
                resident.appendChild(email);
                
                Element gender= doc.createElement("Gender");
                gender.appendChild(doc.createTextNode(list.get(i).Gender));
                resident.appendChild(gender);
                
                 Element date1= doc.createElement("CheckInDate");
                date1.appendChild(doc.createTextNode(list.get(i).Date1));
                resident.appendChild(date1);
                
                 Element date2= doc.createElement("CheckOutDate");
                date2.appendChild(doc.createTextNode(list.get(i).Date2));
                resident.appendChild(date2);
                
                 Element roomduration= doc.createElement("DurationDays");
                roomduration.appendChild(doc.createTextNode(Integer.toString(list.get(i).R.DurationDays)));
                resident.appendChild(roomduration);
                
                 Element roomtype= doc.createElement("RoomType");
                roomtype.appendChild(doc.createTextNode(list.get(i).R.RoomInfo));
                resident.appendChild(roomtype);
                
                 Element roomnum= doc.createElement("RoomNum");
                roomnum.appendChild(doc.createTextNode(Integer.toString(list.get(i).R.Num)));
                resident.appendChild(roomnum);
                
                root.appendChild(resident);
                }
                TransformerFactory tf=TransformerFactory.newInstance();
                Transformer t = tf.newTransformer();
                DOMSource source=new DOMSource(doc);
                StreamResult s=new StreamResult(FileName);
                t.transform(source, s);

            }
            catch (FileNotFoundException e)
            {
                Document doc= db.newDocument();
                Element residents = doc.createElement("Residents");
                for(int i=0;i<list.size();i++)
                {
                Element resident =doc.createElement("Resident");
                doc.appendChild(residents);
               residents.appendChild(resident);
               
               Element name = doc.createElement("Name"); 
                name.appendChild(doc.createTextNode(list.get(i).Name));
                resident.appendChild(name);

                Element id = doc.createElement("ID");
                id.appendChild(doc.createTextNode(Integer.toString(list.get(i).GetID())));
                resident.appendChild(id);
                
                Element adress = doc.createElement("Address");
                adress.appendChild(doc.createTextNode(list.get(i).Address));
                resident.appendChild(adress);
                
                Element phonenum = doc.createElement("PhoneNum");
                phonenum.appendChild(doc.createTextNode(Integer.toString(list.get(i).PhoneNum)));
                resident.appendChild(phonenum);
                
                Element nationality = doc.createElement("Nationality");
                nationality.appendChild(doc.createTextNode(list.get(i).Nationality));
                resident.appendChild(nationality);
                
                Element email = doc.createElement("Email");
                email.appendChild(doc.createTextNode(list.get(i).EMail));
                resident.appendChild(email);
                
                Element gender= doc.createElement("Gender");
                gender.appendChild(doc.createTextNode(list.get(i).Gender));
                resident.appendChild(gender);
                
                Element date1= doc.createElement("CheckInDate");
                date1.appendChild(doc.createTextNode(list.get(i).Date1));
                resident.appendChild(date1);
                
                 Element date2= doc.createElement("CheckOutDate");
                date2.appendChild(doc.createTextNode(list.get(i).Date2));
                resident.appendChild(date2);
                
                 Element roomduration= doc.createElement("DurationDays");
                roomduration.appendChild(doc.createTextNode(Integer.toString(list.get(i).R.DurationDays)));
                resident.appendChild(roomduration);
                
                 Element roomtype= doc.createElement("RoomType");
                roomtype.appendChild(doc.createTextNode(list.get(i).R.RoomInfo));
                resident.appendChild(roomtype);
                
                 Element roomnum= doc.createElement("RoomNum");
                roomnum.appendChild(doc.createTextNode(Integer.toString(list.get(i).R.Num)));
                resident.appendChild(roomnum);
                
                 TransformerFactory tf=TransformerFactory.newInstance();
                Transformer t = tf.newTransformer();
                DOMSource source=new DOMSource(doc);
                StreamResult s=new StreamResult(FileName);
                t.transform(source, s);
                }
          }
}
public ArrayList <Resident>load()throws Exception
{
    ArrayList<Resident> list = new ArrayList<Resident>() ;
    try{
         DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
         DocumentBuilder db = dbf.newDocumentBuilder();
         File xmlfile =new File (FileName);
         Document doc =db.parse(xmlfile);
         doc.getDocumentElement().normalize();
         NodeList nl =doc.getElementsByTagName("Resident");
         for(int i=0;i<nl.getLength();i++)
         {
         Node n=nl.item(i);
         if(n.getNodeType()==Node.ELEMENT_NODE)
         {
             Element el = (Element)n;
             String name= el.getElementsByTagName("Name").item(0).getTextContent();
             int id=Integer.valueOf(el.getElementsByTagName("ID").item(0).getTextContent());
             String adress= el.getElementsByTagName("Address").item(0).getTextContent();
             int phonenum=Integer.valueOf( el.getElementsByTagName("PhoneNum").item(0).getTextContent());
             String nationality= el.getElementsByTagName("Nationality").item(0).getTextContent();
             String email= el.getElementsByTagName("Email").item(0).getTextContent();
             String gender= el.getElementsByTagName("Gender").item(0).getTextContent();
             String date1= el.getElementsByTagName("CheckInDate").item(0).getTextContent();
             String date2= el.getElementsByTagName("CheckOutDate").item(0).getTextContent();
             int roomduration= Integer.valueOf(el.getElementsByTagName("DurationDays").item(0).getTextContent());
             String roomtype= el.getElementsByTagName("RoomType").item(0).getTextContent();
             int roomnum=Integer.valueOf(el.getElementsByTagName("RoomNum").item(0).getTextContent());
             String servicetype = el.getElementsByTagName("ServiceType").item(0).getTextContent();
            Resident r =new Resident (id,name,servicetype,roomtype, roomduration,roomnum,email,  adress,phonenum, nationality, gender ,date1,date2);
             list.add(r);
         }
         }
    }catch(SAXException | IOException | DOMException f){
    
    return list;
    }
    return list;
}

public void editfile(Resident R ) throws Exception
{
    delete(R.Name);
    DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbfactory.newDocumentBuilder();
          
                Document doc =db.parse(FileName);
                Element root = doc.getDocumentElement();
                Element resident = doc.createElement("Resident");
  
                Element name = doc.createElement("Name"); 
                name.appendChild(doc.createTextNode(R.Name));
                resident.appendChild(name);

                Element id = doc.createElement("ID");
                id.appendChild(doc.createTextNode(Integer.toString(R.GetID())));
                resident.appendChild(id);
                
                Element address = doc.createElement("Adress");
                address.appendChild(doc.createTextNode(R.Address));
                resident.appendChild(address);
                
                Element phonenum = doc.createElement("PhoneNum");
                phonenum.appendChild(doc.createTextNode(Integer.toString(R.PhoneNum)));
                resident.appendChild(phonenum);
                
                Element nationality = doc.createElement("Nationality");
                nationality.appendChild(doc.createTextNode(R.Nationality));
                resident.appendChild(nationality);
                
                Element email = doc.createElement("Email");
                email.appendChild(doc.createTextNode(R.EMail));
                resident.appendChild(email);
                
                Element gender= doc.createElement("Gender");
                gender.appendChild(doc.createTextNode(R.Gender));
                resident.appendChild(gender);
                
                 Element date1= doc.createElement("CheckInDate");
                date1.appendChild(doc.createTextNode(R.Date1));
                resident.appendChild(date1);
                
                 Element date2= doc.createElement("CheckOutDate");
                date2.appendChild(doc.createTextNode(R.Date2));
                resident.appendChild(date2);
                
                 Element roomduration= doc.createElement("DurationDays");
                roomduration.appendChild(doc.createTextNode(Integer.toString(R.DurationDays)));
                resident.appendChild(roomduration);
                
                 Element roomtype= doc.createElement("RomType");
                roomtype.appendChild(doc.createTextNode(R.RoomInfo));
                resident.appendChild(roomtype);
                
                 Element roomnum= doc.createElement("RoomNum");
                roomnum.appendChild(doc.createTextNode(Integer.toString(R.Num)));
                resident.appendChild(roomnum);
                
                root.appendChild(resident);
    
}

void delete (String s) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException
{
    //search by name
    DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbfactory.newDocumentBuilder();
    Document doc =db.parse(FileName);
    NodeList lst =doc.getElementsByTagName("Name");
    Node p = null;
    for(int i=0;i<lst.getLength();i++)
    {
        String content =lst.item(i).getTextContent();
        if(content.equalsIgnoreCase(s))
        {
         p =lst.item(i).getParentNode();
        }
    }
    doc.getDocumentElement().removeChild(p);
    //save data
      DOMSource source=new DOMSource(doc);
      File f=new File(FileName);
      Result result =new StreamResult(f);
     TransformerFactory tf=TransformerFactory.newInstance();
     Transformer t = tf.newTransformer();
     t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
     t.setOutputProperty(OutputKeys.INDENT, "yes");
     t.transform(source, result);
  
  }

}
