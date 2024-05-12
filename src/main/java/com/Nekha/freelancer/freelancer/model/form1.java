package com.Nekha.freelancer.freelancer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "form1")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class form1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String title;
    private String location;
    private String status;
    private String bio;
    @Column(unique =   true)
    private int userId;

}
