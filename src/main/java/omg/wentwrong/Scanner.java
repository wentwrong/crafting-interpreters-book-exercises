package omg.wentwrong;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;

public class Scanner {
    @EqualsAndHashCode
    public static class Token {
        final TokenType tokenType;
        final Object value;

        public Token(TokenType tokenType, Object value) {
            this.tokenType = tokenType;
            this.value = value;
        }

        public Token(TokenType tokenType) {
            this(tokenType, null);
        }

        @Override
        public String toString() {
            return "Token{" +
                    "tokenType=" + tokenType +
                    ", value=" + value +
                    '}';
        }
    }

    public List<Token> getTokens(String input) {
        var line = 0;
        var tokens = new ArrayList<Token>();
        for (var i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case ' ':
                    break;
                case '=':
                    tokens.add(new Token(TokenType.EQUAL));
                    break;
                case '+':
                    tokens.add(new Token(TokenType.PLUS));
                    break;
                case '\n':
                    line++;
                    break;
                default:
                    if (Character.isDigit(ch)) {
                        var j = i + 1;
                        while (j < input.length()) {
                            if (!Character.isDigit(input.charAt(j))) {
                                break;
                            }
                            j += 1;
                        }
                        var number = Integer.parseInt(input.substring(i, j));
                        i = j;
                        tokens.add(new Token(TokenType.INT_NUMBER, number));
                    } else if (Character.isAlphabetic(ch)) {
                        var j = i + 1;
                        while (j < input.length()) {
                            if (!Character.isAlphabetic(input.charAt(j))) {
                                break;
                            }
                            j += 1;
                        }
                        var string = input.substring(i, j);
                        i = j;
                        if (string.equals("var")) {
                            tokens.add(new Token(TokenType.VAR));
                            continue;
                        }
                        tokens.add(new Token(TokenType.VAR_NAME, string));
                    } else {
                        reportError(String.format("Found unknown character: '%c'", ch), i, line);
                    }
            }
        }
        tokens.add(new Token(TokenType.EOF));
        return tokens;
    }

    private void reportError(String message, int column, int line) {
        System.out.printf("Error while scanning [%d:%d]:\n%s\n", column, line, message);
    }
}
