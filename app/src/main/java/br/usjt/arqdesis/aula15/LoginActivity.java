package br.usjt.arqdesis.aula15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private Map users = new HashMap<Integer, Integer>();
    private int currentUserId = 0;
    private int password = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        insertUsers();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void access(View v) {
        Intent intent = new Intent(this, ExtratoActivity.class);

        EditText userText = (EditText) findViewById(R.id.editText1);
        EditText passwordText = (EditText) findViewById(R.id.editText2);

        try {
            currentUserId = Integer.parseInt(userText.getText().toString());
            password = Integer.parseInt(passwordText.getText().toString());
        } catch (Exception e) {
            currentUserId = 0;
            password = 0;
        }

        if (isValidUser(currentUserId, password)) {
            startActivity(intent);
            ((TextView) findViewById(R.id.textView)).setText("Existente");
        } else {
            ((TextView) findViewById(R.id.textView)).setText("Usuario não existente.");
            userText.setText("");
            passwordText.setText("");
        }
        v.refreshDrawableState();
    }

    private boolean isValidUser(int userId, int password) {
        Integer senha = (Integer) users.get(userId);
        if (users.containsKey(userId) && (password == senha)) {
            return true;
        } else {
            return false;
        }
    }

    public void insertUsers() {
        users.put(1200, 1234);
        users.put(9360, 2016);
        users.put(9348, 1111);
    }
}