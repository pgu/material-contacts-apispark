package net.apispark.webapi.resource;

import net.apispark.webapi.core.exception.BadEntityException;
import net.apispark.webapi.core.util.ResourceUtils;
import net.apispark.webapi.db.CompanyPersistence;
import net.apispark.webapi.representation.Company;
import net.apispark.webapi.representation.CompanyList;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class CompanyListServerResource extends ServerResource {

    /**
     * List companies
     * @return (status 200) companies
     */
    @Get
    public CompanyList getCompanies() {
        return new CompanyList(CompanyPersistence.INSTANCE.getCompanies());
    }

    /**
     * Add a company
     * @param company The company
     * @return (status 200) the added company
     * @throws BadEntityException (status 422) when the new company is not valid
     */
    @Post
    public Company addCompany(Company company) throws BadEntityException {
        ResourceUtils.notNull(company);
        company.validate();
        return CompanyPersistence.INSTANCE.addCompany(company);
    }
}

