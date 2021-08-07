package ua.lviv.lgs;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.FileAppender;


public class Logerfile {
    private static Logger LOG = Logger.getLogger(Logerfile.class);


    public static void main(String[] args) {

        DomConfigurator();

    }



    public static void DomConfigurator() {
        DOMConfigurator.configure("LogerConfig.xml");

        LOG.debug("DEBUG  mesaage of project");
        LOG.info("INFO  mesaage of project");
        LOG.warn("WARN  mesaage of project");
        LOG.error("ERROR  mesaage of project");

    }
}