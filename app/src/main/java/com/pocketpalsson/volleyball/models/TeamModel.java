package com.pocketpalsson.volleyball.models;

import com.pocketpalsson.volleyball.R;

public class TeamModel {
    public String name;
    public int logoRef;

    public TeamModel(String name) {
        setName(name);
    }

    public TeamModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        logoRef = getLogoRef();
    }

    private int getLogoRef() {
        switch (name.toLowerCase()) {
            case "asv århus":
                return R.drawable.asvaarhus;
            case "boldklubben marienlyst":
                return R.drawable.marienlyst;
            case "gentofte volley":
                return R.drawable.gentofte;
            case "dhv odense":
                return R.drawable.dhv;
            case "hvidovre vk":
                return R.drawable.hvidovre;
            case "ishøj volley":
                return R.drawable.ishoj;
            case "lyngby volley":
            case "lyngby-gladsaxe volley":
                return R.drawable.lyngby;
            case "middelfart vk":
                return R.drawable.middelfart;
            case "randers novo volley":
                return R.drawable.randers;
            case "amager vk":
                return R.drawable.amager;
            case "fortuna odense volley":
                return R.drawable.fortuna;
            case "holte if":
                return R.drawable.holte;
            case "team køge":
                return R.drawable.koge;
            case "elite volley aarhus":
                return R.drawable.eva;
            case "brøndby vk":
                return R.drawable.brondby;
            default:
                return R.drawable.ic_cloud_off;
        }
    }
}