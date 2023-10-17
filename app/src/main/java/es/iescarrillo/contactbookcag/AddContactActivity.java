package es.iescarrillo.contactbookcag;




import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import es.iescarrillo.contactbookcag.datasources.ContactDataSource;

/**
 * Clase para añadir contactos
 */
public class AddContactActivity extends AppCompatActivity {
    private ContactDataSource contactDataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);


        contactDataSource = new ContactDataSource(this);
        //Inicializamos los componentes que usaremos
        EditText etName = findViewById(R.id.etName);
        EditText etSurname = findViewById(R.id.etSurname);
        EditText etMail = findViewById(R.id.etMail);
        EditText etPhone = findViewById(R.id.etPhone);
        Button btnSave = findViewById(R.id.btnSave);

        //Si pulsamos Guardar, creamos un contacto y lo añadimos
        //Asimismo, al acabar volvemos a la actividad principal para no quedarnos ahí
        btnSave.setOnClickListener(v -> {
            //Cuidado con esto: sumamos +1 al número más grande que nos devuelva el método getID para tener el siguiente

            contactDataSource.insertContact(etName.getText().toString(), etSurname.getText().toString(), etMail.getText().toString(),etPhone.getText().toString());


            Intent viewMainAc= new Intent(this, MainActivity.class);
            //Iniciar la siguiente activity
            startActivity(viewMainAc);

        });

        //Volver a la página principal
        Button btnHome = findViewById(R.id.btnBackMain);
        btnHome.setOnClickListener(v -> {
            //Llamar a la First Activity
            Intent viewFirstIntent = new Intent(this, MainActivity.class);
            //Iniciar la siguiente activity
            startActivity(viewFirstIntent);

        });
    }


}