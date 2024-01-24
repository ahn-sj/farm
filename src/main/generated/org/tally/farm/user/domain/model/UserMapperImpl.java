package org.tally.farm.user.domain.model;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.tally.farm.user.dto.UserRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-21T01:13:48+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Homebrew)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserCommand toUserCommand(UserRequest.JoinUserRequest request) {
        if ( request == null ) {
            return null;
        }

        String email = null;
        String password = null;
        String name = null;
        String nickname = null;
        String providerId = null;
        String phoneNumber = null;
        LocalDate birthday = null;
        String address1 = null;
        String address2 = null;

        email = request.email();
        password = request.password();
        name = request.name();
        nickname = request.nickname();
        providerId = request.providerId();
        phoneNumber = request.phoneNumber();
        birthday = request.birthday();
        address1 = request.address1();
        address2 = request.address2();

        UserCommand userCommand = new UserCommand( email, password, name, nickname, providerId, phoneNumber, birthday, address1, address2 );

        return userCommand;
    }
}
