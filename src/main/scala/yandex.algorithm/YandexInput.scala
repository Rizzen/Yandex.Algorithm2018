package yandex.algorithm

case class YandexInput(commonInfo: CommonInfo,
                       sites: List[Site],
                       frequencies: Map[Int, Int])
