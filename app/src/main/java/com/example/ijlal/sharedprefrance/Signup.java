package com.example.ijlal.sharedprefrance;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

       // TextView goHome = (TextView) findViewById(R.id.home);
        Button register = (Button) findViewById(R.id.signuppp);

      //  goHome.setPaintFlags(goHome.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

      //  goHome.setOnClickListener(new View.OnClickListener() {
      //      public void onClick(View v) {
                // Perform action on click
        //        Intent toMain = new Intent(Signup.this, MainActivity.class);
      //          startActivity(toMain);
        //    }
       // });

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Database db = new Database(v.getContext());
                Intent toMain = new Intent(Signup.this, MainActivity.class);
                EditText user = (EditText) findViewById(R.id.Susername);
                EditText pass = (EditText) findViewById(R.id.Spassword);
                String userValue = user.getText().toString();
                String passValue = pass.getText().toString();
                int charUserLength = userValue.length();
                int charPassLength = passValue.length();

                if (userValue.equals("") && passValue.equals("")) {
                    Toast.makeText(Signup.this, "Fields Empty", Toast.LENGTH_SHORT).show();
                }
                else if (charUserLength <= 2 && charPassLength <= 2) {
                    Toast.makeText(Signup.this, "Characters too short", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.addUsers(new Users(userValue, passValue));
                    startActivity(toMain);
                }

            }

        });
    }
}
