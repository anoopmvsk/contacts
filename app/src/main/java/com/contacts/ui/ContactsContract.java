package com.contacts.ui;


import android.content.Context;

import com.contacts.BaseView;
import com.contacts.model.Contact;

import java.util.ArrayList;

/**
 * Created by anoop on 6/8/18.
 */

public interface ContactsContract {
    interface View extends BaseView<Presenter> {
        void showContacts(ArrayList<Contact> iisPassList);
    }

    interface Presenter {
        void loadContacts(Context context);
        ArrayList<Contact> getFilteredContacts(String search);
    }
}
