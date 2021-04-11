package io;

import model.FullInfo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriter {

    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());

    private XmlWriter() {
    }

    public void generateXmlReq(FullInfo fullInfo) {

        try {
            logger.log(Level.INFO, "XML marshalling started");

            JAXBContext jaxbContext = JAXBContext.newInstance(FullInfo.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File requestFile = new File("infoReq" + new Date().getTime());

            marshaller.marshal(fullInfo, requestFile);
        } catch (JAXBException e) {
            logger.log(Level.SEVERE, "XML marshalling failed", e);
        }

        logger.log(Level.INFO, "XML marshalling finished successfully");
    }
}
