
val t1 = Traversable(1,2,3)

val t2 = Traversable(4,5,6)

val add = t1 ++ t2

val map = t1.map(x => x+1)
val flatMap = t1.flatMap(x => x to 5)
val t3 = Traversable("hello world","this is a example","just a test")
val strFlatMap = t3.flatMap(line => line.split(" "))

t1.collect{case x => x + 1}

val collect = t1.collect{case x if x > 2=> x + 1}

t1.hasDefiniteSize
val t5 = Traversable(1,2,3,4,5,6)
val strBuffer = new StringBuilder()
t1.addString(strBuffer,"[",",","]")