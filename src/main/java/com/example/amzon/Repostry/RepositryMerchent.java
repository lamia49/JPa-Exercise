package com.example.amzon.Repostry;

import com.example.amzon.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositryMerchent extends JpaRepository<Merchant , Integer> {
}
