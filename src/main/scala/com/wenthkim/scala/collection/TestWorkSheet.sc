import scala.collection.mutable

val t1 = Traversable(1,2,3)

val t2 = Traversable(4,5,6)

val add = t1 ++ t2

val map = t1.map(x => x+1)
val flatMap = t1.flatMap(x => x to 5)
val t3 = Traversable("hello world","this is a example","just a test")
val strFlatMap = t3.flatMap(line => line.split(" "))
val s1 = Seq(1,2,3,4,5)
val s2 = Seq(6,7,8,9,10)
val s3 = Seq(0,1,2,3,4)
val s4 = Seq(1,1,2,3,2,3,4)
val buffer = mutable.Buffer(1,2,3,4,5)
buffer.clear()
buffer.foreach(print(_))