package com.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.contacts.ui.ContactsFragment;
import com.contacts.ui.ContactsPresenter;
import com.contacts.utils.ActivityUtils;
import butterknife.ButterKnife;



public class MainActivity extends AppCompatActivity {
    private ContactsFragment contactsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        contactsFragment = (ContactsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_content);
        if (contactsFragment == null) {
            contactsFragment = ContactsFragment.getInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), contactsFragment, R.id.fragment_content);
        }
        new ContactsPresenter(contactsFragment);
    }
}
