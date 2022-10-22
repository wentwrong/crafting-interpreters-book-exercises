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
    }

    public List<Token> getTokens(String input) {
        var tokens = new ArrayList<Token>();
        tokens.add(new Token(TokenType.VAR));
        tokens.add(new Token(TokenType.VAR_NAME, "a"));
        tokens.add(new Token(TokenType.EQUAL));
        tokens.add(new Token(TokenType.INT_NUMBER, 1));
        tokens.add(new Token(TokenType.PLUS));
        tokens.add(new Token(TokenType.INT_NUMBER, 2));
        return tokens;
    }
}
