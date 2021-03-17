package joao_sousa_tp2e3;

public class Professor extends People {
    private final String subject;
    private final String campus;

    public Professor(String name) {
        super(name);
        subject = "Não disponível";
        campus = "Não disponível";
    }

    public Professor(String name, String subject, String campus){
        super(name);
        this.subject = subject;
        this.campus = campus;
    }

    @Override
    public String finalResult() throws SystemException {
        return String.format("Nome: %s\nDisciplina corrente: %s\nUnidade lecionada: %s", name + " " + surname + " " + lastName, subject, campus);
    }
}
