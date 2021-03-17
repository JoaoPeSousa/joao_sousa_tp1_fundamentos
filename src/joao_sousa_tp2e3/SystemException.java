package joao_sousa_tp2e3;

public class SystemException extends Exception {
    private String msgError = "";
    public SystemException(String msg){
        super(msg);
        if ("nomeInvalido".equals(msg)) {
            msgError = "Input de nome inválido, tente novamente";
        } else if ("erroPosition".equals(msg)) {
            msgError = "Insira uma posição de aluno(a)/professor que seja existente.";
        } else if ("invalidGrade".equals(msg)) {
           msgError = "Desculpe, as notas do(a) aluno(a) não foram adicionadas.";
        } else if ("invalidSalary".equals(msg)) {
            msgError = "Salário precisa ser informado! Tente novamente!";
        } else if ("noGrades".equals(msg)) {
            msgError = "Você precisa informar as notas do aluno(a)!";
        }
    }

    SystemException() {
        msgError = "Erro desconhecido";
    }

    @Override
    public String getMessage() {
        return msgError;
    }
}
