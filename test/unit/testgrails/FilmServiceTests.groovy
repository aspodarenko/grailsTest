package testgrails



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(FilmService)
class FilmServiceTests {

    FilmService service


    @Before
    void setUp() {
        service = new FilmService()
    }

    void testDisplayFilm() {
        //given
        Film film = new Film()
        film.name = "Lord of the Rings"
        film.description = "Cool film!"
        Session session1 = new Session()
        session1.film = film
        session1.time = "12:00"
        Session session2 = new Session()
        session2.film = film
        session2.time = "16:00"
        Session.metaClass.'static'.findByFilm = {Film film1 -> [session1, session2] as List }

        //when
        def actual = service.getFilmDisplayInfo(film)
        //then
        assert "name: Lord of the Rings Description: Cool film! Session time: 12:00 16:00 " == actual
    }
}
