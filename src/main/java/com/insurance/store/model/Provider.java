package com.insurance.store.model;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "providers")
public class Provider extends BaseEntity {

    private String name;
    private String address;

    @OneToMany(mappedBy = "provider", fetch = FetchType.LAZY)
    private Set<Product> products;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Provider other = (Provider) obj;
        if ( id != null ) {
            return Objects.equals(id, other.id);
        }
        return Objects.equals(address, other.address) && Objects.equals(id, other.id)
                && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        if ( id != null ) {
            return Objects.hash(id);
        }
        return Objects.hash(address, id, name);
    }


}
