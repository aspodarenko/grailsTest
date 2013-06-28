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

    def hello(){
        render "Hello world"
    }
}
