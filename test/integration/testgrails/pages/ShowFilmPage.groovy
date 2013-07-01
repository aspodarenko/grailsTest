package testgrails.pages

import geb.Page

/**
 * Created with IntelliJ IDEA.
 * User: corwin
 * Date: 6/30/13
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */
class ShowFilmPage extends Page {

    // pages can define their location, either absolutely or relative to a base
    static url = "http://google.com/ncr"

    // “at checkers” allow verifying that the browser is at the expected page
    static at = { title == "Google" }

    static content = {
        // include the previously defined module
        search { module GoogleSearchModule, buttonValue: "Google Search" }
    }
}
