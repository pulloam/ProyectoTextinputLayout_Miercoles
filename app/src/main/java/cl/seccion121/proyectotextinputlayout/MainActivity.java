package cl.seccion121.proyectotextinputlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private EditText etCorreo, etNombre;
    private TextInputLayout tilClave;

    private Button btnAceptar, btnCancelar;

    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        referencias();
        eventos();
    }

    private void obtenerDatos(){
        String correo, nombre, clave;

        correo = etCorreo.getText().toString();
        nombre = etNombre.getText().toString();
        clave = tilClave.getEditText().getText().toString();

        usuario = new Usuario(correo, nombre, clave);
    }

    private boolean validarDatos(Usuario usr){
        boolean vOk = true;
        boolean hayMay = false, hayMin = false, hayNum = false;

        tilClave.setError(null);

        if(usr.getCorreo().isEmpty()) {
            etCorreo.setError("Debe ingresar correo");
            vOk = false;
        }

        if(usr.getNombre().isEmpty()) {
            etNombre.setError("Debe ingresar nombre");
            vOk = false;
        }

        if(usr.getClave().isEmpty()) {
            tilClave.setError("Debe ingresar clave");
            vOk = false;
        }else{
            for(int x = 0; x < usr.getClave().length(); ++x){
                char miCaracter = usr.getClave().charAt(x);

                if(Character.isUpperCase(miCaracter)) {
                    hayMay = true;
                }

                if(Character.isLowerCase(miCaracter)) {
                    hayMin = true;
                }

                if(Character.isDigit(miCaracter)) {
                    hayNum = true;
                }
            }

            if(!hayMay || !hayMin || !hayNum || usr.getClave().length() < 11) {
                vOk = false;
                tilClave.setError("Debe contener una mayúscula, minúscula, números y mayor a 10 caracteres");
            }

        }

        return vOk;
    }

    private void enviar(){
        if(validarDatos(usuario)) {
            Intent i = new Intent(this, InfoUsuarioActivity.class);
            i.putExtra("usr", usuario);
            startActivity(i);
        }else{
            Toast.makeText(this, "Tiene errores en el formulario", Toast.LENGTH_LONG).show();
        }
    }


    //region Referencias y Eventos
    private void referencias(){
        etCorreo = findViewById(R.id.etCorreo);
        etNombre = findViewById(R.id.etNombre);
        tilClave = findViewById(R.id.tilClave);

        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);
    }

    private void eventos(){
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerDatos();
                enviar();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //endregion

}