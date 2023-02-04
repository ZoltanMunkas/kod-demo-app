package com.kod.app.koddemoapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "exchange")
public class ExchangeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id")
    private CurrencyEntity from;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id")
    private CurrencyEntity to;

    @Column(name = "exchange")
    private double exchange;

}
