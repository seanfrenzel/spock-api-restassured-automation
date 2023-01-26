package typicode.tests

import groovy.util.logging.Log4j2
import spock.lang.Unroll
import typicode.base.RestAssuredSetupBase

@Log4j2
class ExampleApiSpec extends RestAssuredSetupBase {

    def "Get Example"() {
        given: "Get Response"
        def response = request.get("posts")
        log.info("Printing Response")
        response.print()

        when: "Get Json Object"
        def jsonValue = response.jsonPath().getJsonObject("title[1]")
        log.info("Found Json Value: $jsonValue")

        then: "Value is correct"
        jsonValue == "qui est esse"
    }

    /**
     * this is just a simplified version of "Get Example" spec to show a different way to write the spec.
     * It is the exact same as "Get Example" just without logging, variable use, is only using the expect block
     */
    def "Get Example Simplified"() {
        expect: "Expected Json Value is Found"
        request.get("posts")
                .jsonPath()
                .getJsonObject("title[1]") == "qui est esse"
    }

    /**
     * This is "Get Example" but with a datatable. We are using params in this to show how a datable can be used to
     * execute multiple tests without the need of making another individual spec.
     * @param jsonObject JsonObject to find
     * @param assertValue Value in JsonObject to assert
     */
    @Unroll
    def "Get Example Spock DataTable -> #jsonObject == #assertValue"(String jsonObject, String assertValue) {
        expect: "Get Json Object #jsonObject"
        request.get("posts").jsonPath().getJsonObject(jsonObject) == assertValue

        where: "Value #assertValue is correct"
        jsonObject | assertValue
        "title[0]" | "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
        "title[1]" | "qui est esse"
        "title[2]" | "ea molestias quasi exercitationem repellat qui ipsa sit aut"
    }
}
