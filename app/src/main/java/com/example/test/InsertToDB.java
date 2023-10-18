package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.Database.DatabaseAux;

public class InsertToDB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_to_db);
    }

    public void changeToMain(View view) {
        Intent nIntent = new Intent(InsertToDB.this, MainActivity.class);
        startActivity(nIntent);
    }

    public void insertValues(View v) {
        /*Asignar variable*/
        TextView nameTextView = findViewById(R.id.insertName);
        TextView emailTextView = findViewById(R.id.insertEmail);
        /*guardar los datos en las variables*/
        String nameString = nameTextView.getText().toString();
        String emailString = emailTextView.getText().toString();

        DatabaseAux aux = new DatabaseAux(InsertToDB.this);
        SQLiteDatabase db = aux.getWritableDatabase();
    /*comprobar si seha podido acceder a la base de datos y si los campos estan vacios*/
        if(db != null && !nameString.isEmpty() && !emailString.isEmpty()) {
            /*campo que nos ayuda insertar datos como crear una tabla */
            ContentValues values = new ContentValues();
            /*pones tabla nombre y email*/
            values.put("name", nameString);
            values.put("email", emailString);

            long res = db.insert("users", null, values);
            if(res >= 0) {
                Toast.makeText(this, "Insertado correctamente", Toast.LENGTH_LONG).show();
                nameTextView.setText("");
                emailTextView.setText("");
            }
            else {
                Toast.makeText(this, "Fallo al insertar", Toast.LENGTH_LONG).show();
            }
            db.close();
        }

    }

}