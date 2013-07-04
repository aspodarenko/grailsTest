package testgrails

import java.text.SimpleDateFormat

class FilmService {

    def getFilmDisplayInfo = {film ->
         String result = "name: " + film.name + " Description: " + film.description +" Session time: "
         Session.findAllByFilm(film).each {
            result += it.time+" "
         }
        result
    }

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
