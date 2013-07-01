package testgrails

class Film {

    List<Session> getSessionList() {
        if (sessionList == null){
            sessionList = []
        }
        return sessionList
    }

    List<Session> sessionList

    String name

    String description

    static constraints = {
    }
}
