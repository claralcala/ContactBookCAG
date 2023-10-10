package es.iescarrillo.contactbookcag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ContactDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        //Recuperar intent
        Intent viewMainIntent = getIntent();

        //Recuperamos el nombre
        TextView tvName = (TextView) findViewById(R.id.tvName);
        tvName.setText(viewMainIntent.getStringExtra("name"));

        TextView tvSurname = (TextView) findViewById(R.id.tvSurname);
        tvSurname.setText(viewMainIntent.getStringExtra("surname"));

        TextView tvMail = (TextView) findViewById(R.id.tvEmail);
        tvMail.setText(viewMainIntent.getStringExtra("email"));

        TextView tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvPhone.setText(viewMainIntent.getStringExtra("phone"));


        Button btnEdit = findViewById(R.id.btnEdit);

        btnEdit.setOnClickListener(v -> {
            //Llamar a la First Activity
            Intent viewEditIntent = new Intent(this, EditContactActivity.class);


            viewEditIntent.putExtra("name", tvName.getText().toString());
            viewEditIntent.putExtra("surname", tvSurname.getText().toString());
            viewEditIntent.putExtra("email", tvMail.getText().toString());
            viewEditIntent.putExtra("phone", tvPhone.getText().toString());

            //Iniciar la siguiente activity
            startActivity(viewEditIntent);



        });


        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            //Llamar a la First Activity
            Intent viewFirstIntent = new Intent(this, MainActivity.class);
            //Iniciar la siguiente activity
            startActivity(viewFirstIntent);

        });


    }
}