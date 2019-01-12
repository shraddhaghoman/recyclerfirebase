package com.example.shraddha.rate1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;

    LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    itemAdapter adapter;
    List<itemInfo> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("Users");
        recyclerView=(RecyclerView)findViewById(R.id.recv);
         //recyclerView.setHasFixedSize(true);

        linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
         adapter=new itemAdapter(getdata());
       recyclerView.setAdapter(adapter);
        // recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        
    }


    private List<itemInfo> getdata()
    {
        List<itemInfo> data=new ArrayList<>();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()) {
                    itemInfo current = new itemInfo();
                    current.name = data.child("name").getValue(String.class);
                    current.age = data.child("age").getValue(Integer.class);
                    data.add(current);
                    // adapter.notifyDataSetChanged();

                }
            }

         }
        return data;

    }
}
