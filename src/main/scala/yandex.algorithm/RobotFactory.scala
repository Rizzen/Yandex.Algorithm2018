package yandex.algorithm

import scala.collection.mutable.ListBuffer

object RobotFactory {
  def buildRobots (yandexInput: YandexInput): List[Robot] = {
    val robots = ListBuffer.empty[Robot]
    val themes = yandexInput.frequencies.toList.sortBy(x=>x._2).take(yandexInput.commonInfo.robotCount)

    for (theme <- themes){
      robots += new Robot(yandexInput, theme._1, yandexInput.frequencies)
    }
    robots.toList
  }

  def buildRobotsForEachTheme(yandexInput: YandexInput): List[Robot] = {
    val robots = ListBuffer.empty[Robot]
    val themes = List.range(1, yandexInput.commonInfo.themeCount + 1)

    for (theme <- themes){
      robots += new Robot(yandexInput, theme, yandexInput.frequencies)
    }
    robots.toList
  }
}