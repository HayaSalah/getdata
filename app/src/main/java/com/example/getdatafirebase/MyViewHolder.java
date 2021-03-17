package com.example.getdatafirebase;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView name,phone,address;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.txtname);
        phone=itemView.findViewById(R.id.txtphone);
        address=itemView.findViewById(R.id.txtaddress);
    }
}
