package model;

import java.util.ArrayList;
import java.util.List;

class Inventario {
    private int idCliente;
    private String status;
    private List<String> itens;

    public Inventario(int idCliente, String status) {
        this.idCliente = idCliente;
        this.status = status;
        this.itens = new ArrayList<>();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getItens() {
        return itens;
    }

    public void adicionarItem(String item) {
        itens.add(item);
    }

    public void removerItem(String item) {
        itens.remove(item);
    }
}

