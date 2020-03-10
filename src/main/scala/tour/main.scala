package tour
import tour.Connections._

class main extends App {
  var Running = true
  while(Running) {
    println("Select what you want to do")
    println("Create")
    println("Read")
    println("Update")
    println("Delete")
    println("Exit")
    var Input = scala.io.StdIn.readLine()


    Input match {
      case "Create" => create()
      case "Read" => read()
      case "Update" => update()
      case "Delete" => delete()
      case "Exit" => exit()
    }
  }



}
