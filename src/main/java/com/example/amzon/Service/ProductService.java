package com.example.amzon.Service;

import com.example.amzon.Model.Catogary;
import com.example.amzon.Model.Proudct;
import com.example.amzon.Model.User;
import com.example.amzon.Repostry.RebositryCatogary;
import com.example.amzon.Repostry.RepositryProudect;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {



    private final RepositryProudect repositryProudect;
    private final RebositryCatogary rebositryCatogary;

    public void adding(Proudct proudct) {

        repositryProudect.save(proudct);
    }

    public List getting() {

        return repositryProudect.findAll();
    }

    public boolean update(int id, int catogaryID, Proudct proudct) {
       Proudct proudct1=repositryProudect.getById(id);
        Catogary catogary= rebositryCatogary.getById(catogaryID);
       if(proudct1==null&&catogary==null){
           return false;
        }
       proudct1.setName(proudct.getName());
       proudct1.setPrice(proudct.getPrice());
        return true;
    }

    public boolean delete(int id) {
        Proudct proudct=repositryProudect.getById(id);
        if(proudct==null){
            return false;
        }
        repositryProudect.delete(proudct);
        return true;
    }



}




