package com.foodfinder.foodfinderapi.drinks.domain.model.aggregates;

import com.foodfinder.foodfinderapi.drinks.domain.model.commands.CreateDrinkCommand;
import com.foodfinder.foodfinderapi.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Drink extends AbstractAggregateRoot<Drink> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    private String drinkName;

    @Column(nullable = false)
    @Getter
    private String drinkDescription;

    @Column(nullable = false)
    @Getter
    private double price;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    @Getter
    private Date createAt;

    @LastModifiedDate
    @Column(nullable = false)
    @Getter
    private Date updatedAt;

    protected Drink() {

    }
   /*public Drink() {
        this.drinkName= Strings.EMPTY;
        this.drinkDescription= Strings.EMPTY;
        this.price= Double.NaN;
    }

    public Drink(String drinkName,String drinkDescription ,double price) {
        this();
        this.drinkDescription= drinkDescription;
        this.drinkName= drinkName;
        this.price= price;
    }

    public Drink updateInformation(String drinkName,String drinkDescription ,double price) {
        this.drinkDescription= drinkDescription;
        this.drinkName= drinkName;
        this.price= price;
        return this;
    }*/

    public Drink(CreateDrinkCommand command) {
        this.drinkName= command.drinkName();
        this.drinkDescription= command.drinkDescription();
        this.price= command.price();
    }
}
