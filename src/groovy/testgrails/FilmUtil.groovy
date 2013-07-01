package testgrails

import testgrails.Film

import java.text.SimpleDateFormat

/**
 * Created with IntelliJ IDEA.
 * User: corwin
 * Date: 6/29/13
 * Time: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */
class FilmUtil {
    List<String> displayWhichHasSessionLater(Closure display, List<Film> films, Date date) {
        List<String> result = []
        films.each {
            def valid = false
            if (it.sessionList.size() > 0) {
                it.sessionList.each {
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
                    if (sdf.parse(it.time) > date){
                        valid = true
                    }
                }
            } else {
                valid = true
            }
            if (valid==true) {
                result.add(display(it))
            }
        }
        result
    }
}
