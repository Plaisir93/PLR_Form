package com.example.plrform.Adapter;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.plrform.Model.Model;
import com.example.plrform.R;

import java.util.ArrayList;

public class listContactTelephoniqueAdapterCopy extends BaseAdapter {

        public ArrayList<Model> contactTelephoniqueList;
        Activity activity;

        public listContactTelephoniqueAdapterCopy(Activity activity, ArrayList<Model> contactTelephoniqueList) {
            super();
            this.activity = activity;
            this.contactTelephoniqueList = contactTelephoniqueList;
        }

        @Override
        public int getCount() {
            return contactTelephoniqueList.size();
        }

        @Override
        public Object getItem(int position) {
            return contactTelephoniqueList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        private class ViewHolder {
            TextView no_tel;
            TextView type_tel;
            TextView moyen_contact_prefere;
            TextView moyen_paiement;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;
            LayoutInflater inflater = activity.getLayoutInflater();

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.list_contact_telephonique, null);
                holder = new ViewHolder();
                holder.no_tel = (TextView) convertView.findViewById(R.id.no_tel_item);
                holder.type_tel = (TextView) convertView.findViewById(R.id.type_tel_item);
                holder.moyen_contact_prefere = (TextView) convertView.findViewById(R.id.sp_moyen_prefere_contact_item);
                holder.moyen_paiement = (TextView) convertView.findViewById(R.id.moyen_paiement_item);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Model item = contactTelephoniqueList.get(position);
            holder.no_tel.setText(item.getNo_tel().toString());
            holder.type_tel.setText(item.getType_tel().toString());
            holder.moyen_contact_prefere.setText(item.getMoyen_contact().toString());
            holder.moyen_paiement.setText(item.getMoyen_paiement().toString());

            return convertView;
        }
    }

