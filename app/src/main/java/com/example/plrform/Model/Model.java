package com.example.plrform.Model;

import java.util.ArrayList;

public class Model {

    private String no_tel;
    private String type_tel;
    private String moyen_contact;
    private String moyen_paiement;

    public Model(String no_tel, String type_tel, String moyen_contact, String moyen_paiement) {
        this.no_tel = no_tel;
        this.type_tel = type_tel;
        this.moyen_contact = moyen_contact;
        this.moyen_paiement = moyen_paiement;
    }

    public String getNo_tel() {
        return no_tel;
    }

    public String getType_tel() {
        return type_tel;
    }

    public String getMoyen_contact() {
        return moyen_contact;
    }

    public String getMoyen_paiement() {
        return moyen_paiement;
    }

    private static int lastContactId = 0;

    public static ArrayList<Model> createContactsList(int numModels) {
        ArrayList<Model> models = new ArrayList<Model>();

        for (int i = 1; i <= numModels; i++) {
            models.add(new Model("47211831","Personnel","WhatsApp", "Mon Cash"));
        }

        return models;
    }
}