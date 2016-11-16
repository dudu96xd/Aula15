package br.usjt.arqdesis.aula15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheExtratoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_extrato);
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(getIntent().getStringExtra(ExtratoActivity.NOME));
    }
}