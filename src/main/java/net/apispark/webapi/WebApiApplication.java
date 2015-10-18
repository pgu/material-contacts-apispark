package net.apispark.webapi;

import net.apispark.webapi.resource.CompanyListServerResource;
import net.apispark.webapi.resource.CompanyServerResource;
import net.apispark.webapi.resource.ContactListServerResource;
import net.apispark.webapi.resource.ContactServerResource;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import org.restlet.service.CorsService;

public class WebApiApplication extends Application {

    public WebApiApplication() {
        // Add CORS support
        CorsService corsService = new CorsService();
        corsService.setAllowedCredentials(true);
        corsService.setSkippingResourceForCorsOptions(true);
        getServices().add(corsService);
    }
    
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/companies", CompanyListServerResource.class);
        router.attach("/companies/{companyId}", CompanyServerResource.class);
        router.attach("/contacts", ContactListServerResource.class);
        router.attach("/contacts/{contactId}", ContactServerResource.class);
        return router;
    }

}
