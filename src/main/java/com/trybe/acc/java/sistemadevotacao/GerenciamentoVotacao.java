package com.trybe.acc.java.sistemadevotacao;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos = 0;

  /** método cadastrar pessoa candidata. */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    boolean numeroExistente = false;
    PessoaCandidata newPessoaCandidata = new PessoaCandidata(nome, numero);

    for (PessoaCandidata candidato: pessoasCandidatas) {
      if (candidato.getNumero() == numero) {
        numeroExistente = true;
      }
    }

    if (numeroExistente == true) {
      System.out.println("Número pessoa candidata já utilizado!");      
    } else {
      pessoasCandidatas.add(newPessoaCandidata);
    }
  }

  /** método cadastrar pessoa eleitora. */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean cpfExistente = false;
    PessoaEleitora newPessoaEleitora = new PessoaEleitora(nome, cpf);

    for (PessoaEleitora eleitor: pessoasEleitoras) {
      if (eleitor.getCpf().equalsIgnoreCase(cpf)) {
        cpfExistente = true;
      }
    }

    if (cpfExistente == true) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      pessoasEleitoras.add(newPessoaEleitora);
    }
  }

  /** método votar. */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    boolean cpfExistente = false;
    
    for (String cpf: cpfComputado) {
      if (cpf.equalsIgnoreCase(cpfPessoaEleitora)) {
        cpfExistente = true;
      }
    }

    if (cpfExistente == true) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      for (PessoaCandidata candidato: pessoasCandidatas) {
        if (candidato.getNumero() == numeroPessoaCandidata) {
          candidato.receberVoto();
        }
      }
      cpfComputado.add(cpfPessoaEleitora);
      totalVotos += 1;
    }
  }

  /** método mostrar resultado. */
  public void mostrarResultado() {
    DecimalFormat percent = new DecimalFormat("0.0#%");

    if (totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");      
    } else {
      // this.pessoasCandidatas.sort(PessoaCandidata.votos);
      for (PessoaCandidata candidato: pessoasCandidatas) {
        double percentualDeVotos = calcularPorcentagemVotos(candidato.getVotos());

        System.out.println(
            "Nome: " + candidato.getNome() + " - " + candidato.getVotos()
            + " votos (" + percent.format(percentualDeVotos) + ")"
        );
      }
      System.out.println("Total de votos: " + totalVotos);
    }
  }

  private double calcularPorcentagemVotos(int votos) {
    float percentualDeVotos = (float) votos / totalVotos;
    return percentualDeVotos;
  }
}
