package yandex.algorithm

import scala.collection.mutable.ListBuffer
import scala.util.Random

class Robot(input: YandexInput, theme: Int) {
  def getSequence: List[Int] = {
    val result = ListBuffer.empty[Int]
    val random = Random.nextInt(input.sites.length - 1)

    var currentSite = input.sites(random)
    var time = input.commonInfo.simulationTime - currentSite.secondsToIndex

    while(time > 0) {
      currentSite = chooseNextSite(currentSite)
      time -= currentSite.secondsToIndex
      result+=currentSite.name
    }
    result.length::result.toList
  }


  private def chooseNextSite(current: Site): Site = {
    val availableSites = input.sites.filter(x => current.siteRefs.contains(x.name))
    Analyzer.maxAvailableSite(availableSites)
  }
}
