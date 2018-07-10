package com.contacts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.contacts.R;
import com.contacts.model.Contact;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anoop on 6/8/18.
 * <p>
 * Adapter Class to present data on listview
 */

public class ContactsAdapter extends BaseAdapter {

    private ArrayList<Contact> contacts;


    public ContactsAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public class ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.parent)
        TextView parent;

        public ViewHolder(View v) {
            ButterKnife.bind(this, v);
        }
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        Contact contact = contacts.get(position);
        String name;
        if (contact.getCompanyName() != null)
            name = contact.getCompanyName();
        else
            name = contact.getName();
        holder.name.setText(name);
        holder.parent.setText(contact.getParent());
        return convertView;
    }
}
