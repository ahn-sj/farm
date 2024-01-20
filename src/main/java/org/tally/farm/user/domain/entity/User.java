package org.tally.farm.user.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.tally.farm.global.BaseEntity;
import org.tally.farm.user.domain.model.UserCommand;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String phoneNumber;
    private LocalDate birthday;
    private String address1;
    private String address2;
    private String providerId;

    public User(final UserCommand command) {
        this.email = command.email();
        this.password = command.password();
        this.name = command.name();
        this.nickname = command.nickname();
        this.phoneNumber = command.phoneNumber();
        this.birthday = command.birthday();
        this.address1 = command.address1();
        this.address2 = command.address2();
        this.providerId = command.providerId();
    }
}
