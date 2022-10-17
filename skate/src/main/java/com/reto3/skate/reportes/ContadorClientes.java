package com.reto3.skate.reportes;

import com.reto3.skate.model.Client;

public class ContadorClientes {
    private Long total;
    private Client client;

    public ContadorClientes(Long total, Client client){
        this.total= total;
        this.client= client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
