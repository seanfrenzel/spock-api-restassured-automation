package gfy.modules

import geb.Module

class ExampleModule extends Module {
    static at = { waitFor { searchBtn.isDisplayed() } }
    static content = {
        searchBtn(wait: true) { $("button.search-button") }
        searchInput(wait: true) { $("div.search-input-wrapper > input") }
    }

    ExampleModule open() { /* open/expand here */ this }

    ExampleModule close() { /* close/collapse here */ this }

    ExampleModule searchForGif(String searchText) {
        searchInput.value(searchText)
        searchBtn.click()
        this
    }
}
