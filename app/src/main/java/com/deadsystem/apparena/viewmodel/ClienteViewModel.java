package com.deadsystem.apparena.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.deadsystem.apparena.db.AppDatabase;
import com.deadsystem.apparena.entities.ClienteEntity;
import com.deadsystem.apparena.model.Cliente;

import java.util.List;

public class ClienteViewModel extends AndroidViewModel {

    private MutableLiveData<List<ClienteEntity>> listMutableLiveData;
    private AppDatabase appDatabase;

    public ClienteViewModel(@NonNull Application application) {
        super(application);
        listMutableLiveData = new MutableLiveData<>();

        appDatabase = AppDatabase.getDBInstance(application);
    }

    public MutableLiveData<List<ClienteEntity>> getListClienteObserver(){
        return listMutableLiveData;
    }

    public void getAllClients(){
        List<ClienteEntity> clienteList = this.appDatabase.clienteDAORoom().getAllClients();
        if(clienteList.size() > 0){
            this.listMutableLiveData.postValue(clienteList);
        }else{
            this.listMutableLiveData.postValue(null);
        }
    }

    public void insertClient(ClienteEntity cliente){
        this.appDatabase.clienteDAORoom().insertClient(cliente);
        getAllClients();
    }

    public void updateClient(ClienteEntity cliente){
        this.appDatabase.clienteDAORoom().updateClient(cliente);
        getAllClients();
    }

    public void deleteClient(ClienteEntity cliente){
        this.appDatabase.clienteDAORoom().deleteClient(cliente);
        getAllClients();
    }

}
