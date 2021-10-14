package br.com.gubee.marketplace.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue()
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    private Double price;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_market",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "market_id")}
    )
    private List<TargetMarket> targetMarkets;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_stack",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "stack_id")}
    )
    private List<Stack> stacks;
}
