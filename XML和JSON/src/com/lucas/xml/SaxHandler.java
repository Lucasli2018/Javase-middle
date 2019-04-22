package com.lucas.xml;

import java.nio.charset.StandardCharsets;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler{

	void print(Object...objects){
		for (Object object : objects) {
			System.out.print(object);
			System.out.print(" ");
		}
	}
	@Override
	public void startDocument() throws SAXException {
		System.out.println("startDocument");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("endDocument");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("startElement "+localName+" "+qName);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("endElement "+localName+" "+qName);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("characters "+new String(ch,start,length));
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		print("error:",e);
	}
	
}
