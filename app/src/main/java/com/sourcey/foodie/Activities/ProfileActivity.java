package com.sourcey.foodie.Activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.sourcey.foodie.R;


public class ProfileActivity extends AppCompatActivity {

    public ProfileActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);
    }

    protected void mailClicked(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Mail address");
        alert.setMessage("Enter a new mail address");

        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                TextView tvId = (TextView) findViewById(R.id.tvNumber3);
                tvId.setText(input.getText());

                String string = getString(R.string.tv_profile_mail_text);
                string = input.getText().toString();
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });

        alert.show();
    }

}
