package testgrails

import java.text.SimpleDateFormat

class FilmController {
    FilmService service = new FilmService()

    def show() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        [films: service.displayWhichHasSessionLater(service.getFilmDisplayInfo,Film.getAll(),sdf.parse("16:00")), filmId: params.filmId, halls: Hall.findAll()]
    }

    def add(){
        Film film = new Film()
        film.name = params.name
        film.description = params.description
        film.save()
        redirect (action: 'show', params: [filmId: film.id])
    }
}
