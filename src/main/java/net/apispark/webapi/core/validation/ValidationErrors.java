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

package net.apispark.webapi.core.validation;

import net.apispark.webapi.core.exception.BadEntityException;

import java.util.ArrayList;
import java.util.List;

/**
 * Lists of global and fields errors.
 * 
 * @author Manuel Boillod
 */
public class ValidationErrors {

    private List<String> globalMessages = new ArrayList<>();

    private List<FieldError> fieldErrors = new ArrayList<>();

    public List<String> getGlobalMessages() {
        return globalMessages;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void addGlobalMessage(String globalMessage) {
        globalMessages.add(globalMessage);
    }

    public void addFieldError(String field, String message) {
        addFieldError(new FieldError(field, message));
    }

    public void addFieldError(FieldError fieldError) {
        fieldErrors.add(fieldError);
    }

    public void checkErrors(String message) {
        if (!globalMessages.isEmpty() || !fieldErrors.isEmpty()) {
            throw new BadEntityException(message, this);
        }
    }
}
