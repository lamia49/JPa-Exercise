package com.example.amzon.Repostry;

import com.example.amzon.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositryUser extends JpaRepository<User,Integer> {
}
