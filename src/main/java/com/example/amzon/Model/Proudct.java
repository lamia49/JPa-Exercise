package com.example.amzon.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Table(name = "prodectss")
@Entity
@NoArgsConstructor
public class Proudct {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "id must be not empty")
    @Size(min = 3,message = "must be mor then 3 ")
    @Column(columnDefinition ="varchar(10) not null check(length(name) > 4)")
    private String name;
    @Positive
    @NotNull(message = "price must be not empty")
    @Column(columnDefinition = "int not null")
    private double price;
    @NotNull(message = " Category ID must be not empty ")
    @Column(columnDefinition ="int not null")
    private Integer categoryID;

}
