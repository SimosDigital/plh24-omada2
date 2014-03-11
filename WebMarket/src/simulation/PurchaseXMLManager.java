/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulation;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.Purchase;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author user0
 */
public class PurchaseXMLManager {
        
    private final DateFormat df;
    private File xmlFile;
    private boolean isNewDocument = true;
    
    public PurchaseXMLManager(File xmlFile){
        this.xmlFile = xmlFile;        
        df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }
    
    private Document readXmlDocument() {
        Document document;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(xmlFile);
            isNewDocument = false;
            return document;
        }catch (Exception e){
            // File does not exist
            isNewDocument = true;
            return null;
        }
    }
    
    public void writeXML(List<Purchase> purchases){        
        Document document = readXmlDocument();
        try {            
            if (isNewDocument){ // Create New file
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                document = docBuilder.newDocument();            
                Element rootElement = document.createElement("purchases");            
                document.appendChild(rootElement);
            }
            Element root = document.getDocumentElement();
            
            for (Purchase p:purchases){
                // purchase elements                
                Element purchase = document.createElement("Purchase");
                root.appendChild(purchase);

                // set attribute to purchase element
                Attr attr = document.createAttribute("id");
                attr.setValue(p.getPurchaseId().toString());
                purchase.setAttributeNode(attr);

                // date elements
                Element date = document.createElement("date");
                date.appendChild(document.createTextNode(df.format(p.getDatetime())));
                purchase.appendChild(date);

                // amount elements
                Element amount = document.createElement("amount");
                amount.appendChild(document.createTextNode(Float.toString(p.getAmount())));
                purchase.appendChild(amount);
                
                // points_earned element
                Element pointsEarned = document.createElement("points_earned");
                pointsEarned.appendChild(document.createTextNode(Integer.toString(p.getPointsEarned())));
                purchase.appendChild(pointsEarned);
                
                // delivery elements
                Element isCreditCardUsed = document.createElement("delivery");
                isCreditCardUsed.appendChild(document.createTextNode(Integer.toString(p.getDelivery())));
                purchase.appendChild(isCreditCardUsed);

                // store elements
                Element store = document.createElement("store");
                store.appendChild(document.createTextNode(p.getStoreId().getName()));
                purchase.appendChild(store);

                // customer elements
                Element customer = document.createElement("customer");
                customer.appendChild(document.createTextNode(p.getCustomerId().getLastName()+" "+p.getCustomerId().getFirstName()));
                purchase.appendChild(customer);
            }
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);      
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);
            System.out.println("File saved!");
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public float calculateAveragePurchaseAmount(){
        Document document = readXmlDocument();        
        if (isNewDocument) {
            System.out.println("Δεν υπάρχει το αρχείο purchases.xml στην τοποθεσία C:\\temp");
            return 0.0f;
        }
        
        Element root = document.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        float sum=0.0f;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);            
            NodeList subNodeList = currentNode.getChildNodes();
            for (int j = 0; j < subNodeList.getLength(); j++) {
                Node currentSubNode = subNodeList.item(j);
                if (currentSubNode.getNodeName().equalsIgnoreCase("amount")) {
                    float value = Float.valueOf(currentSubNode.getTextContent());
                    sum+=value;
                }                
            }            
        }
        return sum/(float)nodeList.getLength();
    }
}