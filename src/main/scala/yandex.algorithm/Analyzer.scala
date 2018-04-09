package yandex.algorithm

import YandexImplicits._
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Analyzer {
  def maxAvailableSite(input: List[Site]): Site = {
    input.maxBy(x => x.siteInterest)
  }

  def maxAvailableVert(input: List[Vertex[Site]]): Vertex[Site] = {
    input.maxBy(x => x.Site.publishingPossibility / x.Site.secondsToIndex)
  }

  def maxAvailableVertByInterest(input: List[Vertex[Site]]): Vertex[Site] = {
    input.maxBy(x => x.Site.siteInterest)
  }

  def maxAvailableVertByEachThemeInterest(input: List[Vertex[Site]],
                                          theme: Int,
                                          themeMap: Map[Int, Int]): Vertex[Site] = {
    val a = input.map(x => x.Site.siteInterest * x.Site.themes.contains(theme))
    input.maxBy(x => x.Site.siteInterest * x.Site.themes.contains(theme))
  }


  def findCycle(input: List[Site], theme: Int, themeMap: Map[Int, Int]): List[Site] = {
    val map = new VertexMap(input.map(x=>new Vertex[Site](x)))

    val stack = mutable.Stack[Vertex[Site]]()
    val visited = mutable.Set[Vertex[Site]]()

    val currentSite = Analyzer.maxAvailableSite(input.filter(x => x.themes.contains(theme)))
    val start = map.vertexex.filter(x => x.Site.name == currentSite.name).head

    val san = findFirstCycle(start, stack, visited, map, theme, themeMap)

    var result = ListBuffer.empty[Site]
    while (san.stack.top != san.node){
      result += san.stack.pop().Site
    }
    result += san.stack.pop().Site
    result.toList.reverse
  }

  def findFirstCycle(input: Vertex[Site],
                     stack: mutable.Stack[Vertex[Site]],
                     set: mutable.Set[Vertex[Site]],
                     vertexMap: VertexMap,
                     theme: Int,
                     themeMap: Map[Int, Int]): StackAndNode = {
    if (set.contains(input))
      return StackAndNode(stack, input)
    set.add(input)
    stack.push(input)
    findFirstCycle(maxAvailableVertByEachThemeInterest(vertexMap.getChildren(input), theme, themeMap),
      stack, set, vertexMap, theme, themeMap)
  }
}