package com.example.pedrapapeltesoura;
// Gabriel Fernandes Justino & Lucas Froes Belinassi
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int pontosJogador = 0;
    int pontosApp = 0;
    private ImageView imgPedra;
    private ImageView imgTesoura;
    private ImageView imgPapel;
    private ImageView imgVazio;
    private TextView resultado;
    private TextView pontApp;
    private TextView pontJogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPedra = findViewById(R.id.imgPedra);
        imgTesoura = findViewById(R.id.imgTesoura);
        imgPapel = findViewById(R.id.imgPapel);
        imgVazio = findViewById(R.id.imgVazio);
        resultado = findViewById(R.id.resultado);
        pontApp = findViewById(R.id.pontApp);
        pontJogador = findViewById(R.id.pontJogador);

        EscutadorClickImagem i = new EscutadorClickImagem();

        imgPedra.setOnClickListener(i);
        imgPapel.setOnClickListener(i);
        imgTesoura.setOnClickListener(i);
    }

    private class EscutadorClickImagem implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int escolhaUsuario = 0;
            ImageView img = (ImageView) v;
            switch (img.getId()) {
                case R.id.imgPedra:
                    escolhaUsuario = 1;
                    break;
                case R.id.imgPapel:
                    escolhaUsuario = 2;
                    break;
                case R.id.imgTesoura:
                    escolhaUsuario = 3;
                    break;
            }
            int escolhaApp = new Random().nextInt(3) + 1;
            switch (escolhaApp) {
                case 1:
                    imgVazio.setImageResource(R.drawable.pedra);
                    break;
                case 2:
                    imgVazio.setImageResource(R.drawable.papel);
                    break;
                case 3:
                    imgVazio.setImageResource(R.drawable.tesoura);
                    break;
            }
            if ((escolhaApp == 1 && escolhaUsuario == 3) ||
                    (escolhaApp == 2 && escolhaUsuario == 1) ||
                    (escolhaApp == 3 && escolhaUsuario == 2)) {
                pontosApp++;
                pontApp.setText(String.valueOf(pontosApp));

                resultado.setText("O app ganhou!!!!");
            } else {
                if ((escolhaApp == 3 && escolhaUsuario == 1) ||
                        (escolhaApp == 1 && escolhaUsuario == 2) ||
                        (escolhaApp == 2 && escolhaUsuario == 3)) {
                    pontosJogador++;
                    pontJogador.setText(String.valueOf(pontosJogador));
                    resultado.setText("Você ganhou!!");
                } else {
                    resultado.setText("Deu empate!");
                }
            }
        }
    }
}