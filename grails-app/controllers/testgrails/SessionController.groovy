package testgrails

import groovy.xml.MarkupBuilder

class SessionController {

    def add(){
        Session session = new Session()
        Film film = Film.findById(params.filmId)
        Hall hall = Hall.findById(params.hallId)
        session.film = film
        film.sessionList.add(session)
        hall.sessionList.add(session)
        film.save()
        hall.save()
        session.hall = hall
        session.price = Double.valueOf(params.price)
        session.time = params.time
        session.save()
        String result =""
        Session.findAllByFilm(film).each {
            result+="<p> price: " + it.price + " time: " + it.time + "</p>"
        }
        render result
    }
}
