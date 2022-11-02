package org.example.model;

public class Carro {

    private Long id;
    private String placa;
    private String entrada;
    private String vaga;

    public Carro(Long id, String placa, String entrada, String vaga) {
        this.id = id;
        this.placa = placa;
        this.entrada = entrada;
        this.vaga = vaga;
    }

    public Carro(){
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getVaga() {
        return vaga;
    }

    public void setVaga(String vaga) {
        this.vaga = vaga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String toString(){
        System.out.println("Vaga: " + getVaga() + "Placa: " + getPlaca() + "Entrada: " + getEntrada());
        return null;
    }
}
