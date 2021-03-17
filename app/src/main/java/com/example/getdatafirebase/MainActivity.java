package com.example.getdatafirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    EditText userName;
    EditText phoneNum;
    EditText address;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference ref=db.collection("users");
    FirestoreRecyclerOptions<user> options;
    FirestoreRecyclerAdapter<user,MyViewHolder>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName=findViewById(R.id.userName);
        phoneNum=findViewById(R.id.phoneNum);
        address=findViewById(R.id.address);
        recyclerView=findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        readData();



    }
    public void savetoFS(View v){
        String userN = userName.getText().toString();
        int phone = Integer.parseInt(phoneNum.getText().toString());
        String adress = address.getText().toString();
        user userob=new user(userN,phone,adress);


// Add a new document with a generated ID
        ref.add(userob).addOnSuccessListener((OnSuccessListener) (documentReference)-> {
            Toast.makeText(MainActivity.this,"data added",Toast.LENGTH_LONG).show();
        }).addOnFailureListener((OnFailureListener) (documentReference)->{
            Toast.makeText(MainActivity.this,"data added",Toast.LENGTH_LONG).show();
        });
        //readData();
    }

    public void readData() {
      options=new FirestoreRecyclerOptions.Builder<user>().setQuery(ref,user.class).build();
      adapter=new FirestoreRecyclerAdapter<user, MyViewHolder>(options) {
          @Override
          protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull user model) {
              holder.name.setText(""+model.getName());
              holder.phone.setText(""+model.getPhoneN());
              holder.address.setText(""+model.getAddress());
          }

          @NonNull
          @Override
          public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
              View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singl_view,parent,false);
              return new MyViewHolder(view);
          }
      };
adapter.startListening();
recyclerView.setAdapter(adapter);

    }
}