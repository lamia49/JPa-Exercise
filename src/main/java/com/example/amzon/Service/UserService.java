package com.example.amzon.Service;

import com.example.amzon.Model.Merchant;
import com.example.amzon.Model.MerchantStock;
import com.example.amzon.Model.Proudct;
import com.example.amzon.Model.User;
import com.example.amzon.Repostry.RepositryMerchent;
import com.example.amzon.Repostry.RepositryProudect;
import com.example.amzon.Repostry.RepositryStock;
import com.example.amzon.Repostry.RepositryUser;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class UserService {
    private final RepositryStock repositryStock;
    private final RepositryProudect repositryProudect;
    private final RepositryMerchent repositryMerchent;
    private final RepositryUser repositryUser;

    public void add(User user) {

       repositryUser.save(user);
    }

    public List get() {

        return repositryUser.findAll();
    }

    public boolean update(int id, User user) {
     User user1=repositryUser.getById(id);
     if(user1==null){
         return false;
     }
     user1.setUsername(user.getUsername());
        return true;
    }

    public boolean delete(int id) {
       User user=repositryUser.getById(id);
       if(user==null) {
           return false;
       }
       repositryUser.delete(user);
       return true;
    }


    public boolean addToStock(int idStock, int ProudectId, int amount) {
      MerchantStock stock=repositryStock.getById(idStock);
     Proudct proudct=repositryProudect.getById(ProudectId);
            if (stock !=null) {
                    if (proudct !=null) {
                        int addStock = stock.getStock()+amount;
                      stock.setStock(addStock);
                      repositryStock.save(stock);
                        return true;
                    }
                }
        return false;
    }

    public boolean buy(int userID, int ProudectId, int  idStock ,int MerchentId) {
        User user = repositryUser.getById(userID);
        MerchantStock stock = repositryStock.getById(idStock);
        Proudct proudct = repositryProudect.getById(ProudectId);
        Merchant merchant = repositryMerchent.getById(MerchentId);
        if (user!=null) {
            if (stock!=null) {
                if (proudct!=null) {
                    if (proudct.getPrice() <= user.getBalance()) {
                        int pay = stock.getStock() - 1;
                        stock.setStock(pay);
                        if (merchant!=null) {
                            int count = merchant.getNumberOfPurchases() + 1;
                            merchant.setNumberOfPurchases(count);
                            double reduceBalance = user.getBalance() - proudct.getPrice();
                            user.setBalance(reduceBalance);
                            repositryUser.save(user);
                            repositryStock.save(stock);
                            repositryMerchent.save(merchant);
                            return true;
                        }
                    }
                }}
                return false;
            }
            return false;
        }


    public boolean refund(int userId1,int proudctId){
        User user= repositryUser.getById(userId1);
        Proudct proudct=repositryProudect.getById(proudctId);
            if(user!=null)
                if(proudct!=null){
                  double amount=proudct.getPrice()+user.getBalance();
                  user.setBalance(amount);
                  repositryUser.save(user);
                  return true;
                }
        return false;
    }

    public boolean discount(int userID, int ProudectId,double discount) {
     User user=repositryUser.getById(userID);
     Proudct proudct=repositryProudect.getById(ProudectId);
            if (user.getRole().equalsIgnoreCase("Admin")) {
                    if (proudct!=null) {
                        double offers =proudct.getPrice() - proudct.getPrice() * discount;
                        proudct.setPrice(offers);
                        repositryProudect.save(proudct);
                        return true;
                    }
                }
        return false;
    }
}