import javax.script.ScriptException;

public class Print extends Operator {
    public Print(String code) {
        super(code); //вызов предка
    }

    @Override
    public void exec(Interpreter inte) {
        Object res = null;//вычисляет выражение в операторе

        inte.next(); //идет на следующую строчку
        String trim = code.trim();
        if (trim.startsWith("\"")){
            String quotedStr = trim.substring(1,trim.length() - 2);
            if (trim.endsWith(";")) {
                System.out.println(quotedStr);
            } else {
                System.out.println(quotedStr);
            }
            return;
        }

        try { //вывод результата на экран, если не олучислось разобрать строку, то мы печатаем исключение
            res = Expression.eval(inte.getVars(), code);
            System.out.println(res);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
