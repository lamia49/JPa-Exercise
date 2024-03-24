package com.example.amzon.Service;

import com.example.amzon.Model.Catogary;
import com.example.amzon.Repostry.RebositryCatogary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CatogaryService {
    private final RebositryCatogary rebositryCatogary;
    public void adding(Catogary catogary){
        rebositryCatogary.save(catogary);
    }
    public List<Catogary>getting(){
        return rebositryCatogary.findAll() ;
    }
    public boolean update(int id , Catogary catogary){
        Catogary catogary1 = rebositryCatogary.getById(id);
         if(catogary1==null){
             return false;
        }
         catogary1.setName(catogary.getName());
        return true;
    }

    public boolean delete(int id){
        Catogary catogary=rebositryCatogary.getById(id);
        if(catogary==null){
            return false;
        }
        rebositryCatogary.deleteById(id);
        return true;
    }
}
