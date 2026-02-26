package br.com.dio.lab_design_patterns.service;

import br.com.dio.lab_design_patterns.model.Client;

public interface ClientService {

    Iterable<Client> findAll();

    Client findById(Long id);

    void insert(Client client);

    void update(Long id, Client client);

    void delete(Long id);

}
