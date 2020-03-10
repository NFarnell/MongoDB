package tour

import org.mongodb.scala.{Document, MongoClient, MongoCollection, MongoDatabase}

object Main extends App {
  val mongoClient: MongoClient = MongoClient()
  val database: MongoDatabase = mongoClient.getDatabase("work")
  val collection: MongoCollection[Document] = database.getCollection("works")
  var Running = true
  val connection = new Connections
  while(Running) {

    println("Select what you want to do")
    println("Create")
    println("Read")
    println("Update")
    println("Delete")
    println("Exit")


    val Input = scala.io.StdIn.readLine()
    Input match {
      case "Create" => connection.create()
      case "Read" => connection.read()
      case "Update" => connection.update()
      case "Delete" => connection.delete()
      case "Exit" => connection.exit()
    }


  }
}
