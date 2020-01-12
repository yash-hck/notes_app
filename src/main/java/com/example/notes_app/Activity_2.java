package com.example.notes_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notes_app.Notes;
import com.example.notes_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_2 extends AppCompatActivity {
    EditText edTitle;
    EditText edDes;
    Button dnBtn;
    DatabaseReference myref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        edDes=findViewById(R.id.edDes);
        edTitle=findViewById(R.id.edTitle);
        dnBtn=findViewById(R.id.dnBtn);

        myref=FirebaseDatabase.getInstance().getReference();






        dnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edDes.getText().toString().isEmpty()||edTitle.getText().toString().isEmpty())
                {
                    Toast.makeText(Activity_2.this, "Enter", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   // Intent i= getIntent();
                   // if(getIntent().getStringExtra("ID").equals(null)) {


                        String Title = edTitle.getText().toString().trim();
                        String Description = edDes.getText().toString().trim();

                        //  note.setTitle(Title);
                        //note.setDescription(Description);
                        String ID = myref.push().getKey();
                        Notes n = new Notes(Title, Description, ID);
                        myref.child(ID).setValue(n);


                        finish();
                //    }else
                //    {
                  //      String TITLE=getIntent().getStringExtra("TITLE");
                    //    String DES= getIntent().getStringExtra("DES");


                    //}


                }
            }
        });

    }
}
