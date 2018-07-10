package com.contacts.ui;

import android.content.Context;

import com.contacts.api.ApiService;
import com.contacts.api.ResponseListener;
import com.contacts.model.Contact;


import java.util.ArrayList;

/**
 * Created by anoop on 6/8/18.
 */

public class ContactsPresenter implements ContactsContract.Presenter {
    private ContactsContract.View view;
    private ArrayList<Contact> contacts;

    public ContactsPresenter(ContactsContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    /**
     * Make an API call to fetch Contacts
     */
    @Override
    public void loadContacts(Context context) {
        view.showLoadingIndicator(true);
        ApiService.onGetContacts(context, new ResponseListener() {
            @Override
            public void onResponseSuccess(ArrayList<Contact> response) {
                setContacts(response);
                view.showContacts(response);
                view.showLoadingIndicator(false);
            }

            @Override
            public void onResponseError(String error) {
                view.showError(error);
                view.showLoadingIndicator(false);
            }
        });
    }

    private void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public ArrayList<Contact> getFilteredContacts(String search) {
        ArrayList<Contact> fContacts = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++) {
            if ((contacts.get(i).getName() != null && contacts.get(i).getName().toLowerCase().contains(search.toLowerCase())) ||
                    (contacts.get(i).getCompanyName() != null && contacts.get(i).getCompanyName().toLowerCase().contains(search.toLowerCase())))
                fContacts.add(contacts.get(i));
        }
        return fContacts;
    }

}
