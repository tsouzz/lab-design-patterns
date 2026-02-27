package br.com.dio.lab_design_patterns.repository;

import br.com.dio.lab_design_patterns.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}
