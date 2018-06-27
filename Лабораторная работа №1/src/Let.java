import javax.script.ScriptException;

public class Let extends Operator {
    public Let(String code) {
        super(code);
    }

    @Override
    public void exec(Interpreter inte) {
        String[] parts = code.split("="); //делим строку
        try {
            Object val = Expression.eval(inte.getVars(),parts[1]); // решение выражение
            inte.getVars().put(parts[0].trim(),Double.parseDouble(val.toString())); //переприсвоение переменной
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        inte.next();
    }
}
