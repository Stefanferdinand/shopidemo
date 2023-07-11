package com.example.shopi.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "USER_TABLE")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private Integer age;
    private String password;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
