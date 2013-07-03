package testgrails

import grails.test.mixin.TestFor
import org.junit.Test

import java.text.SimpleDateFormat

/**
 * Created with IntelliJ IDEA.
 * User: corwin
 * Date: 6/29/13
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */

class ParseXmlTest {

    @Test
    void parseXmlTest() {
        Node xml = new XmlParser().parse(this.class.getResourceAsStream("feed.xml"))
        List<Film> films = []
        xml.film.each{
            def film = new Film()
            film.name = it.name
            film.description = it.description
            it.session.each{
                def session = new Session()
                session.price = Double.valueOf(((Node)it).attribute('price'))
                session.time =  ((Node)it).attribute('time')
                film.sessionList.add(session)
            }
            films.add(film)
        }
        assert films.size() == 2
        assert films.get(0).sessionList.get(0).price == 10
    }

    @Test
    void timeTest(){
        String myDateString = "16:00";
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        Date date = sdf.parse(myDateString);
    }
}
