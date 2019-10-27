package com.example.PM_Base_App.data.repository;

import androidx.annotation.NonNull;

import com.example.PM_Base_App.data.NetworkBoundResource;
import com.example.PM_Base_App.data.Resource;
import com.example.PM_Base_App.data.local.dao.ActionDao;
import com.example.PM_Base_App.data.local.entity.ActionEntity;
import com.example.PM_Base_App.data.remote.api.ActionApiService;
import com.example.PM_Base_App.data.remote.model.ActionApiResponse;

import java.util.List;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Observable;

@Singleton
public class ActionRepository {

    private ActionDao actionDao;
    private ActionApiService actionApiService;

    //Constructor
    public ActionRepository(ActionDao actionDao,
                           ActionApiService actionApiService) {
        this.actionDao = actionDao;
        this.actionApiService = actionApiService;
    }


    public Observable<Resource<List<ActionEntity>>>loadActions(){
        return new NetworkBoundResource<List<ActionEntity>, ActionApiResponse>() {

            @Override
            protected void saveCallResult(@NonNull ActionApiResponse actionApiResponse) {
                actionDao.insertActions(actionApiResponse.getResults());
            }

            @Override
            protected boolean shouldFetch() {
                return true;
            }
            @NonNull
            @Override
            protected Flowable<List<ActionEntity>> loadFromDb() {
                List<ActionEntity> actionEntities = actionDao.getAll();
                if(actionEntities == null || actionEntities.isEmpty()) {
                    return Flowable.empty();
                }
                return Flowable.just(actionEntities);
            }

            @NonNull
            @Override
            protected Observable<Resource<ActionApiResponse>> createCall() {
                return actionApiService.fetchActions()
                        .flatMap(actionApiResponse -> Observable.just(actionApiResponse == null
                                ? Resource.error("", new ActionApiResponse())
                                : Resource.success(actionApiResponse)));
            }
        }.getAsObservable();


    }
}
