package yandex.algorithm

class VertexMap (vertexes: List[Vertex[Site]]){
  def getChildren(vertex: Vertex[Site]): List[Vertex[Site]] = {
    vertexes.filter(x => vertex.Site.siteRefs.contains(x.Site.name))
  }

  val vertexex = vertexes
}