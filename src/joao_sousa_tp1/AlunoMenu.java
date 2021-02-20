package joao_sousa_tp1;

import java.util.Scanner;

public class AlunoMenu {

    public static void main(String[] args) {
        String[] nomes = new String[100];
        float[] notasAV1 = new float[100];
        float[] notasAV2 = new float[100];
        int n = 0;
        int i = 0;
        String holder;
        try (Scanner sc = new Scanner(System.in)) {
            while (n != 4) {
                System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_\nSistema de notas do aluno\n-_-_-_-_-_-_-_-_-_-_-_-_\nOpçoes:\n");
                System.out.println("""
                        [1] Registrar as notas de um novo aluno.
                        [2] Consultar boletim de um aluno.
                        [3] Consultar notas da turma.
                        [4] Sair.""");
                System.out.println("Escolha uma das opçoes acima: ");

                try {
                    holder = sc.nextLine();
                    n = Integer.parseInt(holder);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                switch (n) {
                    case 1:
                        if (i >= 100) {
                            System.out.println("O limite máximo de alunos para registro foi alcançado.\t");
                        } else {
                            try {
                                System.out.println("Nome do aluno:\t");
                                nomes[i] = sc.nextLine();
                                System.out.println("Nota AV1:\t");
                                holder = sc.nextLine();
                                notasAV1[i] = Float.parseFloat(holder);
                                System.out.println("Nota AV2:\t");
                                holder = sc.nextLine();
                                notasAV2[i] = Float.parseFloat(holder);
                                i++;
                                System.out.println("Aluno cadastrado!");
                            } catch (Exception e) {
                                System.out.println("Erro - " + e.getMessage());
                            }
                        }
                        break;
                    case 2:
                        if (i == 0) {
                            System.out.println("Nenhum aluno foi registrado ainda.");
                        } else {
                            try {
                                System.out.println("Insira o codigo do aluno:");
                                holder = sc.nextLine();
                                int num = Integer.parseInt(holder);
                                if (num >= i) {
                                    System.out.println("O aluno com esse código não existe.");
                                } else {
                                    float media = (notasAV1[num] + notasAV2[num]) / 2;
                                    String resultadoFinal;
                                    if (media < 4) {
                                        resultadoFinal = "Reprovado";
                                    } else if (media < 7) {
                                        resultadoFinal = "Prova Final";
                                    } else {
                                        resultadoFinal = "Aprovado!";
                                    }
                                    System.out.printf("""
                                                    Nome do aluno: %s
                                                    Nota da AV1: %.2f
                                                    Nota da AV2: %.2f
                                                    Média final: %.2f
                                                    Situação: %s
                                                    """
                                            , nomes[num], notasAV1[num], notasAV2[num], media, resultadoFinal);
                                }
                            } catch (Exception e) {
                                System.out.println("Exception found: " + e.getMessage());
                            }
                        }
                        break;
                    case 3:
                        if (i == 0) {
                            System.out.println("Nenhum aluno cadastrado.");
                        } else {
                            for (int j = 0; j < i; j++) {
                                float media = (notasAV1[j] + notasAV2[j]) / 2;
                                String resultadoFinal;
                                if (media < 4) {
                                    resultadoFinal = "Reprovado";
                                } else if (media < 7) {
                                    resultadoFinal = "Prova Final";
                                } else {
                                    resultadoFinal = "Aprovado!";
                                }
                                System.out.printf("""
                                                Nome do aluno: %s
                                                Nota da AV1: %.2f
                                                Nota da AV2: %.2f
                                                Média final: %.2f
                                                Situação: %s
                                                """
                                        , nomes[j], notasAV1[j], notasAV2[j], media, resultadoFinal);
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Obrigado por usar o sistema de notas.");
                        break;
                    default:
                        System.out.println("Numero não é válido, tente novamente.");
                        break;
                }
            }
        }
    }

}