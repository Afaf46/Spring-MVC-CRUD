package com.example.Spring_MVC_CRUD;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @NotNull(message = "required")
   @Size(min=1 , message = "required")
    private String firstName;
    @NotNull(message = "required")
    @Size(min=1 , message = "required")
    private  String lastName;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid email address")
    @NotNull(message = "required")
    @Size(min=1 , message = "required")
    private String email;

}
