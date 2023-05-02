package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

public class Principal {
  /** método principal. */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciamento = new GerenciamentoVotacao();

    short inputCadastrarCandidato = 0;

    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      inputCadastrarCandidato = scanner.nextShort();

      if (inputCadastrarCandidato != 1 && inputCadastrarCandidato != 2) {
        System.out.println("Entre com uma opção válida!");
      } else if (inputCadastrarCandidato == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String inputNomeDoCandidato = scanner.next();

        System.out.println("Entre com o número da pessoa candidata:");
        int inputNumeroDoCandidato = scanner.nextInt();

        gerenciamento.cadastrarPessoaCandidata(inputNomeDoCandidato, inputNumeroDoCandidato);
      }
    } while (inputCadastrarCandidato != 2);

    short inputCadastrarEleitor = 0;

    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      inputCadastrarEleitor = scanner.nextShort();

      if (inputCadastrarEleitor != 1 && inputCadastrarEleitor != 2) {
        System.out.println("Entre com uma opção válida!");
      } else if (inputCadastrarEleitor == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String inputNomeDoEleitor = scanner.next();

        System.out.println("Entre com o cpf da pessoa eleitora:");
        String inputCpfDoEleitor = scanner.next();

        gerenciamento.cadastrarPessoaEleitora(inputNomeDoEleitor, inputCpfDoEleitor);
      }
    } while (inputCadastrarEleitor != 2);

    short inputVotacao = 0;

    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");

      inputVotacao = scanner.nextShort();

      if (inputVotacao != 1 && inputVotacao != 2 && inputVotacao != 3) {
        System.out.println("Entre com uma opção válida!");
      } else if (inputVotacao == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String inputCpfDoEleitor = scanner.next();
        
        System.out.println("Entre com o número da pessoa candidata:");
        int inputNumeroDoCandidato = scanner.nextInt();

        gerenciamento.votar(inputCpfDoEleitor, inputNumeroDoCandidato);
      } else if (inputVotacao == 2) {
        gerenciamento.mostrarResultado();
      }
    } while (inputVotacao != 3);
    
    gerenciamento.mostrarResultado();

    scanner.close();
  }
}
