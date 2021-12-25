import org.xml.sax.SAXException;
import xmlparser.XMLNode;
import xmlparser.XMLParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class XMLStart {
    public static void main(String[] args)
            throws ParserConfigurationException, IOException, SAXException {
        File inputXML =
                new File(Paths.get("").toAbsolutePath() + File.separator + "input.xml");
        ArrayList<XMLNode> parsedXML = XMLParser.parseXMLToArrayList(inputXML);
        System.out.println(
                "Root node has " + parsedXML.get(0).getXmlNodes().size() + " element(s).");
    }
}