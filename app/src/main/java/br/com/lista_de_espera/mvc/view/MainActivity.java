package br.com.lista_de_espera.mvc.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.lista_de_espera.R;
import br.com.lista_de_espera.mvc.controller.PessoaController;
import br.com.lista_de_espera.mvc.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;

    public static final String NOME_PREFERENCES = "pref_listaVip";


    PessoaController controoler;


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

        preferences = getSharedPreferences(NOME_PREFERENCES,0);
        SharedPreferences.Editor listaVip = preferences.edit();

        // 2° Cria o objeto


        controoler = new PessoaController();
        controoler.toString();


        pessoa = new Pessoa();

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobreNome(preferences.getString("sobreNome", ""));;
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", ""));;
        pessoa.setTelefoneDeContato(preferences.getString("telefoneDeContato", ""));;


        editTextPrimeiroNome = findViewById(R.id.editTextPrimeiroNome);
        editTextSobreNome = findViewById(R.id.editTextSobreNome);
        editTextNomeDoCurso = findViewById(R.id.editTextNomeDoCurso);
        editTextTelefoneDeContato = findViewById(R.id.editTelefoneDeContato);


        editTextPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editTextSobreNome.setText(pessoa.getSobreNome());
        editTextNomeDoCurso.setText(pessoa.getSobreNome());
        editTextTelefoneDeContato.setText(pessoa.getTelefoneDeContato());


        buttonLimpar = findViewById(R.id.buttonLimpar);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonFinalizar = findViewById(R.id.buttonFinalizar);




        buttonSalvar.setOnClickListener(new View.OnClickListener() {

            //Aqui Seta os dados para serem salvos
            @Override
            public void onClick(View view) {

                pessoa.setPrimeiroNome(editTextPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editTextSobreNome.getText().toString());
                pessoa.setCursoDesejado(editTextNomeDoCurso.getText().toString());
                pessoa.setTelefoneDeContato(editTextTelefoneDeContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo" + pessoa.toString(), Toast.LENGTH_LONG).show();


                listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
                listaVip.putString("sobreNome", pessoa.getSobreNome());
                listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
                listaVip.putString("telefoneDeContato", pessoa.getTelefoneDeContato());
                listaVip.apply();



                

                controoler.salva(pessoa);



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