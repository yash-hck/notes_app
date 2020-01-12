package com.example.notes_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_4 extends AppCompatActivity {

    DatabaseReference myref;

    EditText edUptitle,edUpdes;
    Button btnSave,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        edUpdes =findViewById(R.id.edUpdes);
        edUptitle=findViewById(R.id.edUptitle);
        btnSave=findViewById(R.id.btnSave);
        btnDelete=findViewById(R.id.btnDelete);
        myref = FirebaseDatabase.getInstance().getReference();

        Intent in=getIntent();
        final String id=in.getStringExtra("ID");
        String Ti=in.getStringExtra("TITLE");
        String De =in.getStringExtra("DES");

        edUptitle.setText(Ti);
        edUpdes.setText(De);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseReference =FirebaseDatabase.getInstance().getReference().child(id);
                databaseReference.removeValue();
                Activity_4.this.finish();


            }

        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edUpdes.getText().toString().isEmpty()||edUptitle.getText().toString().isEmpty())
                {
                    Toast.makeText(Activity_4.this, "Enter", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // Intent i= getIntent();
                    // if(getIntent().getStringExtra("ID").equals(null)) {


                    String Title = edUptitle.getText().toString().trim();
                    String Description = edUpdes.getText().toString().trim();

                    //  note.setTitle(Title);
                    //note.setDescription(Description);
                   // String ID = myref.push().getKey();
                    Notes n = new Notes(Title, Description, id);
                    myref.child(id).setValue(n);


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
