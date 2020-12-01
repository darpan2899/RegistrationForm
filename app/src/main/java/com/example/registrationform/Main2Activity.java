package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView email,username,phone,country,state,gender,tob,dob,interest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        username = (TextView) findViewById(R.id.username);
        email = (TextView)findViewById(R.id.email);
        phone = (TextView) findViewById(R.id.phone);
        country = (TextView) findViewById(R.id.country);
        state = (TextView) findViewById(R.id.state);
        gender = (TextView) findViewById(R.id.gender);
        tob = (TextView) findViewById(R.id.tob);
        dob = (TextView) findViewById(R.id.dob);
        interest = (TextView) findViewById(R.id.interest);

        Intent intent =getIntent();

        username.setText(intent.getStringExtra("User_name"));
        email.setText(intent.getStringExtra("Email_id"));
        phone.setText(intent.getStringExtra("Phone_number"));
        country.setText(intent.getStringExtra("Country"));
        state.setText(intent.getStringExtra("State"));
        gender.setText(intent.getStringExtra("Gender"));
        dob.setText(intent.getStringExtra("DOB"));
        tob.setText(intent.getStringExtra("TOB"));
        interest.setText(intent.getStringExtra("Interest"));

    }
}
