package com.rku_18fotca11027.tutorial06;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = findViewById(R.id.edtusername);
        edtPassword = findViewById(R.id.edtpassword);
    }

    public void btnLoginClick(View view) {

        String valUsername = edtUsername.getText().toString();
        String valPassword = edtPassword.getText().toString();

        if (valUsername.equals("")) {
            Toast.makeText(this, "Username can not be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (valPassword.equals("")) {
            Toast.makeText(this, "Password can not be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (valPassword.length() < 6) {
            Toast.makeText(this, "Password must be of minimum 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(valUsername).matches()) {
            Toast.makeText(this, "Username must be proper email address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (valUsername.equals("hnagar@gmail.com") && valPassword.equals("555555")) {
            SharedPreferences preferences = getSharedPreferences("Collage", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("username", valUsername);
            editor.commit();

            Intent intent = new Intent(MainActivity.this, Welcome.class);
            intent.putExtra("username", valUsername);
            startActivity(intent);
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void getRegister(View view) {
        startActivity(new Intent(MainActivity.this, Registration.class));
    }
}