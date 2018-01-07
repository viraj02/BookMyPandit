package com.example.virajjoshi.bookmypandit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Pandit_Registration extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private EditText name,mobile,email,dateofbirth,address,experience,langu,expertin;
    private CheckBox c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pandit__registration);

        c1 = (CheckBox) findViewById(R.id.checkBox1);
        c1.setOnCheckedChangeListener(Pandit_Registration.this);

    }

    private void TermCondition() {
        String mail = "Enter The Valid Email Id This Will be useful while SignIn OR resetting the password";
        String password = "Enter Valid password .";


        final AlertDialog.Builder builder = new AlertDialog.Builder(Pandit_Registration.this);
        builder.setTitle("Terms And Conditions");
        builder.setMessage(mail + "\n" + password + "\n");
        builder.setCancelable(true);

        builder.setPositiveButton("Agree", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //CreateAccount.setEnabled(true);
                c1.setChecked(true);
                dialog.cancel();
            }
        });

        builder.setNegativeButton("Not Agree", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                c1.setChecked(false);
               // CreateAccount.setEnabled(false);
                dialog.cancel();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }



































    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(Pandit_Registration.this);
        builder.setMessage("Do You Want To Close App ");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNeutralButton("Home", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Pandit_Registration.this,MainActivity.class));
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                dialog.cancel();
            }
        });

        AlertDialog alert  = builder.create();
        alert.show();

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(c1.isChecked() == true){
            TermCondition();
        }
        if(c1.isChecked() == false){
            //CreateAccount.setEnabled(false);
        }
    }
}
