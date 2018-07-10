package com.contacts.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.contacts.R;
import com.contacts.model.Contact;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactDetail extends AppCompatActivity {

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.parent)
    TextView parent;
    @BindView(R.id.managers)
    TextView managers;
    @BindView(R.id.phones)
    TextView phones;
    @BindView(R.id.address)
    TextView address;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Contact contact = (Contact) getIntent().getSerializableExtra("contact");
        initData(contact);
    }

    private void initData(Contact contact) {
        if (contact.getCompanyName() != null)
            name.setText(contact.getCompanyName());
        if (contact.getName() != null)
            name.setText(contact.getName());
        if (contact.getParent() != null)
            parent.setText(contact.getParent());
        if (contact.getManagers() != null)
            managers.setText(contact.getManagers().toString());
        if (contact.getAddresses() != null)
            address.setText(contact.getAddresses().toString());
        if (contact.getPhones() != null)
            phones.setText(contact.getPhones().toString());

    }
}
