package com.wenthkim.scala.collection

/**
  * @Author wsj
  * @Date 2019/1/6 13:32
  * @Description 最全TraversableAPI用例
  *
  */
object TraversableAPI {

  //新建一个Traversable，它的默认实现为List
  //t1: Traversable[Int] = List(1, 2, 3)
  val t1 = Traversable(1,2,3)

  //t2: Traversable[Int] = List(4, 5, 6)
  val t2 = Traversable(4,5,6)
  def main(args: Array[String]): Unit = {
    //相加
    addApi()
    //Map
    mapApi()
    //转换api
    conversionApi()
    //复制
    copyingApi()
    //sizeInfo APi
    sizeInfoApi()
    //元素检索
    elementRetrievalApi()
    //子容器检索
    subCollectionRetrivalApi()
    //拆分
    subdivisionApi()
    //元素测试
    elementTestApi()
    //折叠
    foldsApi()
    //特殊折叠
    specificFoldsApi()
    //字符串
    stringApi()

  }


  /**
    * 字符串（String）
    * mkString
    * addString
    * stringPrefix
    */
  def stringApi(): Unit = {
    //以逗号隔开，把集合拼接成字符串，res2: String = 1,2,3
    t1.mkString(",")
    //加开头和结尾， res2: String = {1,2,3}
    t1.mkString("{",",","}")

    val strBuffer = new StringBuilder()
    //把集合元素append到stringBuilder里面，res2: StringBuilder = 123
    t1.addString(strBuffer)
    //以逗号隔开res2: StringBuilder = 1,2,3
    t1.addString(strBuffer,",")
    //加开头结尾res2: StringBuilder = [1,2,3]
    t1.addString(strBuffer,"[",",","]")
    //返回字符串开头的集合名称，t1的实现类是List,结果:res3: String = List
    t1.stringPrefix
  }

  /**
    * 只有当集合中为数字时才能用
    * 特殊折叠（Specific folds）
    * sum
    * product
    * min
    * max
    */
  def specificFoldsApi(): Unit ={
    //集合求和,res2: Int = 6
    t1.sum
    //集合每个元素的乘积 res2: Int = 6
    t1.product
    //集合中最小值 res2: Int = 1
    t1.min
    //集合中最大值 res2: Int = 3
    t1.max
  }

  /**
    * 折叠(Folds)
    * foldLeft(/:)
    * foldRight(:\)
    * reduceLeft
    * reduceRight
    */
  def foldsApi(): Unit = {
    //从集合最左边，下标最小，并以0为初始值开始计算
    //例子1:(((0+1)+2)+3) 结果:res2: Int = 6
    t1.foldLeft(0)((a,b) => a + b)
    //例子2, (((1-1)-2)-3) 结果:res2: Int = -5
    t1.foldLeft(1)((a,b) => a - b)
    //同foldLeft
    (0 /: t1)((a,b) => a + b)

    //从集合最右边，下标最大，并以0为初始值开始计算
    //例子1: (1+(2+(3+0))) 结果:res2: Int = 6
    t1.foldRight(0)((a,b) => a + b)
    //例子2: (1-(2-(3-1))) 结果:res2: Int = 1
    t1.foldRight(1)((a,b) => a - b)
    //同foldRight
    (t1 :\ 0)((a,b) => a + b)

    //从集合最左边，下标最小开始计算，执行函数
    //例子:((1-2)-3)  结果:res2: Int = -4
    t1.reduceLeft((a,b) => a-b)
    //从集合最右边，下标最大，执行函数
    //例子:(1-(2-3)) 结果:res2: Int = 2
    t1.reduceRight((a,b) => a-b)
  }

  /**
    * 元素测试Element test
    * exists
    * forall
    * count
    */
  def elementTestApi(): Unit ={
    //判断集合中是否有满足条件的元素，res2: Boolean = true
    t1.exists(x => x > 1)
    //判断集合中是否所有元素中都满足条件, res2: Boolean = false
    t1.forall(x => x > 1)
    //计算集合中满足条件元素的数量, res2: Int = 2
    t1.count(x => x > 1)
  }

  /**
    * 拆分Subdivision
    * splitAt
    * span
    * partition
    * groupBy
    */
  def subdivisionApi(): Unit = {
    //从下标n进行分割,分成两部分,第一部分take的结果，第二部分drop的结果，
    // 结果:res2: (Traversable[Int], Traversable[Int]) = (List(1, 2),List(3))
    t1.splitAt(2)
    //把集合分成两部分，第一部是takeWhile的结果，第二部分是dropWhile的结果,
    //res2: (Traversable[Int], Traversable[Int]) = (List(1, 2, 3),List())
    t1.span(x => x > 0)
    //把集合分成两部分，第一部是filter的结果，第二部分是filterNot的结果
    //res2: (Traversable[Int], Traversable[Int]) = (List(2, 3),List(1))
    t1.partition(x => x > 1)
    //把每个元素x组成Map(x,List(x)),函数接收的函数返回值成为map的key
    //res2: scala.collection.immutable.Map[(Int, Int),Traversable[Int]]
    // = Map((2,1) -> List(2), (1,1) -> List(1), (3,1) -> List(3))
    t1.groupBy(x => (x,1))
    //res2: scala.collection.immutable.Map[Int,Traversable[Int]]
    // = Map(2 -> List(2), 1 -> List(1), 3 -> List(3))
    t1.groupBy(x => x)
    //res2: scala.collection.immutable.Map[Int,Traversable[Int]]
    // = Map(2 -> List(1), 4 -> List(3), 3 -> List(2))
    t1.groupBy(x => x + 1)
  }

