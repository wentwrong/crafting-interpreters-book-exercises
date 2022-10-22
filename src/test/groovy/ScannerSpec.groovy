import omg.wentwrong.Scanner
import omg.wentwrong.TokenType
import spock.lang.Specification

class ScannerSpec extends Specification {
    def scanner = new Scanner()

    def "getTokens"() {
        when:
        def tokens = scanner.getTokens("var a = 123")
        def expectedTokens = [
                new Scanner.Token(TokenType.VAR),
                new Scanner.Token(TokenType.VAR_NAME, "a"),
                new Scanner.Token(TokenType.EQUAL),
                new Scanner.Token(TokenType.INT_NUMBER, 123),
                new Scanner.Token(TokenType.EOF),
        ]
        then:
        tokens == expectedTokens
    }
}
