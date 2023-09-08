package model;

class Recepcionista extends Pessoa {
    private int idRecepcionista;
    private String horario;
    private double salario;

    public Recepcionista(int idPessoa, int idade, String nome, String telefone, String cpf, String rg, String nacionalidade, int idRecepcionista, String horario, double salario) {
        super(idPessoa, idade, nome, telefone, cpf, rg, nacionalidade);
        this.idRecepcionista = idRecepcionista;
        this.horario = horario;
        this.salario = salario;
    }

    public int getIdRecepcionista() {
        return idRecepcionista;
    }

    public void setIdRecepcionista(int idRecepcionista) {
        this.idRecepcionista = idRecepcionista;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean ChecarDisponibilidadeQuarto(Quarto quarto, String dataEntrada, String dataSaida) {
        return true;
    }

    public void AgendarQuarto(Cliente cliente, Quarto quarto, String dataEntrada, String dataSaida) {

    }


}
