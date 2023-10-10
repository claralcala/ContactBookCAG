package es.iescarrillo.contactbookcag.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.SortedSet;
import java.util.stream.Collectors;

import es.iescarrillo.contactbookcag.R;
import es.iescarrillo.contactbookcag.models.Contact;

/**
 * Clase ContactAdapter que usaremos para volcar el contenido de la lista a la ListView
 */
public class ContactAdapter extends ArrayAdapter<Contact> {

    public ContactAdapter (Context context, SortedSet<Contact> contactList){
        //Como nosotros usamos SortedSet, casteamos para no tener problemas
        super(context, 0, contactList.stream().collect(Collectors.toList()));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Contact contact = getItem(position);

        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);

        }

        TextView tvNameL = convertView.findViewById(R.id.tvNameList);

        //En nuestro caso en la pantalla de inicio mostraremos el nombre y el apellido
        tvNameL.setText(contact.getName() +" " + contact.getSurname());

        return convertView;

    }


}
