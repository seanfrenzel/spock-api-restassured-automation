package gfy.tests

import gfy.base.SpecBase
import gfy.pages.GfyHomeExamplePage
import spock.lang.Unroll

class SearchGifExampleSpec extends SpecBase {

    def "Find keanu woah gif"() {
        given: "At Gfy Home Page"
        to GfyHomeExamplePage

        when: "Search for keanu woah gif"
        searchModule().searchForGif("keanu woah")

        then: "keanu woah gif is found"
        searchResultsPage().keanuWoahGif.first().displayed
        report("Gif Found")
    }

    // datable version of "Find keanu woah gif" to show how it can be used with paramaters
    @Unroll // <- unroll makes each data table entry its own spec in the report and is reccommended when using them
    def "Find a #gifName gif"(gifName) {
        given: "At Gfy Home Page"
        to GfyHomeExamplePage

        when: "Search for #gifName gif"
        searchModule().searchForGif(gifName)

        then: "#gifName is found"
        //cModule().moveClick(searchResultsPage().gifWithAltText(gifName).first()) <- example of how to use common module method
        searchResultsPage().gifWithAltText(gifName).first().displayed
        report("$gifName Found") // <- report takes a screenshot that is embedded with present html into report

        where: "Expect #code for given #test"
        gifName    | _
        'Cat'      | _
        'Otter'    | _
        'BabyYoda' | _
    }
}