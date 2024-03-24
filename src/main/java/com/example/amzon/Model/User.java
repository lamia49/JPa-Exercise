package com.example.amzon.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
@NotEmpty(message = "username must be not empty")
@Size(min = 6,message = "user name must be mor then 5")
@Column(columnDefinition ="varchar(15) check (length(username) > 7) not null")
    private String  username;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d).{7,}$" , message = "password only digits and charcters , and must be mor then 6")
    @Column(columnDefinition ="varchar(20) not null check(length(password)>6)")
    private String password;
    @Email(message ="must be valid email ")
    @Column(columnDefinition =" varchar(50) UNIQUE ")
    private String email;
    @NotEmpty(message = "role must be not null")
    @Pattern(regexp ="^(Admin|Customer)$",message = "role must be admin or customer")
    @Column(columnDefinition = "varchar(10) check(role ='Admin' or role='Customer' )")
    private String role;
    @NotNull(message = "balance must be not empty")
    @Positive(message = "balance must be only postive number")
    @Column(columnDefinition = "int default 0 check( balance>0 ) not null")
    private double balance;

}
