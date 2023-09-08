package model;

class Conta {
    private int idConta;
    Cliente nomeCliente;
    private double total;

    public Conta(int idConta, Cliente nomeCliente) {
        this.idConta = idConta;
        this.nomeCliente = nomeCliente;
        this.total = 0.0;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public Cliente getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(Cliente nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void adicionarDespesa(double valor) {
        total += valor;
    }

    public void imprimirFatura() {
        System.out.println("Fatura para o cliente: " + nomeCliente);
        System.out.println("Total a pagar: $" + total);
    }
}
