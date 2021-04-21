package gfy.pages

import gfy.modules.CommonModule
import gfy.modules.ExampleModule
import geb.Page

class SearchResultExamplePage extends Page {
    static at = {
        waitFor {
            title.contains 'Gfycat'
            searchPageFeed.displayed
        }
    }

    static content = {
        searchPageFeed { $(".search-page-feed") }
        keanuWoahGif(wait: true) { $(".grid-gfy-item .image[alt*=woah i]") }
        gifWithAltText(wait: true) { text -> $(".grid-gfy-item .image[alt*=${text} i]") }

        exampleModule { module(ExampleModule) }
        commonModule { module(CommonModule) }
    }
}
