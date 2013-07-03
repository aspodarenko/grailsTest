package testgrails

import org.junit.Before
import org.junit.Test

import java.text.SimpleDateFormat

/**
 * Created with IntelliJ IDEA.
 * User: corwin
 * Date: 7/1/13
 * Time: 7:08 PM
 * To change this template use File | Settings | File Templates.
 */
class FilmUtilTest {

    FilmUtil filmUtil
    FilmService filmService
    List<Film> films

    private Film film2

    private Film film

    @Before
    public void setUp() {
        films = new LinkedList<Film>()
        filmUtil = new FilmUtil()
        filmService = new FilmService()
        film = new Film()
        film.name="name1"
        Session session1 = new Session()
        session1.time = "12:00"
        film.sessionList.add(session1)
        film2 = new Film()
        film2.name = "name2"
        Session session2 = new Session()
        session2.time = "14:00"
        film2.sessionList.add(session2)
        Session session3 = new Session()
        session3.time = "17:00"
        film2.sessionList.add(session3)
        films.add(film)
        films.add(film2)
        Session.metaClass.'static'.findAllByFilm = {Film film1 -> films }
    }

    def testFilmDisplay = { film -> film.name }

    @Test
    public void whenOneHasSessionLaterDateAndOneBefore() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        List<String> result = filmUtil.displayWhichHasSessionLater(testFilmDisplay,films,sdf.parse("16:00"))
        assert film2.name == result.get(0)

    }
}
