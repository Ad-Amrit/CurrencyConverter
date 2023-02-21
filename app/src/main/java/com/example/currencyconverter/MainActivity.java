package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText ed1;
    Button b1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.txtamount);
        sp1=findViewById(R.id.spfrom);
        sp2=findViewById(R.id.spto);
        b1=findViewById(R.id.btn1);

        String[] from = {"USD"};
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);

        String[] to = {"NPR","INR"};
        ArrayAdapter<String> ad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp2.setAdapter(ad1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                double tot;
                double amount = Double.parseDouble(ed1.getText().toString());
                if(sp1.getSelectedItem().toString().equals("USD") && sp2.getSelectedItem().toString().equals("NPR"))
                {
                    tot = amount * 132.58 ;
                    Toast.makeText(getApplicationContext(), Double.toString(tot),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString().equals("USD") && sp2.getSelectedItem().toString().equals("INR"))
                {
                    tot = amount * 82.89 ;
                    Toast.makeText(getApplicationContext(), Double.toString(tot),Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}