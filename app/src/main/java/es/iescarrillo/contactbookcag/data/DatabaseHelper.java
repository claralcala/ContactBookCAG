package es.iescarrillo.contactbookcag.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import es.iescarrillo.contactbookcag.models.Contact;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CONTACTAPP";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_CONTACT_TABLE = "CREATE TABLE Contact (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, surname TEXT, email TEXT, telephone TEXT)";

    private static final String DROP_CONTACT_TABLE = "DROP TABLE IF EXISTS Contact";


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Cursor cursor = db.rawQuery("SELECT _id, name, surname, email, telephone FROM Contact", null);

        SortedSet<Contact> contacts = new TreeSet<Contact>();

        if (cursor !=null && cursor.moveToFirst()){
            do{
                Contact c = new Contact();
                c.setId(cursor.getColumnIndex("_id"));
                c.setName(String.valueOf(cursor.getColumnIndex("name")));
                c.setSurname(String.valueOf(cursor.getColumnIndex("surname")));
                c.setEmail(String.valueOf(cursor.getColumnIndex("email")));
                c.setTelephone(String.valueOf(cursor.getColumnIndex("telephone")));
                contacts.add(c);
            }while (cursor.moveToNext());
        }

        db.execSQL(DROP_CONTACT_TABLE);
        onCreate(db);


    }
}
