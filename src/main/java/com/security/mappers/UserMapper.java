package com.security.mappers;

import com.security.Entity.PermissionEntity;
import com.security.Entity.RoleEntity;
import com.security.Entity.User;
import com.security.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserMapper {
    public ResponseDto mapUserToResponseDTO(User user) {
        Set<String> permissionNames = user.getPermissions().stream()
                .map(PermissionEntity::getName)
                .collect(Collectors.toSet());

        return new ResponseDto(
                user.getUsername(),
                user.getEmail(),
                null,
                user.getRoles().stream().findFirst().map(RoleEntity::getName).orElse(null),
                permissionNames
        );
    }
}
