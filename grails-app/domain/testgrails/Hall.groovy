package testgrails

class Hall {

    List<Session> sessionList

    String name

    Integer placesCount

    static constraints = {
    }

    List<Session> getSessionList() {
        if (sessionList == null){
            sessionList = []
        }
        return sessionList
    }

    @Override
    String toString() {
        return name
    }
}
