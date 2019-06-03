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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class EmployeesFile {
    String filename;

EmployeesFile()
{
filename ="Employee.xml";
}

public void savefile (ArrayList<Employee> list) throws Exception 
{
         DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbfactory.newDocumentBuilder();
            try {
                Document doc =db.parse(filename);
                Element root = doc.getDocumentElement();
                for(int i=0;i<list.size();i++)
                {
                Element employee = doc.createElement("Employee");
  
                Element name = doc.createElement("Name"); 
                name.appendChild(doc.createTextNode(list.get(i).Name));
                employee.appendChild(name);

                Element id = doc.createElement("ID");
                id.appendChild(doc.createTextNode(String.valueOf(list.get(i).GetID())));
                employee.appendChild(id);
                
                Element jobtitle = doc.createElement("JobTitle");
                jobtitle.appendChild(doc.createTextNode(list.get(i).JobTitle));
                employee.appendChild(jobtitle);
                
                Element salary = doc.createElement("Salary");
                salary.appendChild(doc.createTextNode(String.valueOf(list.get(i).Salary)));
                employee.appendChild(salary);
                
                root.appendChild(employee);
                }
                TransformerFactory tf=TransformerFactory.newInstance();
                Transformer t = tf.newTransformer();
                DOMSource source=new DOMSource(doc);
                StreamResult s=new StreamResult(filename);
                t.transform(source, s);

            }
            catch (FileNotFoundException e)
            {
                Document doc= db.newDocument();
                Element employees = doc.createElement("Employee");
                for(int i=0;i<list.size();i++)
                {
                Element employee =doc.createElement("Employee");
                doc.appendChild(employees);
               employees.appendChild(employee);
               
               Element name=doc.createElement("Name");
               name.appendChild(doc.createTextNode(list.get(i).Name));
               employee.appendChild(name);
               
               Element id=doc.createElement("ID");
               //Integer.toString(list.get(i).GetID());
               id.appendChild(doc.createTextNode(String.valueOf(list.get(i).GetID())));
               employee.appendChild(id);
               
               Element jobtitle=doc.createElement("JobTitle");
               jobtitle.appendChild(doc.createTextNode(list.get(i).JobTitle));
               employee.appendChild(jobtitle);
              
               Element salary=doc.createElement("Salary");
               salary.appendChild(doc.createTextNode(String.valueOf(list.get(i).Salary)));
               employee.appendChild(salary);
               
                }
                 TransformerFactory tf=TransformerFactory.newInstance();
                Transformer t = tf.newTransformer();
                DOMSource source=new DOMSource(doc);
                StreamResult s=new StreamResult(filename);
                t.transform(source, s);
                }
                
                           }

public ArrayList <Employee>load()throws Exception
{
    ArrayList<Employee> list = new ArrayList<Employee>() ;
    try{
         DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
         DocumentBuilder db = dbf.newDocumentBuilder();
         File xmlfile =new File (filename);
         Document doc =db.parse(xmlfile);
         doc.getDocumentElement().normalize();
         NodeList nl =doc.getElementsByTagName("Employee");
         for(int i=0;i<nl.getLength();i++)
         {
         Node n=nl.item(i);
         if(n.getNodeType()==Node.ELEMENT_NODE)
         {
             Element el = (Element)n;
             String name= el.getElementsByTagName("Name").item(0).getTextContent();
             String id= el.getElementsByTagName("ID").item(0).getTextContent();
             int ID = Integer.valueOf(id);
             String jobtitle= el.getElementsByTagName("JobTitle").item(0).getTextContent();
             String salary= el.getElementsByTagName("Salary").item(0).getTextContent();
             double Salary = Double.valueOf(salary);
             Employee e =new Employee(ID,name,Salary, jobtitle) ;
             list.add(e);
         }
         }
    }catch(SAXException | IOException | DOMException f){
    
    return list;
    }
    return list;
}
public void editfile(ArrayList<Employee>list) throws Exception
{
    DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbfactory.newDocumentBuilder();
                Document doc =db.parse(filename);
                Element root = doc.getDocumentElement();
                for(int i=0;i<list.size();i++)
                {
                Element employee = doc.createElement("Employee");
  
                Element name = doc.createElement("Name"); 
                name.appendChild(doc.createTextNode(list.get(i).Name));
                employee.appendChild(name);

                Element id = doc.createElement("ID");
                id.appendChild(doc.createTextNode(String.valueOf(list.get(i).GetID())));
                employee.appendChild(id);
                
                Element jobtitle = doc.createElement("JobTitle");
                jobtitle.appendChild(doc.createTextNode(list.get(i).JobTitle));
                employee.appendChild(jobtitle);
                
                Element salary = doc.createElement("Salary");
                salary.appendChild(doc.createTextNode(String.valueOf(list.get(i).Salary)));
                employee.appendChild(salary);
                
                root.appendChild(employee);
                }
                TransformerFactory tf=TransformerFactory.newInstance();
                Transformer t = tf.newTransformer();
                DOMSource source=new DOMSource(doc);
                StreamResult s=new StreamResult(filename);
                t.transform(source, s); 
}
void delete (String s) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException
{
    //search by name
    DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbfactory.newDocumentBuilder();
    Document doc =db.parse(filename);
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
      File f=new File(filename);
      Result result =new StreamResult(f);
     TransformerFactory tf=TransformerFactory.newInstance();
     Transformer t = tf.newTransformer();
     t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
     t.setOutputProperty(OutputKeys.INDENT, "yes");
     t.transform(source, result);
  
  }
}