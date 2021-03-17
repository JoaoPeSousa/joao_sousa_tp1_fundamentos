package joao_sousa_tp2e3;

public class Student extends People {
    private float firstGrade = -1;
    private float secondGrade = -1;

    public Student(String name) {
        super(name);
    }

    public Student(String nome, float firstGrade, float secondGrade) {
        super(nome);
        this.firstGrade = firstGrade;
        this.secondGrade = secondGrade;
    }

    @Override
    public String finalResult() throws SystemException {
        if(firstGrade == -1 || secondGrade == -1){
            throw new SystemException("invalidGrade");
        }
        return String.format("Nome: %s\nPrimeira nota: %.2f\nSegunda nota: %.2f\nMedia final: %.2f", name + " " + surname + " " + lastName, firstGrade, secondGrade, (firstGrade + secondGrade) / 2);
    }
}
