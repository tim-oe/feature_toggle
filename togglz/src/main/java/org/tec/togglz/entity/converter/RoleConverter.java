package org.tec.togglz.entity.converter;


import org.tec.togglz.auth.Role;

import javax.persistence.AttributeConverter;

public class RoleConverter implements AttributeConverter<Role, String> {
    @Override
    public String convertToDatabaseColumn(Role attribute) {
        return attribute.toString();
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
        return Role.valueOf(dbData);
    }
}
