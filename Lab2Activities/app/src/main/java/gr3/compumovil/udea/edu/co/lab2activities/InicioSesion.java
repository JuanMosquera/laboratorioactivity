package gr3.compumovil.udea.edu.co.lab2activities;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioSesion extends Fragment {

    private Button btnReg;
    private Button btnIni;
    private EditText edituser;
    private EditText editpassword;
    public InicioSesion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
        btnReg = (Button) v.findViewById(R.id.btnRegistrarse);
        edituser = (EditText) v.findViewById(R.id.edituser1);
        editpassword = (EditText) v.findViewById(R.id.editpassword1);

        btnReg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),Registro_Activity.class);
                startActivity(i);
            }
        });

        btnIni = (Button) v.findViewById(R.id.btnEntrar);
        btnIni.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                verificarUsuario();
            }
        });
        return v;
    }

    public void verificarUsuario(){
        DbHelper dbHelper = new DbHelper(getActivity().getApplicationContext()); //Instancia de DbHelper
        SQLiteDatabase db = dbHelper.getWritableDatabase(); //Obtener instancia de la BD
        String user = edituser.getText().toString();
        String pass = editpassword.getText().toString();
        Cursor cursor = db.rawQuery("select * from " + StatusContract.TABLE_USER + " where " + StatusContract.TablaUsuario.USER + " = '" + user + "' and " + TablaUsuario.PASSWORD + " = '" + pass+"'", null);

        if(cursor.moveToFirst()){
            Toast.makeText(getActivity().getApplicationContext(),"SE ENCUENTRA EN EL SISTEMA",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getActivity().getApplicationContext(),"NECESITA REGISTRARSE",Toast.LENGTH_SHORT).show();
        }

    }


}
