package testgrails

class SessionController {

    def add(){
        Session session = new Film()
        session.price = Double.valueOf(params.price)
        session.time = params.time
        session.save()
    }
}
