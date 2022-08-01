package com.example.jogo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selecionadaPedra(View view){
        this.opcaoSelecionada("pedra");
    }
    public void selecionadaPapel(View view){
        this.opcaoSelecionada("papel");
    }
    public void selecionadaTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){
        ImageView imageViewResultado = findViewById(R.id.imageViewResultado);
        TextView txtResultado = findViewById(R.id.txtResultado);

        int numero  = new Random().nextInt( 3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes [ numero];

        switch (opcaoApp ){
            case "pedra":
                imageViewResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageViewResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageViewResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if (
                (opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
                (opcaoApp == "papel" && opcaoSelecionada == "pedra") ||
                (opcaoApp == "pedra" && opcaoSelecionada == "tesoura")
        ){
            txtResultado.setText("Você perdeu");

        }else if (
                (opcaoSelecionada == "tesoura" && opcaoApp== "papel") ||
                (opcaoSelecionada == "papel" && opcaoApp== "pedra") ||
                (opcaoSelecionada == "pedra" && opcaoApp== "tesoura")
        ){
            txtResultado.setText("Você ganhou!");

        }else{
            txtResultado.setText("Empatamos!");
        }

        System.out.println("item clicado:" + opcaoApp );
    }
}