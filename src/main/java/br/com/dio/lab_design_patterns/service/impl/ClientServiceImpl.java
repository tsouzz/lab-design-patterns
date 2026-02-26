package br.com.dio.lab_design_patterns.service.impl;

import br.com.dio.lab_design_patterns.model.Address;
import br.com.dio.lab_design_patterns.model.AddressRepository;
import br.com.dio.lab_design_patterns.model.Client;
import br.com.dio.lab_design_patterns.model.ClientRepository;
import br.com.dio.lab_design_patterns.service.ClientService;
import br.com.dio.lab_design_patterns.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        return clientOptional.get();
    }

    @Override
    public void insert(Client client) {
        saveClientWithCep(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            saveClientWithCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public void saveClientWithCep(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(Long.valueOf(cep)).orElseGet(() -> {
            Address newAddress = viaCepService.findCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }

}
