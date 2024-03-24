package com.example.amzon.Service;

import com.example.amzon.Model.Merchant;
import com.example.amzon.Model.MerchantStock;
import com.example.amzon.Repostry.RepositryMerchent;
import com.example.amzon.Repostry.RepositryStock;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MerchantStockService {
    private final RepositryMerchent repositryMerchent;
    private final RepositryStock repositryStock;

    public void add(MerchantStock stock)
    {

        repositryStock.save(stock);
    }

    public List get(){

        return repositryStock.findAll();
    }

    public boolean update(int id,int MerchentId , MerchantStock stock1){
      MerchantStock stock= repositryStock.getById(id);
        Merchant merchant=repositryMerchent.getById(MerchentId);
       if(stock==null ||merchant==null) {
           return false;
       }
       repositryStock.delete(stock1);
       return true;
    }
    public boolean delete(int id){
    MerchantStock stock=repositryStock.getById(id);
    if(stock==null){
        return false;
    }
        return true;
    }


}
