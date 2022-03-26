package com.deadsystem.apparena.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.deadsystem.apparena.db.AppDatabase;
import com.deadsystem.apparena.entities.ClienteEntity;
import com.deadsystem.apparena.entities.ProdutoEntity;

import java.util.List;

public class ProdutoViewModel extends AndroidViewModel {

    private MutableLiveData<List<ProdutoEntity>> listMutableLiveData;
    private AppDatabase appDatabase;

    public ProdutoViewModel(@NonNull Application application) {
        super(application);
        listMutableLiveData = new MutableLiveData<>();

        appDatabase = AppDatabase.getDBInstance(application);
    }

    public MutableLiveData<List<ProdutoEntity>> getListProdutoObserver(){
        return listMutableLiveData;
    }

    public void getAllProducts(){
        List<ProdutoEntity> produtoList = this.appDatabase.produtoDAORoom().getAllProducts();
        if(produtoList.size() > 0){
            this.listMutableLiveData.postValue(produtoList);
        }else{
            this.listMutableLiveData.postValue(null);
        }
    }

    public void insertProduct(ProdutoEntity produtoEntity){
        this.appDatabase.produtoDAORoom().insertProduct(produtoEntity);
        getAllProducts();
    }

    public void updateProduct(ProdutoEntity produtoEntity){
        this.appDatabase.produtoDAORoom().updateProduct(produtoEntity);
        getAllProducts();
    }

    public void deleteProduct(ProdutoEntity produtoEntity){
        this.appDatabase.produtoDAORoom().deleteProduct(produtoEntity);
        getAllProducts();
    }

}
