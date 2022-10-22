import spock.lang.Specification
import omg.wentwrong.Scanner
import omg.wentwrong.TokenType

class ScannerSpec extends Specification {
    def scanner = new Scanner()

    def "getTokens"() {
        when:
        var tokens = scanner.getTokens("var a")
        then:
        tokens.size() == 2
        tokens[0] == new Scanner.Token(TokenType.VAR)
        tokens[1] == new Scanner.Token(TokenType.VAR_NAME)
    }
}
