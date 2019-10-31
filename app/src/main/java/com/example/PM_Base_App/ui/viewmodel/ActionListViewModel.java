package com.example.PM_Base_App.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

//The ViewModel will initialise an instance of the Repositroy Class and update the UI with its data
public class ActionListViewModel extends ViewModel {

    private ActionRepository actionRepository;
    private MutableLiveData<Resource<List<ActionEntity>>> actionsLiveData = new  MutableLiveData<>();

    @Inject
    public ActionListViewModel(ActionDao actionDao, ActionApiService actionApiService) {
        actionRepository = new ActionRepository(actionDao, actionApiService);
    }


    /*
     * Method called by UI to fetch movies list
     * */
    public void loadMoreActions() {
        actionRepository.loadActions()
        .subscribe(resource -> getActionsLiveData().postValue(resource));
    }


    /*
     * LiveData observed by the UI
     * */
    public MutableLiveData<Resource<List<ActionEntity>>> getActionsLiveData() {
        return actionsLiveData;
    }
}