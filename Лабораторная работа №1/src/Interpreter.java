import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Interpreter {
    private TreeMap<Integer, Operator> code = new TreeMap<Integer, Operator>(); //отображение пары значений по ключу номер строки лежит оператор
    private Map<String, Double> vars = new HashMap<String, Double >();
    private Integer curLine; //текущая строка

    public void next(){ //переход на следующую строку
        curLine = code.higherKey(curLine); //просмотр следующей строчки
    }

    public void goTo(int line){
        curLine = line; //присваиваем строку
    }

    public void run(){ //запуск программы в бесконечном цикле
        curLine = code.firstKey(); //перевод строчки на начало нашей программы
        while (true){
            Operator operator = code.get(curLine); //достаем из текущей строки оператор и его исполняем
            operator.exec(this); //передаем интерпретатор
            if (curLine == null) break;
        }
    }

    public void parse(String line){ //разбиваем строку
        if (line.equalsIgnoreCase("RUN")){ //запускаем программу
            this.run();
            return;
        }

        if (line.equalsIgnoreCase("LIST")){ //выводим на экран текущую программу
            for (int l:code.keySet()){
                System.out.println(l + " " + code.get(l)); //печатаем каждую строчку
            }
            return;
        }
        try {
            String parts[] = line.split(" ");//берем строчку которая пришла и разбиваем ее по пробелам
            int lineNumber = Integer.parseInt(parts[0]); //отделяем номер строки
            String opName = parts[1]; //определяем оператор
            Operator operator = OperatorFactory.createOperator(opName, line.substring(parts[0].length() +parts[1].length()+2)); //отправляем opName, а потом все остальное
            code.put(lineNumber,operator);
        } catch (RuntimeException e){
            System.err.println("Wrong operation!");
        }

    }


    public Map<String,Double> getVars() {
        return vars;
    }
}
