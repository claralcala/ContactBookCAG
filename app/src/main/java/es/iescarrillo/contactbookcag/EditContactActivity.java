package es.iescarrillo.contactbookcag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.SortedSet;

import es.iescarrillo.contactbookcag.data.Database;
import es.iescarrillo.contactbookcag.models.Contact;

public class EditContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        SortedSet<Contact> contacts = Database.contactList;

        //Recuperar intent
        Intent intentEdit = getIntent();

        //Recuperamos el nombre, apellidos, email y teléfono

        EditText etName = findViewById(R.id.etNameC);
        etName.setText(intentEdit.getStringExtra("name"));

        EditText etSurname = findViewById(R.id.etSurnameC);
        etSurname.setText(intentEdit.getStringExtra("surname"));

        EditText etMail = findViewById(R.id.etMailC);
        etMail.setText(intentEdit.getStringExtra("email"));

        EditText etPhone = findViewById(R.id.etPhoneC);
        etPhone.setText(intentEdit.getStringExtra("phone"));


        //Si pulsamos el botón de guardar
        Button btnSave = findViewById(R.id.btnSaveC);
        btnSave.setOnClickListener(v -> {
            //Almacenamos los cambios que haya podido hacer el usuario en nuevas variables
            //Estas variables empiezan por up de update
            String upName = etName.getText().toString();
            String upSurname = etSurname.getText().toString();
            String upEmail = etMail.getText().toString();
            String upPhone = etPhone.getText().toString();

            //Ahora buscamos en la lista un contacto que coincida sus datos (todos, para no equivocarnos) con los del intent
            //OJO: hay que comparar con los datos almacenados en el intent, NO EN LOS CAMPOS DE TEXTO, porque el usuario puede haber modificado
            for (Contact con: contacts){
                if(con.getName().equals(intentEdit.getStringExtra("name")) && con.getSurname().equals(intentEdit.getStringExtra("surname")) && con.getEmail().equals(intentEdit.getStringExtra("email")) && con.getTelephone().equals(intentEdit.getStringExtra("phone"))){
                   //Si lo encontramos, machacamos los datos con los set correspondientes
                    con.setName(upName);
                    con.setSurname(upSurname);
                    con.setEmail(upEmail);
                    con.setTelephone(upPhone);
                    break;
                }
            }

            
            //Llamar a la First Activity
            Intent viewFirstIntent = new Intent(this, MainActivity.class);
            //Iniciar la siguiente activity
            startActivity(viewFirstIntent);

        });

        //Botón  para volver
        Button btnBack = findViewById(R.id.btnBackM);
        btnBack.setOnClickListener(v -> {
            //Llamar a la First Activity
            Intent viewFirstIntent = new Intent(this, MainActivity.class);
            //Iniciar la siguiente activity
            startActivity(viewFirstIntent);

        });
    }
}