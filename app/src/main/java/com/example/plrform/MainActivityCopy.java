package com.example.plrform;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plrform.Adapter.listContactTelephoniqueAdapter;
import com.example.plrform.Model.Model;

import java.util.ArrayList;
import java.util.List;

public class MainActivityCopy extends AppCompatActivity {
    Button btnSave, btnCloseInfPers, btnCloseAdressePhysique, btnClosePersonCon;
    Dialog myDialog;
    Spinner spin_type_tel, moyen_paiement, verifier, whatsapp, type_contact, statut_vih, moyen_prefere_contact, est_smartphone;
    Spinner dept, commune;
   private ArrayList<Model> contactTelephoniqueList;
    ArrayList<Model> models;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //myDialog = new Dialog(this);
        myDialog = new Dialog(new ContextThemeWrapper(this, R.style.DialogSlideAnim));

        // Lookup the recyclerview in activity layout
        RecyclerView rvModels = (RecyclerView) findViewById(R.id.rvModels);

        // Initialize contacts
        models = Model.createContactsList(20);
        // Create adapter passing in the sample user data
        listContactTelephoniqueAdapter adapter = new listContactTelephoniqueAdapter(models);
        // Attach the adapter to the recyclerview to populate items
        rvModels.setAdapter(adapter);
        // Set layout manager to position the items
        rvModels.setLayoutManager(new LinearLayoutManager(this));
        // That's all!

//        contactTelephoniqueList = new ArrayList<Model>();
//        ListView lview = (ListView) findViewById(R.id.listview);
//        listContactTelephoniqueAdapter adapter = new listContactTelephoniqueAdapter(this, contactTelephoniqueList);
//        lview.setAdapter(adapter);
//
//        populateList();
//
//        adapter.notifyDataSetChanged();


//        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//
//                String sno = ((TextView)view.findViewById(R.id.no_tel_item)).getText().toString();
//                String product = ((TextView)view.findViewById(R.id.type_tel_item)).getText().toString();
//                String category = ((TextView)view.findViewById(R.id.sp_moyen_prefere_contact_item)).getText().toString();
//                String price = ((TextView)view.findViewById(R.id.moyen_paiement_item)).getText().toString();
//
//                Toast.makeText(getApplicationContext(),
//                        "S no : " + sno +"\n"
//                                +"Product : " + product +"\n"
//                                +"Category : " +category +"\n"
//                                +"Price : " +price, Toast.LENGTH_SHORT).show();
//            }
//        });


    }

    public void ShowPopupNouveauContact(View v) {
        TextView txtclose;
        myDialog.setContentView(R.layout.fragment_contact_tel);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        // Spinner element
        spin_type_tel = myDialog.findViewById(R.id.sp_type_telephone);
        moyen_paiement = myDialog.findViewById(R.id.sp_moncash_natcash);
        verifier = myDialog.findViewById(R.id.sp_verification);
        whatsapp = myDialog.findViewById(R.id.sp_whatsapp);
        btnCloseInfPers = myDialog.findViewById(R.id.btcancel_contact_tel);
        moyen_prefere_contact = myDialog.findViewById(R.id.sp_moyen_prefere_contact);
        est_smartphone = myDialog.findViewById(R.id.sp_est_smartphone);

        // Spinner Drop down elements
        List<String> type_telephone = new ArrayList<String>();
        type_telephone.add("--Choisir--");
        type_telephone.add("Personnel");
        type_telephone.add("Domicile");
        type_telephone.add("Autre");

        List<String> l_moyen_paiement = new ArrayList<String>();
        l_moyen_paiement.add("Aucun");
        l_moyen_paiement.add("Moncash");
        l_moyen_paiement.add("Natcash");

        List<String> l_oui_non = new ArrayList<String>();
        l_oui_non.add("Oui");
        l_oui_non.add("Non");

        List<String> l_moyen_prefere_contact = new ArrayList<String>();
        l_moyen_prefere_contact.add("Appel");
        l_moyen_prefere_contact.add("Texte (SMS)");
        l_moyen_prefere_contact.add("WhatsApp");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, type_telephone);
        ArrayAdapter<String> dataAdapterMoyenPaiement = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, l_moyen_paiement);
        ArrayAdapter<String> dataAdapterVerification = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, l_oui_non);
        ArrayAdapter<String> dataAdapterWhatsApp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, l_oui_non);
        ArrayAdapter<String> dataAdapterMoyenPrefereContact = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, l_moyen_prefere_contact);
        ArrayAdapter<String> dataAdapterEstSmartPhone = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, l_oui_non);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterMoyenPaiement.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterVerification.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterWhatsApp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterMoyenPrefereContact.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterEstSmartPhone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spin_type_tel.setAdapter(dataAdapter);
        moyen_paiement.setAdapter(dataAdapterMoyenPaiement);
        verifier.setAdapter(dataAdapterVerification);
        whatsapp.setAdapter(dataAdapterWhatsApp);
        moyen_prefere_contact.setAdapter(dataAdapterMoyenPrefereContact);
        est_smartphone.setAdapter(dataAdapterEstSmartPhone);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

        btnCloseInfPers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

    }

    public void ShowPopupAddLieuFrequente(View v) {
        TextView txtclose;
        Button btnFollow;
        myDialog.setContentView(R.layout.fragment_lieux_frequente);


        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        //Objects.requireNonNull(myDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }

    public void ShowPopUpAddPersonCon(View v) {
        TextView txtclose;
        Button btnFollow;
        myDialog.setContentView(R.layout.fragment_person_contact);

//        // Spinner element
        type_contact = myDialog.findViewById(R.id.sp_type_contact);
        statut_vih = myDialog.findViewById(R.id.sp_statut_vih);

        btnClosePersonCon = myDialog.findViewById(R.id.btcancel_pers_con);
//
//
        // Spinner Drop down elements
        List<String> l_type_contact = new ArrayList<String>();
        l_type_contact.add("--Choisir--");
        l_type_contact.add("Parent Proche");
        l_type_contact.add("Conjoint");
        l_type_contact.add("Ami(e)");
        l_type_contact.add("Paire");
        l_type_contact.add("Autre");
        l_type_contact.add("Autre");

        List<String> l_statut_vih = new ArrayList<String>();
        l_statut_vih.add("--Choisir--");
        l_statut_vih.add("Positif");
        l_statut_vih.add("Négatif");
        l_statut_vih.add("Non déterminé");
//
//
//
//
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterTypeContact = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, l_type_contact);
        ArrayAdapter<String> dataAdapterStatutVih = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, l_statut_vih);

        // Drop down layout style - list view with radio button
        dataAdapterTypeContact.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterStatutVih.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        type_contact.setAdapter(dataAdapterTypeContact);
        statut_vih.setAdapter(dataAdapterStatutVih);

        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        //Objects.requireNonNull(myDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

        btnClosePersonCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
    }
    public void ShowPopupModifLieuResidence(View v) {
        TextView txtclose;
        myDialog.setContentView(R.layout.fragment_adresse_physique);

        // Spinner element
        dept = myDialog.findViewById(R.id.sp_departement);
        commune = myDialog.findViewById(R.id.sp_commune);
        btnCloseAdressePhysique = myDialog.findViewById(R.id.btcancel_adresse_physique);

//        // Spinner Drop down elements
        List<String> l_dept = new ArrayList<String>();
        l_dept.add("--Choisir--");
        l_dept.add("Artibonite");
        l_dept.add("Centre");
        l_dept.add("Grand-Anse");
        l_dept.add("Nippes");
        l_dept.add("Nord");
        l_dept.add("Nord-Est");
        l_dept.add("Nord-Ouest");
        l_dept.add("Ouest");
        l_dept.add("Sud");
        l_dept.add("Sud-Est");
//
        List<String> l_commune = new ArrayList<String>();
        l_commune.add("--Choisir--");
        l_commune.add("Delmas");
        l_commune.add("Cabaret");
        l_commune.add("Port-au-Prince");
        l_commune.add("Carrefour");
        l_commune.add("Turgeau");
        l_commune.add("Cité Soleil");

     // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterDept = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, l_dept);
        ArrayAdapter<String> dataAdapterCommune = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, l_commune);

       // Drop down layout style - list view with radio button
        dataAdapterDept.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterCommune.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

       // attaching data adapter to spinner
        dept.setAdapter(dataAdapterDept);
        commune.setAdapter(dataAdapterCommune);

        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        //Objects.requireNonNull(myDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

        btnCloseAdressePhysique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
    }


    private void populateList() {

        Model item1, item2, item3, item4, item5;

        item1 = new Model("47211831", "Personnel", "WhatsApp", "Mon Cash");
        contactTelephoniqueList.add(item1);

        item2 = new Model("2", "Orange (Sunkist navel)", "Fruits", "₹. 100");
        contactTelephoniqueList.add(item2);

        item3 = new Model("3", "Tomato", "Vegetable", "₹. 50");
        contactTelephoniqueList.add(item3);

        item4 = new Model("4", "Carrot", "Vegetable", "₹. 80");
        contactTelephoniqueList.add(item4);

        item5 = new Model("5", "Banana (Cavendish)", "Fruits", "₹. 100");
        contactTelephoniqueList.add(item5);
    }


}