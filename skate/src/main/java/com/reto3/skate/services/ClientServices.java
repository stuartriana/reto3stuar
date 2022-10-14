package com.reto3.skate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto3.skate.model.Client;
import com.reto3.skate.repository.ClientRepository;

@Service
public class ClientServices {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClientAll() {
        return clientRepository.getClientAll();
    }

    public Optional<Client> getClientId(Integer id) {
        return clientRepository.getClientId(id);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> client1 = clientRepository.getClientId(client.getIdClient());
            if (client1.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> actu = clientRepository.getClientId(client.getIdClient());
            if (!actu.isEmpty()) {
                if (client.getName() != null) {
                    actu.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    actu.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    actu.get().setPassword(client.getPassword());
                }
                clientRepository.save(actu.get());
                return actu.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        boolean flag = false;
        Optional<Client> borrar = clientRepository.getClientId(clientId);
        if (borrar.isPresent()) {
            clientRepository.delete(borrar.get());
            flag = true;
        }
        return flag;
    }
}
