package yandex.algorithm

import scala.collection.mutable


object Analyzer {
  def buildSiteMap(input: List[Site]): mutable.Map[Int, Int] = {
    val map = mutable.Map(input.sorted(Ordering.by((_: Site).name))
      .map(x => (x.name, 0)):_*)

    for (site <- input){
      for (ref <- site.siteRefs){
        map(ref) += 1
      }
    }
    map
  }

  def maxAvailableSite(input: List[Site]): Site ={
    input.maxBy(x => x.publishingPossibility / x.secondsToIndex)
  }
}