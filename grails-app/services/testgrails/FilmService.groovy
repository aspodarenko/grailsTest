package testgrails

class FilmService {

    def getFilmDisplayInfo = { film ->
         String result = "name: " + film.name + " Description: " + film.description +" Session time: "
         Session.findByFilm(film).each {
            result += it.time+" "
         }
        result
    }
}
