package tour

import org.mongodb.scala.model.Filters.equal
import org.mongodb.scala.model.Updates.set
import org.mongodb.scala.{Completed, Document, MongoClient, MongoCollection, MongoDatabase, Observer, Subscription}

object Connections {


  val mongoClient: MongoClient = MongoClient()

  val database: MongoDatabase = mongoClient.getDatabase("work")

  val collection: MongoCollection[Document] = database.getCollection("works")
    def create() {
      println("Enter new ID")
      var CreateId = scala.io.StdIn.readLine()
      println("Enter Name")
      var CreateName = scala.io.StdIn.readLine()
      val doc: Document = Document("_id" -> CreateId, "name" -> CreateName, "type" -> "database",
        "count" -> 1, "info" -> Document("x" -> 203, "y" -> 102))
      val insertObservable = collection.insertOne(doc)
      insertObservable.subscribe(new Observer[Completed] {

        override def onSubscribe(subscription: Subscription): Unit = println("Subscribed")

        override def onNext(result: Completed): Unit = println("Inserted")

        override def onError(e: Throwable): Unit = println("Failed")

        override def onComplete(): Unit = mongoClient.close()

      })

    }
    def delete() {
      println("Which ID to delete")
      var id = scala.io.StdIn.readLine()
      collection.deleteOne(equal("_id", id)).printHeadResult("Delete Result: ")
      collection.find().printResults()

    }
    def read() {
      collection.find().printResults()

    }
    def update() {
      println("Id of name you want to update")
      var idUpdate = scala.io.StdIn.readLine()
      println("Name you wish to change too")
      var UpdateName = scala.io.StdIn.readLine()
      collection.updateOne(equal("_id", idUpdate), set("name", UpdateName)).printHeadResult("Update Result: ")
    }
    def exit() {
      Running = false
    }





    Thread.sleep(1000)
    mongoClient.close()
  }

}
