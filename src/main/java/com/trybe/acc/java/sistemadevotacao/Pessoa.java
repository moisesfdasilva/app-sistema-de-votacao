package com.trybe.acc.java.sistemadevotacao;

public abstract class Pessoa {
  protected String nome;
  
  public Pessoa(String nome) {
    super();
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
