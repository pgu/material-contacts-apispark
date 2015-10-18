package net.apispark.webapi.resource;

import net.apispark.webapi.core.exception.BadEntityException;
import net.apispark.webapi.core.util.ResourceUtils;
import net.apispark.webapi.db.ContactPersistence;
import net.apispark.webapi.representation.Contact;
import net.apispark.webapi.representation.ContactList;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class ContactListServerResource extends ServerResource {

    /**
     * List contacts
     * @return (status 200) contacts
     */
    @Get
    public ContactList getContacts() {
        return new ContactList(ContactPersistence.INSTANCE.getContacts());
    }

    /**
     * Add a contact
     * @param contact The contact
     * @return (status 200) the added contact
     * @throws BadEntityException (status 422) when the new contact is not valid
     */
    @Post
    public Contact addContact(Contact contact) throws BadEntityException {
        ResourceUtils.notNull(contact);
        contact.validate();
        return ContactPersistence.INSTANCE.addContact(contact);
    }
}

