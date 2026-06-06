package lesson23;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * SAX парсер сонеты.
 *
 * @author Ирина Мизгир
 * @date 24.05.2026 18:42
 */
public class SAXSonnetParser implements SonnetParser {

    @Override
    public SonnetData parse(File file) throws IOException {

        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            var handler = new SonnetXMLHandler();

            // Запуск процесса
            saxParser.parse(file, handler);

            return handler.sonnetData;
        } catch (ParserConfigurationException | SAXException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * SAX обработчик сонеты.
     */
    private static class SonnetXMLHandler extends DefaultHandler {

        /**
         * Данные сонеты.
         */
        private final SonnetData sonnetData = new SonnetData();

        /**
         * Текущий обрабатываемый элемент.
         */
        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            currentElement = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String text = new String(ch, start, length).trim();
            if (!text.isEmpty()) {
                if ("firstName".equals(currentElement)) {
                    sonnetData.setFirstName(text);
                } else if ("lastName".equals(currentElement)) {
                    sonnetData.setLastName(text);
                } else if ("title".equals(currentElement)) {
                    sonnetData.setTitle(text);
                } else if ("line".equals(currentElement)) {
                    sonnetData.addLine(text);
                }
            }
        }

    }
}
