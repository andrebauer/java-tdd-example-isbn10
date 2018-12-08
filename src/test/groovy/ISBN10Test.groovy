import spock.lang.Specification

class ISBN10Test extends Specification {

    def "the ISBN10 #isbn has the check digit #digit."() {
        expect:
        ISBN10.checkDigit(isbn) == digit

        where:
        isbn            | digit
        "3-8171-2004-4" | '4'
        "1-55860-491"   | 'X'
    }
}


