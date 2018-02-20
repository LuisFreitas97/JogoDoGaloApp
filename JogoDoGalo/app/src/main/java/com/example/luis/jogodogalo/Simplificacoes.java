package com.example.luis.jogodogalo;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by luis on 12-01-2018.
 */

public class Simplificacoes extends AppCompatActivity {

    public void buttonClick(Button b,int tipoImagem)
    {
        if(tipoImagem==1)
        {
            b.setBackgroundResource(R.drawable.heroi);
            //b.setVisibility(View.VISIBLE); //To set visible
        }
        else if(tipoImagem==2)
        {
            b.setBackgroundResource(R.drawable.player2);
            //b.setVisibility(View.VISIBLE); //To set visible
        }
}
}
