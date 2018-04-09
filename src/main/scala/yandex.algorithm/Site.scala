package yandex.algorithm

case class Site (name: Int,
                 themeCount: Int,
                 themes: List[Int],
                 secondsToIndex: Int,
                 publishingPossibility: Int,
                 siteInterest: Int,
                 siteRefs: List[Int])