package br.com.lista_de_espera.mvc.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.lista_de_espera.R;
import br.com.lista_de_espera.mvc.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    // 1° Cria a variável
    Pessoa pessoa;

    String dadosPessoa;

    EditText editTextPrimeiroNome;
    EditText editTextSobreNome;
    EditText editTextNomeDoCurso;
    EditText editTextTelefoneDeContato;

    Button buttonLimpar;
    Button buttonSalvar;
    Button buttonFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2° Cria o objeto
        pessoa = new Pessoa();


        pessoa.setPrimeiroNome("Rogério");
        pessoa.setSobreNome("Hopka");
        pessoa.setCursoDesejado("Java");
        pessoa.setTelefoneDeContato("99991234");


        editTextPrimeiroNome = findViewById(R.id.editTextPrimeiroNome);
        editTextSobreNome = findViewById(R.id.editTextSobreNome);
        editTextNomeDoCurso = findViewById(R.id.editTextNomeDoCurso);
        editTextTelefoneDeContato = findViewById(R.id.editTelefoneDeContato);


        buttonLimpar = findViewById(R.id.buttonLimpar);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonFinalizar = findViewById(R.id.buttonFinalizar);

        editTextPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editTextSobreNome.setText(pessoa.getSobreNome());
        editTextNomeDoCurso.setText(pessoa.getSobreNome());
        editTextTelefoneDeContato.setText(pessoa.getTelefoneDeContato());


        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pessoa.setPrimeiroNome(editTextPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editTextSobreNome.getText().toString());
                pessoa.setCursoDesejado(editTextNomeDoCurso.getText().toString());
                pessoa.setTelefoneDeContato(editTextTelefoneDeContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo" + pessoa.toString(), Toast.LENGTH_LONG).show();

            }
        });

        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextPrimeiroNome.setText("");
                editTextSobreNome.setText("");
                editTextNomeDoCurso.setText("");
                editTextTelefoneDeContato.setText("");
            }
        });

        buttonFinalizar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Finalizado", Toast.LENGTH_LONG).show();


            }
        });

    }
}