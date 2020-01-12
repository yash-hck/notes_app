package com.example.notes_app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MycustomAdapter extends ArrayAdapter<Notes> {

    Activity ctx;

    List<Notes> notelist=new ArrayList<>();


    public MycustomAdapter(Activity ctx,List<Notes> notelist)
    {
        super(ctx,R.layout.my_list,notelist );
        this.notelist=notelist;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =ctx.getLayoutInflater();
        View rowview= inflater.inflate(R.layout.my_list,null,true);
        TextView tit = (TextView) rowview.findViewById(R.id.tit);
        TextView descr =(TextView) rowview.findViewById(R.id.descr);

        Notes note = notelist.get(position);

        tit.setText(note.getTitle());
        String des=note.getDescription();
        if(des.length()>30)
        {
            String desc=des.substring(0,28);
            descr.setText(desc);
        }
        else {
            descr.setText(des);
        }


        return rowview;
    }
}
