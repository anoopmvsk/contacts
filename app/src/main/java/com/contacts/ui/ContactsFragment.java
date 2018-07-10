package com.contacts.ui;


import android.content.Context;

import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.contacts.R;
import com.contacts.adapter.ContactsAdapter;
import com.contacts.model.Contact;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anoop on 6/8/18.
 */

public class ContactsFragment extends Fragment implements ContactsContract.View {
    private ContactsContract.Presenter presenter;
    private Context context;
    private ContactsAdapter contactsAdapter;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.contactsList)
    ListView contactList;
    @BindView(R.id.search)
    SearchView searchView;


    public static ContactsFragment getInstance() {
        ContactsFragment iisPassFragment = new ContactsFragment();
        return iisPassFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onSearchListener();
        onContactClick();
        presenter.loadContacts(context);
    }

    @Override
    public void setPresenter(ContactsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoadingIndicator(boolean isActive) {
        if (isActive)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String error) {
        Snackbar.make(getView(), error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        context = null;
    }

    @Override
    public void showContacts(ArrayList<Contact> contacts) {
        contactsAdapter = new ContactsAdapter(contacts);
        contactList.setAdapter(contactsAdapter);
    }

    private void onSearchListener() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterContacts(s);
                return false;
            }
        });
    }

    private void filterContacts(String search) {
        contactsAdapter.setContacts(presenter.getFilteredContacts(search));
        contactsAdapter.notifyDataSetChanged();
    }

    private void onContactClick() {
        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact contact = (Contact) contactsAdapter.getItem(i);
                Intent intent = new Intent(context, ContactDetail.class);
                intent.putExtra("contact", contact);
                startActivity(intent);
            }
        });
    }
}
