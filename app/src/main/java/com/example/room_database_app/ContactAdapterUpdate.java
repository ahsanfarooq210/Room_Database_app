package com.example.room_database_app;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.room_database_app.Entity.Contact;

import java.util.ArrayList;

public class ContactAdapterUpdate extends RecyclerView.Adapter<ContactAdapterUpdate.ViewHolder>
{
    private ArrayList<Contact> contactArrayList;
    private Activity context;

    public ContactAdapterUpdate(ArrayList<Contact> contactArrayList, Activity context)
    {
        this.contactArrayList = contactArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.show_orders_rv_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {

        holder.name.setText(contactArrayList.get(position).getName());
        holder.number.setText(contactArrayList.get(position).getMobile());
    }

    @Override
    public int getItemCount()
    {
        return contactArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView name,number;
        public ViewHolder(@NonNull final View itemView)
        {
            super(itemView);

            name=itemView.findViewById(R.id.contact_name);
            number=itemView.findViewById(R.id.contact_number);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int index;
                    index=getAdapterPosition();
                    int id;
                    id=contactArrayList.get(index).getId();
                    Intent intent=new Intent(context,update_form_activity.class);
                    intent.putExtra("update_id",id);
                    context.startActivity(intent);

                }
            });

        }
    }
}
