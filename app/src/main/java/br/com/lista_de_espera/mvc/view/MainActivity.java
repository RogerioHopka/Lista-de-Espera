package br.com.lista_de_espera.mvc.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.lista_de_espera.R;
import br.com.lista_de_espera.mvc.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    // 1° Cria a variável
    Pessoa pessoa;

    String dadosPessoa;

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


    dadosPessoa = " O seu primeiro nome é:  ";
    dadosPessoa += pessoa.getPrimeiroNome();
    dadosPessoa += " e o seu sobre nome é:  ";
    dadosPessoa += pessoa.getSobreNome();

    dadosPessoa += " e o seu curso desejado é:  ";
    dadosPessoa += pessoa.getCursoDesejado();

    dadosPessoa += " e o seu telefone é:  ";
    dadosPessoa += pessoa.getTelefoneDeContato();

     }
}