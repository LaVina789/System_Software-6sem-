import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        String input = "a = 10; b=(a+10)*a; for(i=-1; i<=10;i=i+1;) { a=(b+1)-3;}";
        LinkedList<Token> tokens = Lexer.lex(input);
        try {
            Parser.parse(tokens);
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
        LinkedList<Token> testPoliz = Poliz.makePoliz(tokens);
        int i = 0;
        for (Token token : testPoliz) {
            System.out.println(i + " " + token);
            i++;
        }
        PolizCalculation.calculate(testPoliz);

        MyLinkedList a = new MyLinkedList();
        a.add(7);
        a.add(5);
        a.remove(0);
        a.remove(0);
        System.out.println(a);
    }
}
