package yandex.algorithm

class Robot(input: YandexInput, theme: Int, themeMap: Map[Int, Int]) {
  def getSequence: List[Int] = {
    val way = Analyzer.findCycle(input.sites, theme, themeMap).map(x => x.name)
    way.length::way
  }
}