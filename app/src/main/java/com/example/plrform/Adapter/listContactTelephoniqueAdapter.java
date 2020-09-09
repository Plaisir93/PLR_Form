package com.example.plrform.Adapter;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.plrform.Model.Model;
import com.example.plrform.R;

import java.util.ArrayList;
import java.util.List;

public class listContactTelephoniqueAdapter extends RecyclerView.Adapter<listContactTelephoniqueAdapter.ViewHolder> {


    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView no_tel;
        public TextView type_tel;
        public TextView moyen_contact_prefere;
        public TextView moyen_paiement;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            no_tel = (TextView) itemView.findViewById(R.id.no_tel_item);
            type_tel = (TextView) itemView.findViewById(R.id.type_tel_item);
            moyen_contact_prefere = (TextView) itemView.findViewById(R.id.sp_moyen_prefere_contact_item);
            moyen_paiement = (TextView) itemView.findViewById(R.id.moyen_paiement_item);
        }
    }


    // Store a member variable for the contacts
    private List<Model> models;

    // Pass in the contact array into the constructor
    public listContactTelephoniqueAdapter(List<Model> modeles) {
        models = modeles;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public listContactTelephoniqueAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.list_contact_telephonique, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(listContactTelephoniqueAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Model contact = models.get(position);

        // Set item views based on your views and data model
        TextView textViewNoTel = holder.no_tel;
        textViewNoTel.setText(contact.getNo_tel());

        TextView textViewTypeTel = holder.type_tel;
        textViewTypeTel.setText(contact.getType_tel());

        TextView textViewNMoyenContactPefere = holder.moyen_contact_prefere;
        textViewNMoyenContactPefere.setText(contact.getMoyen_contact());

        TextView textViewMoyenPaiement = holder.moyen_paiement;
        textViewMoyenPaiement.setText(contact.getMoyen_paiement());

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return models.size();
    }

    }

