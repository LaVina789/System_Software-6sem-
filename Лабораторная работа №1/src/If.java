import javax.script.ScriptException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class If extends Operator {
    public If(String code) {
        super(code);
    }

    @Override
    public void exec(Interpreter inte) {
        Pattern pattern = Pattern.compile("(.*) THEN GOTO (.*)");
        Matcher matcher = pattern.matcher(code);
        inte.next();
        if (!matcher.find()){
            System.err.println("Bad operator if");
        } else {
            String cond = matcher.group(1);
            int line = Integer.parseInt(matcher.group(2));

            try {
                Object res = Expression.eval(inte.getVars(), cond.replace("=","=="));
                if (res instanceof Boolean && res.equals(true)) {
                    inte.goTo(line); //идем на другую строку
                }
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }
    }
}
