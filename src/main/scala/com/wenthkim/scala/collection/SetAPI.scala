package com.wenthkim.scala.collection

import scala.collection.mutable

/**
  * @Author wsj
  * @Date 2019/1/18 19:19
  * @Description 集合api用例
  *
  */
object SetAPI {

  val s1 = Set(1,2,3,4,5)

  def main(args: Array[String]): Unit = {
    //测试 Tests
    testsApi()

    //添加 Additions
    addtionApi()

    //删除 Removals
    removalApi()

    //二元操作 Binary Operations
    binaryOper()

    //可变集合 添加
    mutableAdd()

    //可变集合 删除
    mutableRemoval()
  }

  /**
    * 可变集合 更新
    * =
    */
  def mutableUpdate(): Unit = {
    val ms = mutable.Set(1,2,3,4)
    //不存在时插入
    ms.update(5,true)
  }

  /**
    * 可变集合 删除
    * 删除 removals
    * -=
    * --=
    * remove
    * retain
    * clear
    */
  def mutableRemoval(): Unit = {
    val ms = mutable.Set(1,2,3,4)
    //删除元素
    ms -= 1
    ms -= (1,2)
    val ms1 = mutable.Set(1,2)
    //删除集合
    //结果:res0: scala.collection.mutable.Set[Int] = Set(3, 4)
    ms --= ms1
    //成功返回true
    ms.remove(1)
    //只保留满足的集合
    //结果：234
    ms.retain(_ > 1)
    //清空集合
    ms.clear()
  }

  /**
    * 可变集合
    * 添加 Additions
    * +=
    * ++=
    * add
    */
  def mutableAdd(): Unit = {
    val ms = mutable.Set(1,2,3,4)
    //添加元素
    //结果：res0: scala.collection.mutable.Set[Int] = Set(1, 5, 2, 3, 4)
    ms += 5
    ms += (6,7,8)

    val ms1 = mutable.Set(10,11)
    //添加集合
    ms ++= ms1

    //已存在则返回false,不存在返回true
    ms.add(1)

  }

  /**
    * 二元操作 Binary Operations
    * &
    * intersect
    * |
    * union
    * &~
    * diff
    */
  def binaryOper(): Unit = {
    val s2 = Set(2,3)
    //两集合的交集
    //结果：s3: scala.collection.immutable.Set[Int] = Set(2, 3)
    val s3 = s1 & s2 //
    val s4 = s1.intersect(s2)

    val s5 = Set(6,7)
    //两集合合并
    //结果：s6: scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 7, 3, 4)
    val s6 =  s1 | s5
    val s7 = s1.union(s5)

    //集合一有，集合二没有的元素
    //结果：s8: scala.collection.immutable.Set[Int] = Set(5, 1, 2, 3, 4)
    val s8 = s1 &~ s5

  }

  /**
    * 删除 Removals
    * -
    * --
    * empty
    */
  def removalApi(): Unit = {
    //删除一个元素
    //结果：s3: scala.collection.immutable.Set[Int] = Set(5, 2, 3, 4)
    val s3 = s1 - 1

    //删除多个元素
    //结果:s4: scala.collection.immutable.Set[Int] = Set(5, 3, 4)
    val s4 = s1 - (1,2)
    //删除集合里的元素
    //结果:s5: scala.collection.immutable.Set[Int] = Set(5, 2, 3, 4)
    val s2 = Set(1,7)
    val s5 = s1 -- s2
    //清空集合
    s1.empty
  }

  /**
    * 添加 Additions
    * +
    * ++
    */
  def addtionApi(): Unit = {
    //添加一个元素
    //结果:s3: scala.collection.immutable.Set[Int] = Set(5, 1, 2, 7, 3, 4)
    val s3 = s1 + 7

    //添加多个元素
    //结果:s4: scala.collection.immutable.Set[Int] = Set(0, 5, 1, 9, 2, 3, 8, 4)
    val s4 = s1 + (8,9,0)

    //添加一个集合
    //结果:s5: scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 7, 3, 4)
    val s2 = Set(6,7)
    val s5 = s1 ++ s2
  }

  /**
    * 测试 Tests
    * contains
    * (x)
    * subsetOf
    */
  def testsApi(): Unit = {
    //判断集合中是否包含某个元素
    //结果:res0: Boolean = true
    s1.contains(2)
    //和上面一样
    s1(2)
    //判断集合一是否集合二的子集合
    //结果:res0: Boolean = true
    val s2 = Set(2,3,4)
    s2.subsetOf(s1)

  }

}
