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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author HP
 */
    public  class Manager extends SuperVisers
 {
   //   Employee e ;
      private String UserName = "Ahmed" ;
     private int Password = 123 ;
      String JobTitle ;
      double Salary ;
      int ID;
      String filename;
  public Manager ()
  {
   super();
    filename ="employee.xml";
  }
//    public Manager ( int ID , String Name ,String JobTitle , double Salary)
//  {
//      super(ID,Name,JobTitle,Salary);
//  }
 public boolean login(String s,int p)
{
     if(s.equals(UserName)&&p==Password)
         return true;
     else
         return false;
         
 }
  public void SetUserName(String Name)
  {
     this.Name=Name;
  }
   public String  GetUserName ()
   {
    return UserName;
   }
    public int GetPassword()
   {
    return Password;
   }
   public void SetPassword(int password)
   {
    this.Password=password;
   }
    public void Add()
    {
//               DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder db = dbfactory.newDocumentBuilder();
//            try {
//                Document doc =db.parse(filename);
//                Element root = doc.getDocumentElement();
//                for(int i=0;i<list.size();i++)
//                {
//                Element employee = doc.createElement("Employee");
//  
//                Element name = doc.createElement("Name"); 
//                name.appendChild(doc.createTextNode(list.get(i).Name));
//                employee.appendChild(name);
//
//                Element id = doc.createElement("ID");
//                id.appendChild(doc.createTextNode(String.valueOf(list.get(i).GetID())));
//                employee.appendChild(id);
//                
//                Element jobtitle = doc.createElement("JobTitle");
//                jobtitle.appendChild(doc.createTextNode(list.get(i).JobTitle));
//                employee.appendChild(jobtitle);
//                
//                Element salary = doc.createElement("Salary");
//                salary.appendChild(doc.createTextNode(String.valueOf(list.get(i).Salary)));
//                employee.appendChild(salary);
//                
//                root.appendChild(employee);
//                }
//                TransformerFactory tf=TransformerFactory.newInstance();
//                Transformer t = tf.newTransformer();
//                DOMSource source=new DOMSource(doc);
//                StreamResult s=new StreamResult(filename);
//                t.transform(source, s);
//
//            }
//            catch (FileNotFoundException e)
//            {
//                Document doc= db.newDocument();
//                Element employees = doc.createElement("Employees");
//                for(int i=0;i<list.size();i++)
//                {
//                Element employee =doc.createElement("Employee");
//                doc.appendChild(employees);
//               employees.appendChild(employee);
//               
//               Element name=doc.createElement("Name");
//               name.appendChild(doc.createTextNode(list.get(i).Name));
//               employee.appendChild(name);
//               
//               Element id=doc.createElement("ID");
//               //Integer.toString(list.get(i).GetID());
//               id.appendChild(doc.createTextNode(String.valueOf(list.get(i).GetID())));
//               employee.appendChild(id);
//               
//               Element jobtitle=doc.createElement("JobTitle");
//               jobtitle.appendChild(doc.createTextNode(list.get(i).JobTitle));
//               employee.appendChild(jobtitle);
//              
//               Element salary=doc.createElement("Salary");
//               name.appendChild(doc.createTextNode(String.valueOf(list.get(i).Salary)));
//               employee.appendChild(salary);
//               
//                }
//                 TransformerFactory tf=TransformerFactory.newInstance();
//                Transformer t = tf.newTransformer();
//                DOMSource source=new DOMSource(doc);
//                StreamResult s=new StreamResult(filename);
//                t.transform(source, s);
//                }
//                
        try {
             Employee e = new Employee(Integer.valueOf(EmployeesForm.jTextField13.getText()),EmployeesForm. jTextField14.getText(),Double.valueOf(EmployeesForm.jTextField15.getText()), EmployeesForm.jTextField16.getText());
          ArrayList<Employee>l = new ArrayList<>();
         l.add(e);
         EmployeesFile fm =new EmployeesFile ();
         fm.savefile(l);
        } 
         catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null," incorrect", "alert",JOptionPane.WARNING_MESSAGE);
        }
         JOptionPane.showMessageDialog(null," correct", "alert",JOptionPane.WARNING_MESSAGE);
    }
    public void Edit()// throws Exception
    {
//          DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder db = dbfactory.newDocumentBuilder();
//                Document doc =db.parse(filename);
//                Element root = doc.getDocumentElement();
//                for(int i=0;i<list.size();i++)
//                {
//                Element employee = doc.createElement("Employee");
//  
//                Element name = doc.createElement("Name"); 
//                name.appendChild(doc.createTextNode(list.get(i).Name));
//                employee.appendChild(name);
//
//                Element id = doc.createElement("ID");
//                id.appendChild(doc.createTextNode(String.valueOf(list.get(i).GetID())));
//                employee.appendChild(id);
//                
//                Element jobtitle = doc.createElement("JobTitle");
//                jobtitle.appendChild(doc.createTextNode(list.get(i).JobTitle));
//                employee.appendChild(jobtitle);
//                
//                Element salary = doc.createElement("Salary");
//                salary.appendChild(doc.createTextNode(String.valueOf(list.get(i).Salary)));
//                employee.appendChild(salary);
//                
//                root.appendChild(employee);
//                }
//                TransformerFactory tf=TransformerFactory.newInstance();
//                Transformer t = tf.newTransformer();
//                DOMSource source=new DOMSource(doc);
//                StreamResult s=new StreamResult(filename);
//                t.transform(source, s);
           EmployeesFile  f = new EmployeesFile ();  
         ArrayList <Employee> a = new ArrayList ();
        try {
            f.editfile(a);
        } catch (Exception ex) {
            Logger.getLogger(RecieptionistForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Delete()// throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException

    {
//           DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
//    DocumentBuilder db = dbfactory.newDocumentBuilder();
//    Document doc =db.parse(filename);
//    NodeList lst =doc.getElementsByTagName("Name");
//    Node p = null;
//    for(int i=0;i<lst.getLength();i++)
//    {
//        String content =lst.item(i).getTextContent();
//        if(content.equalsIgnoreCase(s))
//        {
//         p =lst.item(i).getParentNode();
//        }
//    }
//    doc.getDocumentElement().removeChild(p);
//    //save data
//      DOMSource source=new DOMSource(doc);
//      File f=new File(filename);
//      Result result =new StreamResult(f);
//     TransformerFactory tf=TransformerFactory.newInstance();
//     Transformer t = tf.newTransformer();
//     t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
//     t.setOutputProperty(OutputKeys.INDENT, "yes");
//     t.transform(source, result);
         String name = JOptionPane.showInputDialog("Name :");
                  EmployeesFile f = new EmployeesFile();
                          try {
              f.delete(name);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RecieptionistForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(RecieptionistForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RecieptionistForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(RecieptionistForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @Override
//    public void Add() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void Edit() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void Delete() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    }
