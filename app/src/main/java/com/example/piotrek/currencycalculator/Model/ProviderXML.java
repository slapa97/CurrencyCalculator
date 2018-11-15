package com.example.piotrek.currencycalculator.Model;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;

import com.example.piotrek.currencycalculator.Model.Currency;
import com.example.piotrek.currencycalculator.Model.Provider;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Piotrek on 10/16/2018.
 */

public class ProviderXML extends AsyncTask<Void,Void,List<Currency>> implements Provider {

    List<Currency> lista = new ArrayList<Currency>();

    @Override
    public List<Currency> get_data() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        InputStream is = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            is = new URL("https://www.nbp.pl/kursy/xml/LastA.xml").openStream();
            //  doc = dBuilder.parse(new URL("https://www.nbp.pl/kursy/xml/LastA.xml").openStream());
            doc = dBuilder.parse(new InputSource(is));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("pozycja");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                lista.add(new Currency(eElement.getElementsByTagName("nazwa_waluty").item(0).getTextContent(),
                        Integer.parseInt(eElement.getElementsByTagName("przelicznik").item(0).getTextContent()),
                        eElement.getElementsByTagName("kod_waluty").item(0).getTextContent(),
                        Double.parseDouble(eElement.getElementsByTagName("kurs_sredni").item(0).getTextContent().replaceAll(",", "."))));
            }
        }
        return lista;
    }
    @Override
    protected List<Currency> doInBackground(Void... voids) {
        //get_data();
       // publishProgress(get_data());
        return get_data();
    }

    @Override
    protected void onPostExecute(List<Currency> currencies) {
        super.onPostExecute(currencies);

    }
}