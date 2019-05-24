package jpacompositekeyonetoone.compositekey.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,AddressKey> {

}
