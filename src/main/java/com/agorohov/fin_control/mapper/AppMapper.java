package com.agorohov.fin_control.mapper;

import com.agorohov.fin_control.dto.Register;
import com.agorohov.fin_control.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Mapper(componentModel = "spring", imports = {Instant.class, LocalDateTime.class, ZoneId.class})
public interface AppMapper {

    // TODO поля одинаковые, можно и убрать аннотации
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "role", target = "role")
    UserEntity registerToUserEntity(Register register);
}
