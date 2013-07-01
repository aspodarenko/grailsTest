package testgrails

class FilmService {

    def getFilmDisplayInfo = {film ->
         String result = "name: " + film.name + " Description: " + film.description +" Session time: "
         Session.findAllByFilm(film).each {
            result += it.time+" "
         }
        result
    }
}
