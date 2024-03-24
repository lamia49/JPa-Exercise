package com.example.amzon.Repostry;

import com.example.amzon.Model.Catogary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RebositryCatogary extends JpaRepository<Catogary,Integer> {
}
