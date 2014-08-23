package com.android.trobb.addressbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.trobb.addressbook.domain.Contact;

import java.util.List;

/**
 * Created by trobb on 2014/08/20.
 */
public class ContactAdapter extends ArrayAdapter<Contact> {

    List<Contact> myContacts;

    public ContactAdapter(Context context, List<Contact> cons) {
        super(context, R.layout.row_detail, cons);
        myContacts = cons;
    }

    public Contact getItem(int position) {

        return myContacts.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;

        Contact cons = (Contact)getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_detail, parent, false);
        }

        TextView lastName = (TextView) convertView.findViewById(R.id.text_last);
        TextView cell = (TextView) convertView.findViewById(R.id.text_cell);

        lastName.setText(cons.getLastName().toUpperCase());
        cell.setText(cons.getCellNumber());

        return convertView;
    }

    private static class ViewHolder {
        public TextView lastTextView;
        public TextView cellTextView;
    }

}
