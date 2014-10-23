import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

case class Hello()
case class BuenosDias()


class HelloActor() extends Actor {
  def receive = {
    // case value: String => println("Message received: " + value)

    case Hello => printMsg("Hello")
    case BuenosDias => println("BuenosDias")
    case _ => println("eh?")
  }

  def printMsg(msg: String) {
    Thread sleep 2000
    println(msg)
  }
}


object ActorExample extends App {
  val system = ActorSystem("HelloSystem")
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
  val helloActorTwo = system.actorOf(Props[HelloActor], name = "helloactortwo")

  helloActor ! Hello // will print second
  helloActorTwo ! BuenosDias // will print first

  val stuff = Array(1, 2, 3, 4)
  helloActor ! stuff // will print 'eh?' because stuff is neither Hello nor BuenosDias

}