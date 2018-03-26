package com.example.luis.jogodogalo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Simplificacoes{

    private int tipoImagem=1;
    private int jogador=1;
    private boolean acabou=false;
    private int [] posClick = new int [9]; //Array para as posições do tabuleiro que já foram click

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "Jogada do player 1",
                Toast.LENGTH_LONG).show();
    }

    public void main(View v)
    {
        int bId=v.getId(); //Guarda o id do botão que foi carregado no xml
        Button b=findViewById(bId); //Busca a intância desse botão

        String posBid = v.getTag().toString(); //Busca o id do botão que foi clicado
        int posId=Integer.parseInt(posBid); //Converte o id do botão para int

       if(!acabou) {
            if (jogador == 1) {
                if (posClick[posId - 1] != 1 && posClick[posId - 1] != 2) {
                    buttonClick(b, tipoImagem);
                    posClick[posId - 1] =jogador;
                    jogador = 2;
                    tipoImagem = 2;
                    if(!verificaGanhar())
                    {
                        Toast.makeText(MainActivity.this, "Jogada do player 2",
                                Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        acabou=true;
                        Intent myIntent = new Intent(this, MainActivity.class);
                        startActivity(myIntent);
                        this.finish();
                    }
                }
            } else if (jogador == 2) {
                if (posClick[posId - 1] != 1 && posClick[posId - 1] != 2) {
                    buttonClick(b, tipoImagem);
                    posClick[posId - 1] =jogador;
                    jogador = 1;
                    tipoImagem = 1;
                    if(!verificaGanhar())
                    {
                        Toast.makeText(MainActivity.this, "Jogada do player 1",
                                Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        acabou=true;
                        Intent myIntent = new Intent(this, MainActivity.class);
                        startActivity(myIntent);
                    }
                }
            }
      }
    }

    public boolean verificaGanhar()
    {
        int i=0;
        //Verifica linhas
        while(i<9)
        {
            if (posClick[i] == posClick[i + 1] && posClick[i + 1] == posClick[i + 2])
            {
                if (posClick[i] == 1)
                {
                    Toast.makeText(MainActivity.this, "O jogador 1 ganhou",
                            Toast.LENGTH_LONG).show();
                    return true;
                }
                else if (posClick[i] == 2)
                {
                    Toast.makeText(MainActivity.this, "O jogador 2 ganhou",
                            Toast.LENGTH_LONG).show();
                    return true;
                }
            }
            i+=3;
        }
        i=0;
        //Verifica colunas
        while(i<3)
        {
            if (posClick[i] == posClick[i + 3] && posClick[i + 3] == posClick[i + 6])
            {
                if (posClick[i] == 1)
                {
                    Toast.makeText(MainActivity.this, "O jogador 1 ganhou",
                            Toast.LENGTH_LONG).show();
                    return true;
                }
                else if (posClick[i] == 2)
                {
                    Toast.makeText(MainActivity.this, "O jogador 2 ganhou",
                            Toast.LENGTH_LONG).show();
                    return true;
                }
            }
            i+=1;
        }
        //Verifica a diagonal nas posições 0,4 e 8
        if(posClick[0]==posClick[4] && posClick[4]==posClick[8])
        {
            if (posClick[0] == 1)
            {
                Toast.makeText(MainActivity.this, "O jogador 1 ganhou",
                        Toast.LENGTH_LONG).show();
                return true;
            }
            else if (posClick[0] == 2)
            {
                Toast.makeText(MainActivity.this, "O jogador 2 ganhou",
                        Toast.LENGTH_LONG).show();
                return true;
            }
        }
        //Verifica as posições nas posições 2,4 e 6
        if(posClick[2]==posClick[4] && posClick[4]==posClick[6])
        {
            if (posClick[2] == 1)
            {
                Toast.makeText(MainActivity.this, "O jogador 1 ganhou",
                        Toast.LENGTH_LONG).show();
                return true;
            }
            else if (posClick[2] == 2)
            {
                Toast.makeText(MainActivity.this, "O jogador 2 ganhou",
                        Toast.LENGTH_LONG).show();
                return true;
            }
        }
        int indice=0;
        while(indice<9)
        {
            if(posClick[indice]==0)
            {
                return false;
            }
            indice++;
        }
        Toast.makeText(MainActivity.this, "Empate",
                Toast.LENGTH_LONG).show();
        return true;
    }
}
