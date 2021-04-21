package gfy.base

import geb.spock.GebReportingSpec
import gfy.modules.CommonModule
import gfy.modules.ExampleModule
import gfy.pages.SearchResultExamplePage

class SpecBase extends GebReportingSpec {

    /*
    This is where you will perform the necessary setup needed for your test environment.
     */

    //@formatter:off - Pages
    SearchResultExamplePage searchResultsPage() { at SearchResultExamplePage }

    //@formatter:off - Modules
    ExampleModule searchModule() { module ExampleModule }
    CommonModule cModule() { module CommonModule }
    //@formatter:on

    void setupSpec() {
        // spec setup such as being logged in before tests will be performed here
    }
}
