package com.example.ijlal.sharedprefrance;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText uname,pass;
    Button login,saveS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = (EditText) findViewById(R.id.editText);
        pass  = (EditText) findViewById(R.id.editText2);
        login   = (Button) findViewById(R.id.login);
        saveS = (Button) findViewById(R.id.ss);

       final Database db = new Database(this);

        saveS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent o = new Intent(MainActivity.this,Signup.class);
                startActivity(o);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userValue = uname.getText().toString();
                String passValue = pass.getText().toString();

                boolean accountMatch = db.validateUser(userValue,passValue);
                if(accountMatch){
                    SharedPreferences sp = getSharedPreferences("Info", Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = sp.edit();

                    editor.putString("username",userValue);
                    editor.putString("password",passValue);
                    editor.apply();

                    Toast.makeText(getApplicationContext(),"Sessions Save",Toast.LENGTH_LONG).show();


                    Intent toSuc = new Intent(MainActivity.this, Display.class);
                    startActivity(toSuc);
                }
                else if(userValue.equals("") && passValue.equals("")){
                    Toast.makeText(MainActivity.this,"Fields Empty", Toast.LENGTH_SHORT).show();
                }

                else{Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();}
            }
        });

    }
}
