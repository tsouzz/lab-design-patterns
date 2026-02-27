package br.com.dio.lab_design_patterns.repository;

import br.com.dio.lab_design_patterns.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {

}
