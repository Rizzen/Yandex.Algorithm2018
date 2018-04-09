import yandex.algorithm._

object Main extends App {
  val input = Parser.parseInputFile("input.txt")
  val robots = RobotFactory.buildRobotsForEachTheme(input)
  val sequences = robots.map(x => x.getSequence).take(input.commonInfo.robotCount)

  for (seq <- sequences){
    println(seq.mkString(" "))
  }
}





