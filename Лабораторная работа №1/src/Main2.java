import java.util.Scanner;

public class Main2 {
    public static void main(String args[]) { //ввод в консоль
        Scanner s  = new Scanner(System.in);
        Interpreter interpreter = new Interpreter();
        while (true){
            String line = s.nextLine();
            interpreter.parse(line);
        }
    }
}
