package net.apispark.webapi;

import net.apispark.webapi.db.ContactPersistence;
import net.apispark.webapi.representation.Contact;
import org.restlet.Component;
import org.restlet.data.LocalReference;
import org.restlet.data.Protocol;
import org.restlet.engine.Engine;
import org.restlet.resource.Directory;
import org.slf4j.bridge.SLF4JBridgeHandler;

public class WebApiMain {

    public static void main(String[] args) throws Exception {
        configureLog();
        
        preloadData();

        // Attach application to http://localhost:8000/
        Component c = new Component();
        c.getServers().add(Protocol.HTTP, 8000);
        c.getClients().add(Protocol.CLAP);

        // attach REST API to /api
        c.getDefaultHost().attach("/api", new WebApiApplication());

        // other routes are redirected to static resources
        c.getDefaultHost().attachDefault(
                new Directory(c.getContext().createChildContext(), LocalReference.createClapReference("/static")));

        // start server
        c.start();
    }

    private static void configureLog() {
        //Configure logging
        Engine.configureLog();
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    private static void preloadData() {
        ContactPersistence.INSTANCE.addContact(new Contact("41ee2e80-75bf-11e5-b476-cbcba715b961", "John", "Smith", "svg-1"));
        ContactPersistence.INSTANCE.addContact(new Contact("41ee5590-75bf-11e5-b476-cbcba715b961", "Brenda", "Jones", "svg-6"));
    }
}