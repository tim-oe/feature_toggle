package org.tec.togglz.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.tec.togglz.auth.Role;
import org.tec.togglz.entity.converter.RoleConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class RoleEntity extends AbstractAuditEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", nullable = false)
    private UserEntity user;

    @Column(name="role", updatable=false, nullable=false)
    @Convert(converter = RoleConverter.class)
    private Role role;

    @Override
    public String toString() {
        return "RoleEntity{" +
                "user_id=" + user.getId() +
                ", role=" + role +
                "}\n"+ super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.
                reflectionEquals(this, obj, Arrays.asList("user"));
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, Arrays.asList("user"));
    }
}
