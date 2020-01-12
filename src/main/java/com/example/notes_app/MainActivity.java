package com.example.notes_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;
    Button adBtn,btnLogout;


    List<Notes> notelist ;
    DatabaseReference myref;
    //SharedPreferences sharedPreferences;


    @Override
    protected void onStart() {
        super.onStart();

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                notelist.clear();
                for (DataSnapshot noteshot : dataSnapshot.getChildren()){
                    Notes note = noteshot.getValue(Notes.class);
                    notelist.add(note);
                }
                MycustomAdapter adapter= new MycustomAdapter(MainActivity.this,notelist);
                list .setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

   /* private void ShowUpdatedialog(final String noteId, final String noteTitle , final String noteDes){
        AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(this);
        final LayoutInflater inflater = getLayoutInflater();
        final View dialog =inflater.inflate(R.layout.dailog,null);

        dialogbuilder.setView(dialog);


        final Button btnDelete=findViewById(R.id.btnDelete);
        final Button btnUpdate=findViewById(R.id.btnUpdate);

        final AlertDialog alertDialog= dialogbuilder.create();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Activity_4.class);
                intent.putExtra("ID",noteId);
                intent.putExtra("TITLE",noteTitle);
                intent.putExtra("DESC",noteDes);
                startActivity(intent);
                alertDialog.dismiss();
            }

        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseReference =FirebaseDatabase.getInstance().getReference().child(noteId);
                databaseReference.removeValue();
                alertDialog.dismiss();

            }

        });
        alertDialog.show();
        }*/







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list = findViewById(R.id.list);
        adBtn = findViewById(R.id.adBtn);

        //final SharedPreferences.Editor ed = sharedPreferences.edit();

        notelist= new ArrayList<>();
       // Intent intent =getIntent();
        //String id=intent.getStringExtra("USER");

        myref = FirebaseDatabase.getInstance().getReference();
      //  final MycustomAdapter mycustomAdapter = new MycustomAdapter(this, notelist);
       // list.setAdapter( );

        /*btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed.clear();
                ed.putString("ID","null");
                ed.commit();
                Intent i=new Intent(MainActivity.this,Login.class);
                startActivity(i);
                MainActivity.this.finish();



            }
        });*/

        adBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity_2.class);
                startActivity(intent);


            }
        });

       list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               Notes notes=notelist.get(i);

              Intent in =new Intent(MainActivity.this,Activity_4.class);
               in.putExtra("ID",notes.getID());
               in.putExtra("TITLE",notes.getTitle());
               in.putExtra("DES",notes.getDescription());
                startActivity(in);

              //ShowUpdatedialog(notes.getID(),notes.getTitle(),notes.getDescription());




               return true;
           }
       });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Notes note = notelist.get(i);
                Intent intent =new Intent(MainActivity.this,Activity_3.class);

                intent.putExtra("aTitle",note.getTitle());
                intent.putExtra("aDescription",note.getDescription());
                startActivity(intent);

            }
        });



    }
}