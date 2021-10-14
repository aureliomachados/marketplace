package br.com.gubee.marketplace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue()
    private Long id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    private String targetMarket;
    private String technology;
}
