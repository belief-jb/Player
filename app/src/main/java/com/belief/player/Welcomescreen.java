package com.belief.player;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class Welcomescreen extends AppCompatActivity
{
    CheckBox checkBox;
    AppCompatButton btn;
    ProgressDialog progressDialog;
    AppCompatTextView terms;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomescreen);

        btn = findViewById(R.id.btn);
        checkBox = findViewById(R.id.check);
        terms=findViewById(R.id.terms_condition);
        final String webUrl = terms.getText().toString();




        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {


                if (checkBox.isChecked())
                {
                    progressDialog = new ProgressDialog(Welcomescreen.this);
                    progressDialog.show();
                    progressDialog.setContentView(R.layout.progress_design);
                    progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    Intent intent = new Intent(Welcomescreen.this, Homescreen.class);
                    startActivity(intent);
                }



            }

        });

        terms.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Intent browserIntent = new Intent(Welcomescreen.this, Urlviewactivity.class);

                startActivity(browserIntent);
            }
        });

    }




    @Override
    public void onBackPressed()
    {

        super.onBackPressed();
        finishAffinity();
    }
}