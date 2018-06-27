abstract public class Operator {
    String code;

    public Operator(String code){ //конструктор
        this.code = code;
    }

    abstract public void exec(Interpreter inte); //можем выполнить этот оператор

    @Override
    public String toString() {
        return getClass().getName().toUpperCase() + " " + code;
    }
}
