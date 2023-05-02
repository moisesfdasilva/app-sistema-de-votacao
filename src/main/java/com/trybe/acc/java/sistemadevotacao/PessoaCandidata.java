package com.trybe.acc.java.sistemadevotacao;

public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  /** método construtor. */
  public PessoaCandidata(String nome, int numero) {
    super(nome);
    this.numero = numero;
    this.votos = 0;
  }

  public String getNome() {
    return super.getNome();
  }

  public int getNumero() {
    return this.numero;
  }

  public int getVotos() {
    return this.votos;
  }

  public void setNome(String nome) {
    super.setNome(nome);
  }

  public void setNumero(int numero) {
    this.numero = numero;    
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }

  public void receberVoto() {
    this.votos += 1;
  }
}
