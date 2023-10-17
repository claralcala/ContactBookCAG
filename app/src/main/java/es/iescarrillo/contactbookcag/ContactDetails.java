package es.iescarrillo.contactbookcag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.SortedSet;

import es.iescarrillo.contactbookcag.datasources.ContactDataSource;
import es.iescarrillo.contactbookcag.models.Contact;

public class ContactDetails extends AppCompatActivity {
    private ContactDataSource contactDataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);



        contactDataSource = new ContactDataSource(this);


        //Recuperar intent con los datos que nos traemos de la página principal
        Intent viewMainIntent = getIntent();

        //Recuperamos el nombre, apellido, email y telf
        TextView tvName = (TextView) findViewById(R.id.tvName);
        tvName.setText(viewMainIntent.getStringExtra("name"));

        TextView tvSurname = (TextView) findViewById(R.id.tvSurname);
        tvSurname.setText(viewMainIntent.getStringExtra("surname"));

        TextView tvMail = (TextView) findViewById(R.id.tvEmail);
        tvMail.setText(viewMainIntent.getStringExtra("email"));

        TextView tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvPhone.setText(viewMainIntent.getStringExtra("phone"));


        Button btnEdit = findViewById(R.id.btnEdit);

        //Cuando pulsamos el botón editar, nos llevamos toda la info a la siguiente pantalla
        btnEdit.setOnClickListener(v -> {
            //Llamar a la First Activity
            Intent viewEditIntent = new Intent(this, EditContactActivity.class);

            viewEditIntent.putExtra("id", viewMainIntent.getIntExtra("id", 0));
            viewEditIntent.putExtra("name", tvName.getText().toString());
            viewEditIntent.putExtra("surname", tvSurname.getText().toString());
            viewEditIntent.putExtra("email", tvMail.getText().toString());
            viewEditIntent.putExtra("phone", tvPhone.getText().toString());

            //Iniciar la siguiente activity
            startActivity(viewEditIntent);



        });

        //Para el botón eliminar, buscamos en la lista un contacto que coincida con los datos que tenemos
        //Si encontramos ese contacto, lo borramos
        Button btnDelete = findViewById(R.id.btnDelete);


        btnDelete.setOnClickListener(v -> {

            contactDataSource.deleteContact(viewMainIntent.getIntExtra("id", 0));
            //Luego volvemos a la vista principal
            Intent viewFirstIntent = new Intent(this, MainActivity.class);
            //Iniciar la siguiente activity
            startActivity(viewFirstIntent);



        });


        //Si pulsamos el botón de vuelta, volvemos a la vista principal
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            //Llamar a la First Activity
            Intent viewFirstIntent = new Intent(this, MainActivity.class);
            //Iniciar la siguiente activity
            startActivity(viewFirstIntent);

        });


    }
}