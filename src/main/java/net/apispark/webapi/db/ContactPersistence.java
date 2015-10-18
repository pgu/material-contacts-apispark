/**
 * Copyright 2005-2015 Restlet
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: Apache 2.0 or or EPL 1.0 (the "Licenses"). You can
 * select the license that you prefer but you may not use this file except in
 * compliance with one of these Licenses.
 * 
 * You can obtain a copy of the Apache 2.0 license at
 * http://www.opensource.org/licenses/apache-2.0
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://restlet.com/products/restlet-framework
 * 
 * Restlet is a registered trademark of Restlet S.A.S.
 */

package net.apispark.webapi.db;

import net.apispark.webapi.core.exception.BadParameterException;
import net.apispark.webapi.core.exception.NotFoundException;
import net.apispark.webapi.representation.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Persistence layer for handling contacts.
 * 
 * @author Manuel Boillod
 */
public class ContactPersistence {

    public static ContactPersistence INSTANCE = new ContactPersistence();

    private Map<String, Contact> contacts = Collections
            .synchronizedMap(new LinkedHashMap<String, Contact>());

    public List<Contact> getContacts() {
        return new ArrayList<>(contacts.values());
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    /**
     * Adds a contact; it checks the company does not already exists.
     * 
     * @param contact
     *            The contact to add.
     * @return The added contact with its identifier.
     * @throws BadParameterException
     *             In case the contact already exists.
     */
    public Contact addContact(Contact contact) throws BadParameterException {
        if (contact.getId() == null) {
            contact.setId(UUID.randomUUID().toString());
        } else {
            Contact existing = getContact(contact.getId());
            if (existing != null) {
                throw new BadParameterException("Contact with id '"
                        + contact.getId() + "' already exists");
            }
        }
        contacts.put(contact.getId(), contact);
        return contact;
    }

    /**
     * Updates the given contact; it checks that the contact already exists.
     * 
     * @param contactId
     *            The identifier of the contact to update.
     * @param contact
     *            The new contact.
     * @return The updated contact.
     * @throws NotFoundException
     *             In case the contact does not exist.
     */
    public Contact updateContact(String contactId, Contact contact)
            throws NotFoundException {
        Contact existing = getContact(contactId);
        if (existing == null) {
            throw new NotFoundException("No contact with id '" + contactId
                    + "'");
        }
        contacts.put(contactId, contact);
        return contact;
    }


    /**
     * Removes a contact, and indicates if the contact has really been removed.
     * 
     * @param contactId
     * @return True if the contact has been removed.
     */
    public boolean deleteContact(String contactId) {
        Contact existing = contacts.remove(contactId);
        return existing != null;
    }
}
