///**
// *
// */
//package org.lua.util;
//
//import java.beans.IntrospectionException;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.LinkedList;
//
//import org.apache.commons.betwixt.io.BeanReader;
//import org.xml.sax.SAXException;
//
//
///**
// * @author onkyo
// *
// */
//public class XMLUtil2 {
//
//	public static Object readBeansFromXMLFile(Class clazzs,
//			String filePath) throws IntrospectionException, IOException,
//			SAXException {
//
//		Object ret = null;
//		FileInputStream in = null;
//		try {
//			in = new FileInputStream(filePath);
//			ret = readBeansFromInputStream(clazzs, in);
//		} finally {
//			if (in != null) {
//				in.close();
//			}
//		}
//
//		return ret;
//	}
//
//	public static Object readBeansFromInputStream(Class clazzs, InputStream in) throws IntrospectionException, IOException,
//			SAXException {
//
//
//		// Now convert this to a bean using betwixt
//		// Create BeanReader
//		BeanReader beanReader = new BeanReader();
//
//		// Configure the reader
//		// If you're round-tripping, make sure that the configurations are
//		// compatible!
//		beanReader.getXMLIntrospector().getConfiguration()
//				.setAttributesForPrimitives(false);
//		beanReader.getBindingConfiguration().setMapIDs(false);
//
//		// Register beans so that betwixt knows what the xml is to be converted
//		// to
//		// Since the element mapped to a PersonBean isn't called the same
//		// as Betwixt would have guessed, need to register the path as well
//		beanReader.registerBeanClass("ArrayList", ArrayList.class);
//		beanReader.registerBeanClass("LinkedList", LinkedList.class);
//		beanReader.registerBeanClass(clazzs);
//
//		// Now we parse the xml
//		return beanReader.parse(in);
//	}
//
//}
