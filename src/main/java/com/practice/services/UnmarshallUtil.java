/*
package com.practice.services;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * Created by janardhan.nellibanda on 9/21/2016.
 *//*

public class UnmarshallUtil {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    private static Map<String, JAXBContext> mapOfNewContext = new HashMap<String, JAXBContext>();

    public static <T> T unmarshall(final Class clazz, final String input, final String contentType) throws Exception { //NOPMD

        if (contentType.contains(MediaType.APPLICATION_XML)) {

            return UnmarshallUtil.<T>unmarshallXMLNew(clazz, input);
        }
        else if (contentType.contains(MediaType.APPLICATION_JSON)) {

            return UnmarshallUtil.<T>unmarshallJSON(clazz, input);
        }
        else {

            return null;
        }
    }

    public static <T> T unmarshallXML(final Class clazz, final String xml) throws Exception { //NOPMD

        final JAXBContext context = JAXBContext.newInstance(clazz);
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final T bo = (T) unmarshaller.unmarshal(new StringReader(xml));

        return bo;
    }

    private static <T> T unmarshallXMLNew(final Class clazz, final String xml) throws PayloadException, Exception {

        T bo;

        try {
            JAXBContext context;
            if(!mapOfNewContext.containsKey(clazz.getName())) {
                context = JAXBContext.newInstance(clazz);
                mapOfNewContext.put(clazz.getName(), context);
            } else {
                context = mapOfNewContext.get(clazz.getName());
            }

            final Unmarshaller unmarshaller = context.createUnmarshaller();
            bo = (T) unmarshaller.unmarshal(new StringReader(xml));
        }
        catch (Exception exception) {

            throw new Exception(exception.getMessage()); //NOPMD
        }

        return bo;
    }

    private static <T> T unmarshallJSON(final Class clazz, final String json) throws Exception {

        T bo = null;

        try{

            bo = (T) JSON_MAPPER.readValue(json, clazz);
        }
        */
/*catch (UnrecognizedPropertyException exception) {

            throw new InvalidJSONFieldException(null, exception.getUnrecognizedPropertyName()); //NOPMD
        }*//*

        catch (Exception exception) {

            throw new Exception(exception.getMessage()); //NOPMD
        }

        return bo;
    }
}
*/
