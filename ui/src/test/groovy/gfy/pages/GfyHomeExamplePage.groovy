package gfy.pages


import geb.Page

class GfyHomeExamplePage extends Page {
    static at = {
        waitFor {
            title.contains 'Gfycat'
        }
    }

    static to = {
        waitFor {
            title.contains 'Gfycat'
        }
    }

    static content = {
        // navigators here EX: searchPageFeed { $(".search-page-feed") }
    }
}
