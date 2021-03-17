package joao_sousa_tp2e3;

public class People {
    protected String name;
    protected String surname;
    protected String lastName;

    public People(String fullName){
        try{
            int firstName = fullName.indexOf(" ");
            name = fullName.substring(0, firstName);
            int secondName = fullName.indexOf(" ", firstName + 1);
            surname = fullName.substring(firstName, secondName);
            lastName = fullName.substring(secondName);
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Erro no cadastro do nome.");
            System.out.println(e.getMessage());
            name = "Desconhecido";
        }
    }

    public String finalResult() throws SystemException {
        return "Nome: " + name;
    }
}
