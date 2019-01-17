package com.wenthkim.scala.collection

import scala.collection.mutable

/**
  * @Author wsj
  * @Date 2019/1/10 12:33
  * @Description
  *    SeqAPI
  * IndexedSeq  LinearSeq
  */
object SeqAPI {


  val s1 = Seq(1,2,3,4,5)
  val s2 = Seq(6,7,8,9,10)

  def main(args: Array[String]): Unit = {
    //索引和长度
    indexAndLength()

    //查询下标
    indexSearch()

    //添加
    addition()

    //更新
    updates()

    //排序 Sorting
    sorting()

    //反转 Reversals
    reversal()

    //比较 Comparisons
    comparisons()

    //多集合操作 Multiset Operations
    multisetOper()

    //添加 Addition 可变集合才有的操作
    bufferAdditon()

    //删除 Removals
    removals()
  }

  /**
    * 删除 Removals
    * -=
    * remove(i)
    * remove(i,n)
    * trimStart
    * trimEnd
    * clear
    */
  def removals(): Unit = {
    val buffer = mutable.Buffer(1,2,3,4,5)
    //删除指定下标的元素
    //结果: 1245
    buffer.remove(2)
    //从指定下标开始，删除n个元素
    //结果:125
    buffer.remove(2,2)
    //从指定下标开始截取
    //结果:345
    buffer.trimStart(2)
    //从下标0截取到指定下标
    //结果:123
    buffer.trimEnd(2)
    //清空数据
    buffer.clear()
  }

  /**
    * 添加 Addition 可变集合才有的操作
    * +=
    * +=
    * ++=
    * +=:
    * ++=:
    * insert
    * insertAll
    */
  def bufferAdditon(): Unit = {
    val buffer = mutable.Buffer(1,2,3,4,5)
    val b2 = mutable.Buffer(7,8)
    //向buffer增加一个元素
    //结果:res0: scala.collection.mutable.Buffer[Int] = ArrayBuffer(1, 2, 3, 4, 5, 6)
    buffer += 6

    //向buffer增加几个元素
    //结果:res0: scala.collection.mutable.Buffer[Int] = ArrayBuffer(1, 2, 3, 4, 5, 7, 8, 9)
    buffer += (7,8,9)

    //添加集合
    //结果:res0: scala.collection.mutable.Buffer[Int] = ArrayBuffer(1, 2, 3, 4, 5, 7, 8)
    buffer ++= b2

    //把元素放在集合头部
    //结果:res0: scala.collection.mutable.Buffer[Int] = ArrayBuffer(6, 1, 2, 3, 4, 5)
    6 +=: buffer

    //把集合放buffer头部
    //结果:res0: scala.collection.mutable.Buffer[Int] = ArrayBuffer(7, 8, 1, 2, 3, 4, 5)
    b2 ++=: buffer
    //在下标i，插入元素
    //结果:1210345
    buffer.insert(2,10)
    //从下标开始插入整个数组
    //结果:12789345
    val arr = Array(7,8,9)
    buffer.insertAll(2,arr)
  }

  /**
    * 多集合操作 Multiset Operations
    * intersect
    * diff
    * union
    * distinct
    */
   def multisetOper(): Unit = {
     val s3 = Seq(0,1,2,3,4)
     //获取两个集合的交集
     //结果:res0: Seq[Int] = List(1, 2, 3, 4)
     s1.intersect(s3)
     //获取第一个集合有，第二个集合没有的
     //结果:res0: Seq[Int] = List(5)
     s1.diff(s3)
     //两个集合合并
     //结果：res0: Seq[Int] = List(1, 2, 3, 4, 5, 0, 1, 2, 3, 4)
     s1.union(s3)
     //集合去重
     //结果:res0: Seq[Int] = List(1, 2, 3, 4)
     val s4 = Seq(1,1,2,3,2,3,4)
     s4.distinct
   }

  /**
    * 比较 Comparisons
    * startsWith
    * endsWith
    * contains
    * containsSlice
    * corresponds
    */
  def comparisons(): Unit = {
    val s3 = Seq(1,2,3)
    //判断是否以另一个集合开始,元素和顺序一致
    //结果:res0: Boolean = true
    s1.startsWith(s3)

    //判断是否以另一个集合结尾，元素和顺序一致
    //结果:res0: Boolean = true
    val s4 = Seq(3,4,5)
    s1.endsWith(s4)

    //判断集合是否包含某个元素
    //结果:res0: Boolean = true
    s1.contains(2)

    //判断是否包含另一个集合的连续字段
    //结果:res0: Boolean = true
    s1.containsSlice(s3)

    //判断两个集合长度，按下标遍历，满足输入函数的返回true，不满足的返回false
    //结果:res0: Boolean = true
    val s5 = Seq(1,2,3,4,5)
    s1.corresponds(s5)((x,y)=>x == y)

  }

