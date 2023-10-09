package adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.SortedSet;

import models.Contact;

public class ContactAdapter extends ArrayAdapter<Contact> {

    public ContactAdapter (Context context, SortedSet<Contact> contacts){
            super(context, 0, (List<Contact>) contacts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        
    }


}
