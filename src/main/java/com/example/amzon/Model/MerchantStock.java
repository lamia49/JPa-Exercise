package com.example.amzon.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class MerchantStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   @NotNull(message = " merchantid must be not empty")
   @Column(columnDefinition = "int not null")
    private Integer  merchantId;
    @NotNull(message = "Stock must be not empty")
    @Min(value = 10,message = "must be more then 10")
    @Column(columnDefinition = "int default 0")
    private Integer stock;


}