  /**
    * 子容器检索sub-collection Retrieval
    * tail
    * init
    * slice (from, to)
    * take n
    * drop n
    * takeWhile p
    * dropWhile p
    * filter p
    * withFilter p
    * filterNot p
    */
  def subCollectionRetrivalApi(): Unit = {
    //除了第一个的所有元素，res2: Traversable[Int] = List(2, 3)
    t1.tail
    //除了最后一个的所有元素，res2: Traversable[Int] = List(1, 2)
    t1.init
    //获取从下标0-2[不包括],res3: Traversable[Int] = List(1, 2)
    t1.slice(0,2)
    //从第一个开始，取n个值，res2: Traversable[Int] = List(1, 2)
    t1.take(2)
    //从第一个开始,前n个值不要,res3: Traversable[Int] = List(2, 3)
    t1.drop(1)
    //当集合里面所有元素都满足大于1的时候才返回，res2: Traversable[Int] = List()
    t1.takeWhile(x => x > 1)
    //集合都大于0，结果:res2: Traversable[Int] = List(1, 2, 3)
    t1.takeWhile(x => x > 0)
    //当所有都满足大于0时，全部不要，res2: Traversable[Int] = List()
    t1.dropWhile(x => x > 0)
    //条件过滤，只要大于1的，res2: Traversable[Int] = List(2, 3)
    t1.filter(x => x > 1)
    //延时计算，不产生中间变量，当使用map, flatMap, foreach,forall/exists这些方法时才触发
    //res2: Traversable[Int] = List(3, 4)
    t1.withFilter(x => x > 1).map(_+1)
    //过滤与条件相反的，例子为不大于一，结果 res2: Traversable[Int] = List(1)
    t1.filterNot(x => x > 1)

  }

  /**
    * 元素检索Element Retrieval
    * head
    * headOption
    * last
    * lastOption
    * find
    */
  def elementRetrievalApi(): Unit ={
    //取第一个元素 res2: Int = 1
    t1.head
    //用option取第一个元素 res2: Option[Int] = Some(1)
    t1.headOption
    //取最后一个元素 res2: Int = 3
    t1.last
    //用option取最后一个元素 res2: Option[Int] = Some(3)
    t1.lastOption
    //查找第一个满足条件的元素，找不到返回 None res2: Option[Int] = Some(2)
    t1.find(x => x > 1)
  }

  /**
    * sizeInfo APi 集合大小api
    * isEmpty
    * nonEmpty
    * size
    * hasDefiniteSize
    */
  def sizeInfoApi(): Unit = {
    //判断空 res1: Boolean = false
    t1.isEmpty
    //判断不空 res1: Boolean = true
    t1.nonEmpty
    //res1: Int = 3
    t1.size
    //是否有界  res1: Boolean = true
    t1.hasDefiniteSize
  }

  /**
    * 复制
    * copyToBuffer copyToArray
    */
  def copyingApi(): Unit = {
    //先引入可变集合
    import scala.collection.mutable._
    val buffer =  ArrayBuffer[Int]()
    // scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 3)
    t1.copyToBuffer(buffer)
    //复制到array 不够的用0补充 Array[Int] = Array(1, 2, 3, 0, 0)
    val array = new Array[Int](5)
    t1.copyToArray(array)
    t1.copyToArray(array,0)
    t1.copyToArray(array,0,2)

  }

  /**
    * 转换api toArray
    */
  def conversionApi(): Unit = {
    /**
      * array: Array[Int] = Array(1, 2, 3)
        list: List[Int] = List(1, 2, 3)
        iterable: Iterable[Int] = List(1, 2, 3)
        seq: Seq[Int] = List(1, 2, 3)
        indexedSeq: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 3)
        stream: Stream[Int] = Stream(1, ?)
        set: scala.collection.immutable.Set[Int] = Set(1, 2, 3)
        tomap: scala.collection.immutable.Map[Int,Int] = Map(1 -> 1, 2 -> 1, 3 -> 1)

      */
    val array = t1.toArray
    val list = t1.toList
    val iterable = t1.toIterable
    val seq = t1.toSeq
    val indexedSeq = t1.toIndexedSeq
    val stream = t1.toStream
    val set = t1.toSet
    //只有元组才能转成map,所以要把list转换成元组
    val tomap = t1.map(x => (x,1)).toMap
  }


  /**
    * Map map flatMap collect
    */
  def mapApi(): Unit ={
    //map作用遍历每个元素进行对应操作，
    //把t1中每个元素加1   结果:map: Traversable[Int] = List(2, 3, 4)
    val map = t1.map(x => x+1)
    //当参数只使用一次时可省略，如下
    val map1 = t1.map(_+1)
    //flatMap接收的函数是输入一个参数，返回GenTraversableOnce接口的子类，相当于返回一个集合，然后再把结果打平
    //比如下面  输入1 返回1,2,3,4,5  输入2,返回2,3,4,5 .....
    //结果:flatMap: Traversable[Int] = List(1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5)
    val flatMap = t1.flatMap(x => x to 5)
    //另一个例子
    val t3 = Traversable("hello world","this is a example","just a test")
    //每行以空格分割，生成一个数组，再打平，结果:strFlatMap: Traversable[String] = List(hello, world, this, is, a, example, just, a, test)
    val strFlatMap = t3.flatMap(line => line.split(" "))
    //接收一个偏函数,下而例子是当x>2的时候才加1  结果：collect: Traversable[Int] = List(4)
    val collect = t1.collect{case x if x > 2=> x + 1}
  }

  /**
    * 相加 ++ 把两个集合元素相加
    */
  def addApi(): Unit = {
    //add: Traversable[Int] = List(1, 2, 3, 4, 5, 6)
    val add = t1 ++ t2
  }


}
