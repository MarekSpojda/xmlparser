package xmlparser;

import java.util.ArrayList;
import java.util.HashMap;

public class XMLNode {
    private String tagName;
    private ArrayList<XMLNode> xmlNodes = new ArrayList<>();
    private HashMap<String, String> xmlFields = new HashMap<>();

    public ArrayList<XMLNode> getXmlNodes() {
        return xmlNodes;
    }

    public void setXmlNodes(ArrayList<XMLNode> xmlNodes) {
        this.xmlNodes = xmlNodes;
    }

    public HashMap<String, String> getXmlFields() {
        return xmlFields;
    }

    public void setXmlFields(HashMap<String, String> xmlFields) {
        this.xmlFields = xmlFields;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}