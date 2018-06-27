public class Try {

    public static void main(String[] args) {

        Lexer lexer = new Lexer("C:/Users/User/Desktop/Учёба/6 семестр/Системное ПО/Лабораторные работы/Лабораторная работа №2/input.txt");

        System.out.println("Lexical Analysis");
        System.out.println("-----------------");
        while (!lexer.isExausthed()) {
            System.out.printf("%-18s :  %s \n",lexer.currentLexema() , lexer.currentToken());
            lexer.moveAhead();
        }

        if (lexer.isSuccessful()) {
            System.out.println("Ok! :D");
        } else {
            System.out.println(lexer.errorMessage());
        }
    }
}