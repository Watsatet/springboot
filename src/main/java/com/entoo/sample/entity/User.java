package com.entoo.sample.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Document
@Getter
@Data
public class User
{
//    @Id
//    @Field(targetType = FieldType.OBJECT_ID)
//    private int id;
    @Id
    private String id;

    @NotBlank
    @Size(min = 2, max = 30)
    private String name;

    @NotBlank
    @Email(message = "invalid email")
    private String email;

    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid phone number")
    private String phone;
}
