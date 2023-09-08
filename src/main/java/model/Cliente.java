package model;

class Cliente extends Pessoa {
    private int idCliente;
    private String status;

    public Cliente(int idPessoa, int idade, String nome, String telefone, String cpf, String rg, String nacionalidade, int idCliente) {
        super(idPessoa, idade, nome, telefone, cpf, rg, nacionalidade);
        this.idCliente = idCliente;
        this.status = "Ativo";
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

    public void CheckIn(Quarto quarto, String dataEntrada, String dataSaida) {

    }

    public void CheckOut(Quarto quarto, String dataSaida) {

    }

    public void PagarConta(Conta conta) {

    }

}





