package xmlparser;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLParser {
    public static ArrayList<XMLNode> parseXMLToArrayList(File xmlSourceFile)
            throws ParserConfigurationException, IOException, SAXException {
        Document xmlParsedToDocument = getXmlParsedToDocument(xmlSourceFile);
        NodeList nodeList = xmlParsedToDocument.getChildNodes();
        return new ArrayList<>(getXMLNodesFromNodeList(nodeList));
    }

    private static ArrayList<XMLNode> getXMLNodesFromNodeList(NodeList nodeList) {
        ArrayList<XMLNode> xmlNodes = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                XMLNode xmlNode = new XMLNode();
                xmlNodes.add(xmlNode);
                Element element = (Element) node;
                xmlNode.setTagName(element.getTagName());
                NamedNodeMap attributes = element.getAttributes();
                for (int j = 0; j < attributes.getLength(); j++) {
                    Node attributeNode = attributes.item(j);
                    xmlNode.getXmlFields().put(attributeNode.getNodeName(),
                            attributeNode.getNodeValue());
                }
                NodeList children = element.getChildNodes();
                xmlNode.setXmlNodes(getXMLNodesFromNodeList(children));
            }
        }
        return xmlNodes;
    }

    private static Document getXmlParsedToDocument(File xmlSourceFile)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        return documentBuilder.parse(xmlSourceFile);
    }
}