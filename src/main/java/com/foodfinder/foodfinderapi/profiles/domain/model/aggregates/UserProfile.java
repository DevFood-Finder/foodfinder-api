package com.foodfinder.foodfinderapi.profiles.domain.model.aggregates;

import com.foodfinder.foodfinderapi.profiles.domain.model.commands.CreateUserProfileCommand;
import com.foodfinder.foodfinderapi.profiles.domain.model.valueobjects.*;
import com.foodfinder.foodfinderapi.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;

@Entity
public class UserProfile extends AuditableAbstractAggregateRoot<UserProfile> {

    @Embedded
    private UserName user;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "email_address"))
    })
    private EmailAddress email;


    public UserProfile(String firstName, String lastName, String email) {
        this.user= new UserName(firstName, lastName);
        this.email = new EmailAddress(email);
    }

    public UserProfile(CreateUserProfileCommand command) {
        this.user = new UserName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
    }

    public UserProfile() {

    }

    public void updateUser(String firstName, String lastName) {
        this.user = new UserName(firstName, lastName);
    }

    public void updateEmail(String email) {
        this.email = new EmailAddress(email);
    }


    public String FullName() { return user.getFullName(); }
    public String getEmailAddress() { return email.address(); }
}
