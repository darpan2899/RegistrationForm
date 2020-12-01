package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    EditText uname,email,phone,interest;
    AutoCompleteTextView country;
    Spinner state;
    RadioGroup gender;
    RadioButton radioButton;
    DatePicker simpleDatePicker;
    TimePicker timePicker;
    String DOB;
    String username;
    String emailid;
    String phonenumber;
    String cn;
    String st;
    String genderText;
    String TOB;
    String Interest;
    ProgressBar progressBar;
    String countries[] = {"Afghanistan","Armenia","Azerbaijan","Bahrain","Bangladesh","Bhutan","Brunei","India","Indonesia","Iran","Iraq","Israel"};
    String states[] = {"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = (EditText)findViewById(R.id.username);
        email =(EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        country = (AutoCompleteTextView) findViewById(R.id.country);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item, countries);
        country.setThreshold(2);
        country.setAdapter(adapter);

        state = (Spinner) findViewById(R.id.state);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,states);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(aa);
        gender = (RadioGroup) findViewById(R.id.gender);
        simpleDatePicker = (DatePicker)findViewById(R.id.birthDate);
        simpleDatePicker.setCalendarViewShown(false);
        timePicker = (TimePicker)findViewById(R.id.birthTime);
        timePicker.setIs24HourView(true);
        interest = (EditText) findViewById(R.id.interest);
        progressBar = findViewById(R.id.progressBar);


    }

    public void show(View view) {


        progressBar.setVisibility(View.VISIBLE);
        progressBar.setFadingEdgeLength(5);


        username = "username=" + uname.getText().toString();
        emailid = "emailid=" + email.getText().toString();
        phonenumber= "phonenumber=" + phone.getText().toString();
        st="state="+state.getSelectedItem().toString();
        cn="country="+country.getText();
        int selectedRadioButtonId = gender.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            radioButton = findViewById(selectedRadioButtonId);
            genderText = "Gender=" + radioButton.getText().toString();
        }
        else{
            genderText="Gender=others";
        }
        int month = simpleDatePicker.getMonth() + 1;
        DOB = "DOB=" +  simpleDatePicker.getDayOfMonth() + "/" + month + "/" + simpleDatePicker.getYear();
        int hour,min;
        String am_pm;
        hour = timePicker.getHour();
        min = timePicker.getMinute();
        if(hour > 12) {
            am_pm = "PM";
            hour = hour - 12;
        }
        else
        {
            am_pm="AM";
        }
        TOB = "TOB=" + hour + ":" + min + am_pm;
        Interest = "Interest=" + interest.getText();

        Intent intent = new Intent(getApplicationContext(),Main2Activity.class);


        intent.putExtra("User_name",username);
        intent.putExtra("Email_id",emailid);
        intent.putExtra("Phone_number",phonenumber);
        intent.putExtra("State",st);
        intent.putExtra("Country",cn);
        intent.putExtra("Gender",genderText);
        intent.putExtra("DOB",DOB);
        intent.putExtra("TOB",TOB);
        intent.putExtra("Interest",Interest);


        startActivity(intent);

    }


}
