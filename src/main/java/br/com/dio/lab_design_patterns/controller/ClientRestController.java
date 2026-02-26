package br.com.dio.lab_design_patterns.controller;

import br.com.dio.lab_design_patterns.model.Client;
import br.com.dio.lab_design_patterns.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClientRestController {
    public static class ClientController {

        @Autowired
        private ClientService clientService;

        @GetMapping
        public ResponseEntity<Iterable<Client>> findAll() {
            return ResponseEntity.ok(clientService.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Client> findById(@PathVariable Long id) {
            return ResponseEntity.ok(clientService.findById(id));
        }

        @PostMapping
        public ResponseEntity<Client> insert(@RequestBody Client client) {
            clientService.insert(client);
            return ResponseEntity.ok(client);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
            clientService.update(id, client);
            return ResponseEntity.ok(client);
        }

        @DeleteMapping
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            clientService.delete(id);
            return ResponseEntity.ok().build();
        }

    }
}
