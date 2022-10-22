package omg.wentwrong;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner();

        List<Scanner.Token> tokens = scanner.getTokens("var a = 1 + 2");

        for (var token : tokens) {
            System.out.println(token);
        }
    }
}
