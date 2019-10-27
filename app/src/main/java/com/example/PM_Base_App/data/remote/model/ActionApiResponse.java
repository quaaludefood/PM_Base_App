package com.example.PM_Base_App.data.remote.model;

import com.example.PM_Base_App.data.local.entity.ActionEntity;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class ActionApiResponse {

    public ActionApiResponse() {
        this.actions = new ArrayList<>();
    }

    private List<ActionEntity> actions;

    public List<ActionEntity> getResults() {
        return actions;
    }

    public void setResults(List<ActionEntity> results) {
        this.actions = results;
    }

}
