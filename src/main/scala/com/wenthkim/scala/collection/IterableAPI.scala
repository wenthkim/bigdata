package com.wenthkim.scala.collection

/**
  * @Author wsj
  * @Date 2019/1/7 12:17
  * @Description  Iterable用例
  *
  */
object IterableAPI {
  //迭代器有一个很重要的特点是，数据迭代一次就不存在了
  //创建两个Iterable,默认实现是List
  val i1 = Iterable(1,2,3,4,5)
  val i2 = Iterable(6,7,8,9,10)

  def main(args: Array[String]): Unit = {
    //抽象方法 iterator
    iteratorApi()
    //其它迭代器 Other Iterators
    otherIteratorsApi()
    //子容器 Subcollections
    subcollectionsApi()
    //拉链方法 Zippers
    zippersApi()
    //对比 Comparison
    comparison()
  }


  /**
    * 对比 Comparison
    * sameElements
    */
   def comparison(): Unit = {
     val i3 = Iterable(2,3,4,5)
     val i4 = Iterable(2,3,4,5)
     //判断两个集合元素和元素顺序是否都一样
     //结果:res1: Boolean = true
     i3.sameElements(i4)
     val i5 = Iterable(2,4,3,5)
     val i6 = Iterable(2,3,4,5)
     //结果:res1: Boolean = false
     i5.sameElements(i6)
   }


  /**
    * 拉链方法 Zippers
    * zip
    * zipAll
    * zipWithIndex
    */
  def zippersApi(): Unit = {
    val i3 = Iterable(2,3,4,5)
    val i4 = Iterable(6,7,8,9,10,11)
    //以数量小的集合为size,把两个集合下标相同的组合起来
    //结果:zip: Iterable[(Int, Int)] = List((2,6), (3,7), (4,8), (5,9))
    val zip = i3.zip(i4)

    //生成以数量大的集合为size,左边的集合不够用第二个参数补，右边的集合不够用第三个参数补
    //例子：i3数量小，用2来补，结果:zipAll: Iterable[(Int, Int)] = List((2,6), (3,7), (4,8), (5,9), (2,10), (2,11))
    val zipAll = i3.zipAll(i4,2,5)

    //值和下标进行组合,结果:res1: Iterable[(Int, Int)] = List((2,0), (3,1), (4,2), (5,3))
    val zipWithIndex = i3.zipWithIndex
  }

  /**
    * 子容器 Subcollections
    * takeRight
    * dropRight
    */
  def subcollectionsApi(): Unit = {
    //从右边开始获取n个值，组成新集合，
    // 例子:取右边2个数 ，结果:takeRight: Iterable[Int] = List(4, 5)
    val takeRight = i1.takeRight(2)
    //除了右边n个值不要，其它保留，组成新集合
    //例子:除右边两个，结果:dropRight: Iterable[Int] = List(1, 2, 3)
    val dropRight = i1.dropRight(2)
  }

  /**
    * 其它迭代器 Other Iterators
    * grouped
    * sliding
    */
  def otherIteratorsApi(): Unit = {
    //按n个元素拆分开，组成多个迭代器, Iterator[Iterable[Int]]
    //例子按2个元素分,分成了3个Iterable,结果:Iterator(Iterable(1,2),Iterable(3,4),Iterable(5))
    val groupIter = i1.grouped(2)
    //对每个迭代器进行打印
    /**
      * 结果:
      * (iter size:2,data is:)12
        (iter size:2,data is:)34
        (iter size:1,data is:)5
      */
    groupIter.foreach(iter => {
      print("iter size:"+iter.size,"data is:")
      iter.foreach(print(_))
      println()
    })
    //按下标截取迭代器，不包括右边边界,比如参数(0,2),则取下标为0,1的值
    //结果:sliceGroup: Iterable[Int] = List(1, 2)
    val sliceGroup = i1.slice(0,2)
  }

  /**
    * 抽象方法 iterator
    */
  def iteratorApi(): Unit = {
    //迭代输出每个数据  结果:12345
    i1.iterator.foreach(print(_))
    //获取List的迭代器
    val iterator = i1.iterator
    //判断是否还有数据 结果:12345
    while(iterator.hasNext) {
      //next获取下一个数据
      print(iterator.next())
    }
  }



}
