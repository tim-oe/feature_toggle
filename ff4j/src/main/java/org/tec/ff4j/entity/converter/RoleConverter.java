package org.tec.ff4j.entity.converter;

import org.tec.ff4j.auth.Role;

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
