package com.example.amzon.Repostry;

import com.example.amzon.Model.MerchantStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositryStock extends JpaRepository<MerchantStock,Integer> {
}
