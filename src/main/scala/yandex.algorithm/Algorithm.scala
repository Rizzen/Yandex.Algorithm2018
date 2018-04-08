package yandex.algorithm

import scala.io._

class Algorithm {
  def openAndRead(fileName:String): Unit =
  {
    for (line<-Source.fromFile(fileName).getLines())
      println(line)
  }
}
