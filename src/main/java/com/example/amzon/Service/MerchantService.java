package com.example.amzon.Service;

import com.example.amzon.Model.Merchant;
import com.example.amzon.Repostry.RepositryMerchent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MerchantService {

    private final RepositryMerchent repositryMerchent;

    public void add(Merchant merchant){

        repositryMerchent.save(merchant);
    }

    public List get(){
        return repositryMerchent.findAll();
    }

    public boolean update(int id , Merchant merchant){
      Merchant merchant1=repositryMerchent.getById(id);

      if(merchant1==null){
                return false;
      }

      merchant1.setName(merchant.getName());
        return true;

    }

    public boolean delete(int id){
        Merchant merchant= repositryMerchent.getById(id);
            if(merchant==null){
                repositryMerchent.delete(merchant);
                return true;
            }
        return false;
    }


}
