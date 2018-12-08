import spock.lang.Specification

class ISBN10Test extends Specification {

    def "the ISBN10 3-8171-2004-4 has the checksum 4"() {
        expect:
        ISBN10.checksum("3-8171-2004-4") == '4'
    }

    def "the ISBN10 1-55860-491 has the checksum X"() {
        expect:
        ISBN10.checksum("1-55860-491") == 'X'
    }
}


