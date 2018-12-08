import spock.lang.Specification

class ISBN10Test extends Specification {

    def "the ISBN10 #isbn has the check digit #digit."() {
        expect:
        ISBN10.checkDigit(isbn) == digit

        where:
        isbn            | digit
        "3-8171-2004-4" | '4'
        "1-55860-491"   | 'X'
        "3-89721-204"   | '8'
        "3-89721-222"   | '6'
        "3-89721-226"   | '9'
        "0-00-433454"   | 'X'
        "3-519-02137"   | '4'
    }
}


