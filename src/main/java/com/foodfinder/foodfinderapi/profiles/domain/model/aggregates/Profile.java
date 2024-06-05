package com.foodfinder.foodfinderapi.profiles.domain.model.aggregates;

import com.foodfinder.foodfinderapi.profiles.domain.model.commands.CreateProfileCommand;
import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.OwnerName;
import com.foodfinder.foodfinderapi.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.RestaurantName;
import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.StreetAddress;
import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.EmailAddress;
import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.Categories;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    @Embedded
    private RestaurantName name;

    @Embedded
    private OwnerName owner;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "email_address"))
    })
    private EmailAddress email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "address_street")),
            @AttributeOverride(name = "number", column = @Column(name = "address_number")),
            @AttributeOverride(name = "city", column = @Column(name = "address_city")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "address_postal_code")),
            @AttributeOverride(name = "country", column = @Column(name = "address_country")),
    })
    private StreetAddress address;


    /*Todavia por verse, deberia tomar prestado de otra tabla Categoria, no implementado por ahora*/
    @ManyToMany
    private Set<Categories> categories;

    public Profile(String Name, String firstName, String lastName, String email, String street, String number,
                   String city, String postalCode, String country) {
        this.name = new RestaurantName(Name);
        this.owner= new OwnerName(firstName, lastName);
        this.email = new EmailAddress(email);
        this.address = new StreetAddress(street, number, city, postalCode, country);
    }

    public Profile(CreateProfileCommand command) {
        this.name = new RestaurantName(command.Name());
        this.owner = new OwnerName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        this.address = new StreetAddress(command.street(), command.number(),
                command.city(), command.postalCode(), command.country());
    }

    public Profile() {

    }

    public void updateName(String Name) {
        this.name = new RestaurantName(Name);
    }

    public void updateOwner(String firstName, String lastName) {
        this.owner = new OwnerName(firstName, lastName);
    }

    public void updateEmail(String email) {
        this.email = new EmailAddress(email);
    }

    public void updateAddress(String street, String number, String city, String postalCode,
                              String country) {
        this.address = new StreetAddress(street, number, city, postalCode, country);
    }


    public String RestaurantName() { return name.getFullName(); }
    public String FullName() { return owner.getFullName(); }
    public String getEmailAddress() { return email.address(); }
    public String getStreetAddress() { return address.getStreetAddress(); }
}
