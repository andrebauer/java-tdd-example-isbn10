import spock.lang.Specification
import spock.lang.Unroll

class ISBN10Test extends Specification {

    @Unroll
    def "the ISBN10 #isbn has the check digit #digit."() {
        expect:
        ISBN10.checkDigit(isbn) == digit

        where:
        isbn            | digit
        "3-8171-2004"   | '4'
        "1-55860-491"   | 'X'
        "3-89721-204"   | '8'
        "3-89721-222"   | '6'
        "3-89721-226"   | '9'
        "0-00-433454"   | 'X'
        "3-519-02137"   | '4'
    }

    @Unroll
    def "preserveNumbers(#s) should return #expected"() {
        expect:
        ISBN10.preserveNumbers(s) == expected

        where:
        s              | expected
        "as244-2973"   | "2442973"
        "29-3-283-433" | "293283433"
    }

    @Unroll
    def "toIntArray should transform the String #s to the IntArray #a."() {
        expect:
        ISBN10.toIntArray(s) == a

        where:
        s                 | a
        "Af4-23.fa-245-7" | [4,2,3,2,4,5,7]
        "345-948-12346-3" | [3,4,5,9,4,8,1,2,3,4,6,3]
    }
}


