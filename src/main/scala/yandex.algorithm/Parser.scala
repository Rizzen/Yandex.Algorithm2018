package yandex.algorithm

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Parser {

  def parseInputFile(fileName:String): YandexInput =
  {
    val strings = openAndRead(fileName)

    // First string containing common info
    val commonInfoString = strings.head.split(" ").toList
    val commonInfo = CommonInfo(commonInfoString.head.toInt,
                                commonInfoString(1).toInt,
                                commonInfoString(2).toInt,
                                commonInfoString(3).toInt,
                                commonInfoString(4).toInt)

    // Map of frequencies
    val seq = List.range(1, commonInfo.themeCount + 1)
    val freqList = strings.last.split(" ").map(x => x.toInt).toList
    val frequenciesMap = (seq zip freqList).toMap

    // Group of strings that describes each site
    val sitesDescription = strings.tail.grouped(3)
    val sites = ListBuffer.empty[Site]
    var counter = 1

    for(site <- sitesDescription)
    {
      if (site.length == 3)
      {
        // Site Info parsing
        val themesCount = site.head.split(" ").head.toInt
        val themes = site.head.split(" ").tail.map(x => x.toInt).toList
        val secondsToIndex = site(1).split(" ").head.toInt
        val publishingPossibility = site(1).split(" ").last.toInt
        val siteRefs = site(2).split(" ").tail.map(x => x.toInt).toList

        sites += Site(counter, themesCount,themes,secondsToIndex,publishingPossibility,siteRefs)
        counter+=1
      }
    }

    YandexInput(commonInfo, sites.toList, frequenciesMap)
  }

  def openAndRead(fileName:String): List[String] = Source.fromFile(fileName).getLines().toList
}
