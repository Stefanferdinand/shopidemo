package com.example.shopi.log;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LOG")
@NoArgsConstructor
@ToString
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public String message;
    public String Module;
    public LocalDateTime createdAt;
}
