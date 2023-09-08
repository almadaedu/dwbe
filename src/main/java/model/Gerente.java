package model;

class Gerente extends Pessoa {
    private int idGerente;
    private double salario;

    public Gerente(int idPessoa, int idade, String nome, String telefone, String cpf, String rg, String nacionalidade, int idGerente, double salario) {
        super(idPessoa, idade, nome, telefone, cpf, rg, nacionalidade);
        this.idGerente = idGerente;
        this.salario = salario;
    }
    public int getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void ComprarInventario(Inventario inventario, String item) {

        inventario.adicionarItem(item);
    }

    public void Gerenciar(Recepcionista recepcionista) {

    }
}
