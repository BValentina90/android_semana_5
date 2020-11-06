package danikho.com.mascotasValeBaldoni;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

public class ActivityContacto extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        ImageView star = findViewById(R.id.iv5star);

        star.setVisibility(View.INVISIBLE);

        Toolbar toolbar = findViewById(R.id.miactionbar);
        setSupportActionBar(toolbar);

        final AppCompatEditText etNombre = (AppCompatEditText) findViewById(R.id.etNombre);
        final AppCompatEditText etEmail = (AppCompatEditText) findViewById(R.id.etEmail);
        final AppCompatEditText etMensaje = (AppCompatEditText) findViewById(R.id.etMensaje);
        final AppCompatButton btnEnviar = (AppCompatButton) findViewById(R.id.btnEnviar);
        final AppCompatTextView tvAlert = (AppCompatTextView) findViewById(R.id.tvAlert);

        btnEnviar.setOnClickListener(view -> {
            /*
            String nombre = etNombre.getText().toString();
            String email = etEmail.getText().toString();
            String mensaje = etMensaje.getText().toString();
             */
            etNombre.setText("");
            etEmail.setText("");
            etMensaje.setText("");
            tvAlert.setText("Mensaje enviado!");
        });


    }
}