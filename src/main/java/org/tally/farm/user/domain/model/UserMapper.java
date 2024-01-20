package org.tally.farm.user.domain.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.tally.farm.user.dto.UserRequest;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // RequestDto -> MessageBodyDto 매핑
    UserCommand toUserCommand(UserRequest.JoinUserRequest request);
}
