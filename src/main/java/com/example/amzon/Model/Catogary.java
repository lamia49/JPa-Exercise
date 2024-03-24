package com.example.amzon.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Catogary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
@NotEmpty(message = "name must be not empty")
@Size(min = 3, message = "name must have more then 3")
@Column(columnDefinition ="varchar(10) not null check (length(name)>4)")
    private String name;
}
