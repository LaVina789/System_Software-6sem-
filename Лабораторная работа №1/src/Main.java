import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException { //считывание из файла
        BufferedReader fr = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\Учёба\\6 семестр\\Системное ПО\\Лабораторные работы\\Лабораторная работа №1\\src\\quad.bas"));
        Interpreter interpreter = new Interpreter();
        while (true){
            String line = fr.readLine();
            if (line == null) break;
            interpreter.parse(line);
        }
        interpreter.run();
    }
}