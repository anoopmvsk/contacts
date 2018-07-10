package com.contacts.api;

import com.contacts.model.Contact;

import java.util.ArrayList;

/**
 * Created by anoop on 6/8/18.
 */

public interface ResponseListener {
    public void onResponseSuccess(ArrayList<Contact> response);

    public void onResponseError(String error);
}