  /**
    * 反转 Reversals
    * reverse
    * reverseIterator
    * reverseMap
    */
  def reversal(): Unit ={
    //把集合反转，结果:res0: Seq[Int] = List(5, 4, 3, 2, 1)
    s1.reverse
    //返回反转后的集合迭代器
    //结果:54321
    val it = s1.reverseIterator
    while (it.hasNext) {
      print(it.next())
    }
    //反转集合，按指定函数进行map
    //结果:res0: Seq[Int] = List(6, 5, 4, 3, 2)
    s1.reverseMap(x => x + 1)

  }
  /**
    * 排序 Sorting
    * sorted
    * sortWith
    * sortBy
    */
  def sorting(): Unit = {
   val s3 = Seq(4,2,5,8,3,0)
    //按自然升序排
    //结果:res0: Seq[Int] = List(0, 2, 3, 4, 5, 8)
    s3.sorted
    //按自定义函数排序
    //结果:res0: Seq[Int] = List(8, 5, 4, 3, 2, 0)
    s3.sortWith((x,y) => x > y)
    //从大到小,结果:res0: Seq[Int] = List(8, 5, 4, 3, 2, 0)
    s3.sortBy(x => -x)
    //从小到大，结果:res0: Seq[Int] = List(0, 2, 3, 4, 5, 8)
    s3.sortBy(x => x)
  }

  /**
    * 更新 Updates
    * patch
    * updated
    */
  def updates(): Unit = {
    //从下标为2[index]的元素开始，用集合s2所有元素替换掉1[n]个数。
    //结果:res0: Seq[Int] = List(1, 2, 6, 7, 8, 9, 10, 4, 5)
    s1.patch(2,s2,1)
    //更新下标i的值
    //结果:res0: Seq[Int] = List(1, 2, 10, 4, 5)
    s1.updated(2,10)

  }

  /**
    * 添加 Addition
    * +:
    * :+
    * padTo
    */
  def addition(): Unit = {
    //把n加入到集合在头部
    //结果：res0: Seq[Int] = List(6, 1, 2, 3, 4, 5)
    6 +: s1

    //把n加到集合后面
    //结果:res0: Seq[Int] = List(1, 2, 3, 4, 5, 6)
    s1 :+ 6

    //第一个参数len,第二个参数value,如果集合长度达<len,则将集合扩展到len,并用value填充。否则什么都不做
    //结果:res0: Seq[Int] = List(1, 2, 3, 4, 5, 2, 2)
    s1 padTo (7,2)
  }


  /**
    * 查询下标 Index Search
    * indexOf
    * lastIndexOf
    * indexOfSlice
    * lastIndexOfSlice
    * indexWhere
    * segmentLength
    * prefixLength
    */
   def indexSearch(): Unit = {
     //查询元素1所在的下标
     //结果 res0: Int = 0
     s1.indexOf(1)
     //查找该元素的最后一个索,res0: Int = 2
     val s3 = Seq(1,2,2,4,5,2,2,4)
     s3.lastIndexOf(2)
     //右边seq在左边seq的开始匹配索引
     //结果:res0: Int = 1
     val s4 = Seq(2,2,4)
     s3.indexOfSlice(s4)
     ////右边seq在左边seq的最后匹配索引
     //结果:res0: Int = 5
     s3.lastIndexOfSlice(s4)
     //查找第一个满足条件的索引
     //结果:res0: Int = 3
     s3.indexWhere(_ > 2)
     //从seq(n)开始，连续满足条件的个数
     //结果:res0: Int = 2
     s3.segmentLength(_ > 2,3)
     //从seq(0)开始，连续满足条件的个数
     //res0: Int = 8
     s3.prefixLength(_ > 0)
   }


  /**
    * 索引和长度 Indexing and length
    * () or apply
    * isDefinedAt
    * length
    * lengthCompare
    * indices
    *
    */
  def indexAndLength(): Unit = {
    //获取某个下标的值
    //res0: Int = 2
    s1(1)
    s1.apply(1)

    //是否包括该下标，下标从0开始，
    //结果 res0: Boolean = true
    s1.isDefinedAt(1)

    //seq长度，结果:res0: Int = 5
    s1.length

    //seq长度比n大则返回+1，比n少则返回-1，=n则返回0
    s1.lengthCompare(5)

    //返回0--(s1.length-1) 的Range
    //结果: res0: scala.collection.immutable.Range = Range 0 until 5
    s1.indices

  }


}
