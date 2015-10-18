package net.apispark.webapi.representation;

import java.util.ArrayList;
import java.util.List;

public class ContactList {

    private List<Contact> items = new ArrayList<>();

    public ContactList() {
    }

    public ContactList(List<Contact> items){
        this.items = items;
    }

    public List<Contact> getItems() {
        return items;
    }

    public void setItems(List<Contact> items) {
        this.items = items;
    }

    public int getCount() {
        return items.size();
    }
}
