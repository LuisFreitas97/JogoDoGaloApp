package com.example.luis.jogodogalo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PagInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag_inicial);

        Toast.makeText(PagInicial.this, "Toque no ecrã para começar o jogo",
                Toast.LENGTH_LONG).show();
    }

    public void comecarJogo(View view)
    {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}
