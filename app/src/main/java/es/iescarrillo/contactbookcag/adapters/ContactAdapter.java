package es.iescarrillo.contactbookcag.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.SortedSet;

import es.iescarrillo.contactbookcag.R;
import es.iescarrillo.contactbookcag.models.Contact;

public class ContactAdapter extends ArrayAdapter<Contact> {

    public ContactAdapter (Context context, SortedSet<Contact> contactList){
        super(context, 0, contactList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Contact contact = getItem(position);

        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);

        }

        TextView tvNameL = convertView.findViewById(R.id.tvNameList);

        tvNameL.setText(contact.getName());

        return convertView;

    }


}
