package joao_sousa_tp2e3;

import java.util.Scanner;

public class Menu {
    private static final People[] people = new People[100];
    private static int i = 0;

    public static void main(String[] args) {
        try{
            Scanner sc;
            sc = new Scanner(System.in);
            String holder;
            int value;

            while(true){
                if(i >= 100){
                    System.out.println("Limite máximo de pessoas atingido, escolha a opção [3] ou [4];");
                }
                System.out.println("""
                        [1] Registrar professor.
                        [2] Registrar aluno.
                        [3] Consultar a situação do doscente/discente.
                        [4] Sair.""");
                System.out.println("Escolha uma das opçoes acima: ");
                holder = sc.nextLine();
                value = Integer.parseInt(holder);
                switch (value) {
                    case 1:
                        try{
                            addProfessor(sc);
                            break;
                        }catch(SystemException e){
                            System.out.println(e.getMessage());
                            break;
                        }
                    case 2:
                        try{
                            addAluno(sc);
                            break;
                        }catch(SystemException e){
                            System.out.println(e.getMessage());
                            break;
                        }
                    case 3:
                        finalResult(sc);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Nenhum dos numeros digitados, favor digitar novamente");
                        break;
                }
            }

        }catch(NumberFormatException | SystemException e){
            System.out.println("Erro, nenhum numero inserido. Terminando a execução.");
        }


    }

    private static void addAluno(Scanner sc) throws SystemException {
        if(i >= 100){
            System.out.println("O sistema atingiu o limite de registros.");
            return;
        }

        System.out.println("Digite o nome, sobrenome, e ultimo nome do aluno");
        String name = sc.nextLine();
        if(name.equals("")){
            throw new SystemException("nomeInvalido");
        }
        System.out.println("Primeira nota do aluno(a):");
        String firstGrade = sc.nextLine();
        System.out.println("Segunda nota do aluno(a):");
        String secondGrade = sc.nextLine();

        if(firstGrade.equals("") || secondGrade.equals("")){
            throw new SystemException("noGrades");
        }else{
            try{
                int firstGradeValue = Integer.parseInt(firstGrade);
                int secondGradeValue = Integer.parseInt(secondGrade);
                people[i] = new Student(name, firstGradeValue, secondGradeValue);
                i++;
                System.out.println("Aluno inserido na posição: " + i);
            }catch(NumberFormatException e){
                System.out.println("Erro na adição de notas!");
            }
            finally{
                System.out.println("Finalizando processo.");
            }
        }
    }

    private static void addProfessor(Scanner sc) throws SystemException {
        if(i >= 100){
            System.out.println("O sistema atingiu o limite de registros.");
            return;
        }

        System.out.println("Digite o nome, nome do meio, e ultimo nome do professor.");
        String name = sc.nextLine();
        if(name.equals("")){
            throw new SystemException("nomeInvalido");
        }
        System.out.println("Qual será a disciplina ensinada?");
        String subject = sc.nextLine();

        System.out.println("Em qual campus irá lecionar?");
        String campus = sc.nextLine();


        if(subject.equals("")){
            people[i] = new Professor(name);
            i++;
        }else{
            people[i] = new Professor(name, subject, campus);
            i++;
            System.out.println("Professor inserido na posição: " + i);
        }
    }


    private static void finalResult(Scanner sc) throws SystemException {
        System.out.println("Digite a posição do Aluno ou Professor que deseja consultar.");
        try{
            String holder = sc.nextLine();
            int num = Integer.parseInt(holder);
            System.out.println(people[num - 1].finalResult());
        }catch(Exception e){
           throw new SystemException("erroPosition");
        }
    }
}
