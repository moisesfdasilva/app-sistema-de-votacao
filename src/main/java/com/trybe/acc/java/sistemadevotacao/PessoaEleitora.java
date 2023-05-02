package com.trybe.acc.java.sistemadevotacao;

public class PessoaEleitora extends Pessoa {
  private String cpf;

  public PessoaEleitora(String nome, String cpf) {
    super(nome);
    this.cpf = cpf;
  }

  public String getNome() {
    return super.getNome();
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setNome(String nome) {
    super.setNome(nome);
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
