package typicode.base

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import spock.lang.Specification

class RestAssuredSetupBase extends Specification {

    static RequestSpecification request
    static RestAssured          rest         = new RestAssured()
    def static                  propUsername = System.getProperty('api.username')
    def static                  propPassword = System.getProperty('api.password')
    def static                  propBaseUri  = System.getProperty('api.baseURI')

    /**
     * Sets up spec configurations for test run
     * References:
     * https://github.com/rest-assured/rest-assured/wiki/Usage#default-values
     **/
    void setupSpec() {
        try {
            rest.baseURI = propBaseUri
            request = rest.given()
                          .contentType(ContentType.JSON)

        } catch (Exception ex) {
            throw new RuntimeException("Failed to setup api", ex)
        }
    }

}
