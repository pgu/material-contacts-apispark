package net.apispark.webapi.resource;

import net.apispark.webapi.core.exception.BadEntityException;
import net.apispark.webapi.core.exception.NotFoundException;
import net.apispark.webapi.core.util.ResourceUtils;
import net.apispark.webapi.db.CompanyPersistence;
import net.apispark.webapi.representation.Company;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class CompanyServerResource extends ServerResource {


    private String companyId;

    @Override
    protected void doInit() throws ResourceException {
        companyId = ResourceUtils.getPathVariable(this, "companyId");
    }

    /**
     * Return a company
     * @return (status 200) the company
     * @throws NotFoundException (status 404) when the company is not found
     */
    @Get
    public Company getCompany() throws NotFoundException {
        Company company = CompanyPersistence.INSTANCE.getCompany(companyId);
        if (company == null) {
            throw new NotFoundException("No company with id '" + companyId + "'");
        }
        return company;
    }

    /**
     * Update a company
     * @param company The company
     * @return (status 200) the updated company
     * @throws NotFoundException (status 404) when the company is not found
     * @throws BadEntityException (status 422) when the new company is not valid
     */
    @Put
    public Company updateCompany(Company company) throws NotFoundException, BadEntityException {
        ResourceUtils.notNull(company);
        company.validate();
        return CompanyPersistence.INSTANCE.updateCompany(companyId, company);
    }

    /**
     * Detete a company
     * Returns nothing (status 204)
     * @throws NotFoundException (status 404) when the company is not found
     */
    @Delete
    public void deleteCompany() throws NotFoundException {
        boolean removed = CompanyPersistence.INSTANCE.deleteCompany(companyId);
        if (!removed) {
            throw new NotFoundException("No company with id '" + companyId + "'");
        }
    }

}

