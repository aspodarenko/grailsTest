package testgrails

class FilmController {

    FilmController(){
       FilmService service = new FilmService()
       Film.metaClass.display = service.getFilmDisplayInfo
    }

    def show() {
        List<String> result = []
        Film.findAll().each {
            result.add(it.display)
        }
        [films: result]
    }

    def add(){
        Film film = new Film()
        film.name = params.name
        film.description = params.description
        film.save()
        redirect action: 'show', filmId: film.id
    }
}
