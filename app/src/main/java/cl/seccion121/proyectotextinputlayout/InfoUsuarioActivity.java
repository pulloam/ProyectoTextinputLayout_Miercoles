package cl.seccion121.proyectotextinputlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InfoUsuarioActivity extends AppCompatActivity {
    private TextView tvDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_usuario);

        referencias();
        obtenerDatos();

    }

    private void referencias() {
        tvDatos = findViewById(R.id.tvDatosEnviados);
    }

    private void obtenerDatos(){
        Usuario u;

        u = (Usuario) getIntent().getExtras().getSerializable("usr");


        tvDatos.setText(u.getNombre() + " - " + u.getCorreo()
                + " Clave :" +  u.getClave());
    }

}