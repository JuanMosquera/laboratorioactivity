package gr3.compumovil.udea.edu.co.lab2activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro_Activity extends AppCompatActivity {

    private EditText txtUser;
    private EditText txtPassword;
    private EditText txtEmail;
    private EditText txtAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_);

        txtUser = (EditText) findViewById(R.id.edituser);
        txtPassword = (EditText) findViewById(R.id.editpassword);
        txtEmail = (EditText) findViewById(R.id.editemail);
        txtAge = (EditText) findViewById(R.id.editage);


    }

    public void insertarBD(View view){

        DbHelper dbHelper = new DbHelper(this); //Instancia de DbHelper
        SQLiteDatabase db = dbHelper.getWritableDatabase(); //Obtener instancia de la BD


        ContentValues values = new ContentValues();
        values.put(TablaUsuario.USER, txtUser.getText().toString()); //Se pasan pares nombre-valor
        values.put(TablaUsuario.PASSWORD,txtPassword.getText().toString());
        values.put(TablaUsuario.EMAIL,txtEmail.getText().toString());
        values.put(TablaUsuario.AGE, txtAge.getText().toString());

        db.insertWithOnConflict(StatusContract.TABLE_USER, null, values,
                SQLiteDatabase.CONFLICT_IGNORE); //Se guarda la fila en la base de datos*/
        Toast.makeText(getApplicationContext(),"EL USUARIO HA SIDO REGISTRADO",Toast.LENGTH_SHORT).show();
        db.close();

        this.finish();

        /*FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment inicio = new InicioSesion();
        fragmentTransaction.replace(R.id.drawer_layout,inicio);

        fragmentTransaction.commit(); */

    }

    public void Volver(View view){
        this.finish();
    }

}
