package net.apispark.webapi.representation;

import java.util.ArrayList;
import java.util.List;

public class CompanyList {

    private List<Company> items = new ArrayList<>();

    public CompanyList() {
    }

    public CompanyList(List<Company> items){
        this.items = items;
    }

    public List<Company> getItems() {
        return items;
    }

    public void setItems(List<Company> items) {
        this.items = items;
    }

    public int getCount() {
        return items.size();
    }
}

