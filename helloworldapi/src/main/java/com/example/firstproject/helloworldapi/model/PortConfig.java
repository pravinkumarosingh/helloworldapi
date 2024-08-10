package com.example.firstproject.helloworldapi.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "port_config")
public class PortConfig {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "port_no")
    private int portNo;

    @Column(name = "status")
    private String status;

}
