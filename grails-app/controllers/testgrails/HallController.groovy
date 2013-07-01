package testgrails

class HallController {

    def add() {
        Hall hall = new Hall()
        hall.placesCount = Integer.valueOf(params.placesCount)
        hall.name = params.name
        hall.save()
        redirect action: 'show'
    }

    def show(){
        List<String> result = []
         Hall.findAll().each {
             result.add("Name " + it.name+ " places "+it.placesCount)
        }
        [halls: result]
    }



}
