package com.foodfinder.foodfinderapi.profiles.domain.model.aggregates;

import com.foodfinder.foodfinderapi.profiles.domain.model.commands.CreateUserProfileCommand;
import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.*;
import com.foodfinder.foodfinderapi.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;

@Entity
public class UserProfile extends AuditableAbstractAggregateRoot<UserProfile> {

    @Embedded
    private RestaurantName name;

    @Embedded
    private UserName user;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "email_address"))
    })
    private EmailAddress email;


    public UserProfile(String Name, String firstName, String lastName, String email) {
        this.name = new RestaurantName(Name);
        this.user= new UserName(firstName, lastName);
        this.email = new EmailAddress(email);
    }

    public UserProfile(CreateUserProfileCommand command) {
        this.name = new RestaurantName(command.Name());
        this.user = new UserName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
    }

    public UserProfile() {

    }

    public void updateName(String Name) {
        this.name = new RestaurantName(Name);
    }

    public void updateOwner(String firstName, String lastName) {
        this.user = new UserName(firstName, lastName);
    }

    public void updateEmail(String email) {
        this.email = new EmailAddress(email);
    }



    public String RestaurantName() { return name.getFullName(); }
    public String FullName() { return user.getFullName(); }
    public String getEmailAddress() { return email.address(); }
}
