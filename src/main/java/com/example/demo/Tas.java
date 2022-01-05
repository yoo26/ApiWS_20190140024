/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author rioan
 */
@Entity
@Table(name="tas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tas {
    @Id
    private String idtas;
    private String merktas;
    private String nama;
    private String jenis;
    private int harga;
    private int stock;
}