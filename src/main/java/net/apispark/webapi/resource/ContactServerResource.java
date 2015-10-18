package net.apispark.webapi.resource;

import net.apispark.webapi.core.exception.BadEntityException;
import net.apispark.webapi.core.exception.NotFoundException;
import net.apispark.webapi.core.util.ResourceUtils;
import net.apispark.webapi.db.ContactPersistence;
import net.apispark.webapi.representation.Contact;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class ContactServerResource extends ServerResource {


    private String contactId;

    @Override
    protected void doInit() throws ResourceException {
        contactId = ResourceUtils.getPathVariable(this, "contactId");
    }

    /**
     * Return a contact
     * @return (status 200) the contact
     * @throws NotFoundException (status 404) when the contact is not found
     */
    @Get
    public Contact getContact() throws NotFoundException {
        Contact contact = ContactPersistence.INSTANCE.getContact(contactId);
        if (contact == null) {
            throw new NotFoundException("No contact with id '" + contactId + "'");
        }
        return contact;
    }

    /**
     * Update a contact
     * @param contact The contact
     * @return (status 200) the updated contact
     * @throws NotFoundException (status 404) when the contact is not found
     * @throws BadEntityException (status 422) when the new contact is not valid
     */
    @Put
    public Contact updateContact(Contact contact) throws NotFoundException, BadEntityException {
        ResourceUtils.notNull(contact);
        contact.validate();
        return ContactPersistence.INSTANCE.updateContact(contactId, contact);
    }

    /**
     * Detete a contact
     * Returns nothing (status 204)
     * @throws NotFoundException (status 404) when the contact is not found
     */
    @Delete
    public void deleteContact() throws NotFoundException {
        boolean removed = ContactPersistence.INSTANCE.deleteContact(contactId);
        if (!removed) {
            throw new NotFoundException("No contact with id '" + contactId + "'");
        }
    }

}

