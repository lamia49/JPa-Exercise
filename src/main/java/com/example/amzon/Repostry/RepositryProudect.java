package com.example.amzon.Repostry;

import com.example.amzon.Model.Proudct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositryProudect extends JpaRepository<Proudct,Integer> {
}
