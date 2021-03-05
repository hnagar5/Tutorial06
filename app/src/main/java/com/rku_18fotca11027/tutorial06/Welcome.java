package com.rku_18fotca11027.tutorial06;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {
    TextView txtUser,txtuname;

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        txtUser = findViewById(R.id.txtwlcm);
        txtuname = findViewById(R.id.txtuname);



        preferences = getSharedPreferences("Collage",MODE_PRIVATE);
        String userpreference = preferences.getString("username","");
        if(userpreference.equals(""))
        {
            Intent intent = new Intent(Welcome.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        txtuname.setText(userpreference);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {

        int id = item.getItemId();
        switch (id)
        {
            case R.id.logout:
                Toast.makeText(this, "Logout Successfully", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username","");
                editor.remove("username");
                editor.commit();

                Intent intent = new Intent(Welcome.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void logout(View view) {

        Intent intent = new Intent(Welcome.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}