package com.example.smartpost;

import android.os.StrictMode;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class SmartPosts {
    private static SmartPosts smartPosts = new SmartPosts();


    static SmartPosts getInstance() { return smartPosts; }

    public ArrayList<SmartPostInfo> smartPostList;

    public SmartPosts() {
        ArrayList<SmartPostInfo> postList = new ArrayList<SmartPostInfo>();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "http://iseteenindus.smartpost.ee/api/?request=destinations&country=EE&type=APT";
            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getDocumentElement().getElementsByTagName("item");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Integer id = Integer.parseInt(element.getElementsByTagName("place_id").item(0).getTextContent());
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String address = element.getElementsByTagName("address").item(0).getTextContent();
                    String country = element.getElementsByTagName("country").item(0).getTextContent();
                    String availability = element.getElementsByTagName("availability").item(0).getTextContent();
                    SmartPostInfo posti = new SmartPostInfo(id, name, address, country, availability);
                    postList.add(posti);

                    setSmartList(postList);
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
    public void setSmartList(ArrayList<SmartPostInfo> smartList) {
        smartPostList = smartList;
    }
    public ArrayList<SmartPostInfo> getSmartList(){
        return smartPostList;
    }


}
