package com.wenthkim.scala.collection

import scala.collection.mutable

/**
  * @Author wsj
  * @Date 2019/1/31 10:47
  * @Description
  *
  */
object MapApi {


  val map1 = Map("k1" -> "v1","k2" -> "v2", "k3" -> "v3")
  val map2 = Map("k4" -> "v4","k5" -> "v5", "k5" -> "v5")

  def main(args: Array[String]): Unit = {
    //lookup 查看
    lookupApi()
    //Additions and updates 增加和更新
    addtionAndUpdate()
    //Removals 删除
    removals()
    //Subcollections 子集合
    subcollections()
    //Transformation 转换
    transformation()
    //mutable.Map Removals
    removal()
    //mutable.Map additionAndUpdate
    additionAndUpdate()
  }

  val muMap1 = mutable.Map("k1" -> "v1","k2" -> "v2")
  val muMap2 = mutable.Map("k4" -> "v4","k5" -> "v5")


  /**
    * mutable.Map Removals
    * -=
    * --=
    * remove
    * retain
    * clear
    */
  def removal(): Unit ={
    muMap1 -= ("k1")
    muMap1 --= mutable.Set("k1","k2")
    muMap1.remove("k1")
    muMap1.retain((_,value) => value.length > 2)
    muMap1.clear()
  }



  /**
    * mutable.Map
    * Additions and Updates
    * update
    * +=
    * +=
    * ++=
    * put
    * getOrElseUpdate
    */
  def additionAndUpdate(): Unit = {
    //更新值
    //v2v111
    muMap1.update("k1","v111")
    val keys = muMap1.keys
    for (elem <- keys) {
      print(muMap1(elem))
    }
    //添加
    //v2v5v4v1v3
    muMap1 += ("k3" -> "v3")
    muMap1 += ("k4" -> "v4", "k5" -> "v5")
    for (elem <- keys) {
      print(muMap1(elem))
    }
    //两集合相加
    //v2v5v4v1
    muMap1 ++= muMap2
    for (elem <- keys) {
      print(muMap1(elem))
    }
    //添加
    //v2v1v3
    muMap1.put("k3","v3")
    for (elem <- keys) {
      print(muMap1(elem))
    }
    //获取到k4直接返回value,获取不到则插入("k4"->"v4")
    muMap1.getOrElseUpdate("k4","v4")
  }



  /**
    * Transformation 转换
    * filterKeys
    * mapValues
    */
  def transformation(): Unit = {
    //跟据key过滤
    // res0: scala.collection.immutable.Map[String,String] = Map(k1 -> v1)
    map1.filterKeys(key => key.contains(1))
    //遍历value,做对应操作
    //res0: scala.collection.immutable.Map[String,String] = Map(k1 -> v1hello, k2 -> v2hello, k3 -> v3hello)
    map1.mapValues(value => value+"hello")
  }


  /**
    * Subcollections 子集合
    * keys
    * keySet
    * keysIterator
    * values
    * valuesIterator
    */
  def subcollections(): Unit = {
    //res0: Iterable[String] = Set(k1, k2, k3)
    map1.keys
    //res0: scala.collection.immutable.Set[String] = Set(k1, k2, k3)
    map1.keySet
    //获取key的迭代器
    //k1k2k3
    val it = map1.keysIterator
    for (elem <- it) {
      print(elem)
    }
    //res0: Iterable[String] = MapLike.DefaultValuesIterable(v1, v2, v3)
    map1.values

    //v1v2v3
    val v1 = map1.valuesIterator
    for (elem <- v1) {
      print(elem)
    }

  }

  /**
    * Removals 删除
    * -
    * --
    */
  def removals(): Unit = {
    //res0: scala.collection.immutable.Map[String,String] = Map(k2 -> v2, k3 -> v3)
    map1 - ("k1")
    //res0: scala.collection.immutable.Map[String,String] = Map(k3 -> v3)
    map1 - ("k1","k2")
    //res0: scala.collection.immutable.Map[String,String] = Map(k1 -> v1)
    val set = Set("k2", "k3")
    map1 -- set
  }

  /**
    * Additions and updates 增加和更新
    * +
    * ++
    * updated
    */
  def addtionAndUpdate(): Unit = {
    //res0: scala.collection.immutable.Map[String,String] = Map(k1 -> v1, k2 -> v2, k3 -> v3, k10 -> v10)
    map1 + ("k10" -> "v10")
    //res0: scala.collection.immutable.Map[String,String] = Map(k2 -> v2, k11 -> v11, k10 -> v10, k1 -> v1, k3 -> v3)
    map1 + ("k10" -> "v10","k11" -> "v11")
    //res0: scala.collection.immutable.Map[String,String] = Map(k1 -> 1, k2 -> v2, k3 -> v3)
    map1.updated("k1","1")
  }


  /**
    * lookup 查看
    * get
    * ()
    * getOrElse
    * contains
    * isDefinedAt
    */
  def lookupApi(): Unit = {
    //res0: Option[String] = Some(v1)
    map1.get("k1")
    //res1: String = v1
    map1("k1")
    //res0: String = v1
    map1.getOrElse("k1","default")
    //res0: Boolean = false
    map1.contains("k4")
    //res0: Boolean = true
    map1.isDefinedAt("k1")
  }



}
