import yandex.algorithm._

import scala.collection.mutable.ListBuffer

object Main extends App {
  val input = Parser.parseInputFile("input.txt")
  Analyzer.buildSiteMap(input.sites)
  val robots = RobotFactory.buildRobots(input, input.commonInfo.themeCount)
  val sequences = robots.map(x => x.getSequence)

  for (seq <- sequences){
    println(seq.mkString(" "))
  }
}

object RobotFactory {
  def buildRobots (yandexInput: YandexInput, themeCount: Int): List[Robot] = {
    val robots = ListBuffer.empty[Robot]
    val themes = List.range[Int](1, themeCount + 1)

    for (theme <- themes){
      robots += new Robot(yandexInput, theme)
    }

    robots.toList
  }
}