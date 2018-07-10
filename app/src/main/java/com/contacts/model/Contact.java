package com.contacts.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Contact implements Serializable {
    private String companyName;
    private String name;
    private String parent;
    private ArrayList<String> managers;
    private ArrayList<String> phones;
    private ArrayList<String> addresses;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public ArrayList<String> getManagers() {
        return managers;
    }

    public void setManagers(ArrayList<String> managers) {
        this.managers = managers;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<String> phones) {
        this.phones = phones;
    }

    public ArrayList<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<String> addresses) {
        this.addresses = addresses;
    }
}
