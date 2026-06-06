package lesson23;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * DOM парсер сонеты.
 *
 * @author Ирина Мизгир
 * @date 24.05.2026 18:42
 */
public class DOMSonnetParser implements SonnetParser {

    @Override
    public SonnetData parse(File file) throws IOException {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            NodeList nodeList = document.getElementsByTagName("line");
            SonnetData sonnetData = new SonnetData();
            for (int i = 0; i < nodeList.getLength(); i++) {
                sonnetData.addLine(nodeList.item(i).getTextContent());
            }
            sonnetData.setFirstName(document.getElementsByTagName("firstName").item(0).getTextContent());
            sonnetData.setLastName(document.getElementsByTagName("lastName").item(0).getTextContent());
            sonnetData.setTitle(document.getElementsByTagName("title").item(0).getTextContent());

            return  sonnetData;
        } catch (ParserConfigurationException | SAXException exception) {
            throw new RuntimeException(exception);
        }
    }
}
