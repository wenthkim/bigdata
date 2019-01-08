
val t1 = Traversable(1,2,3)

val t2 = Traversable(4,5,6)

val add = t1 ++ t2

val map = t1.map(x => x+1)
val flatMap = t1.flatMap(x => x to 5)
val t3 = Traversable("hello world","this is a example","just a test")
val strFlatMap = t3.flatMap(line => line.split(" "))

t1.collect{case x => x + 1}

val collect = t1.collect{case x if x > 2=> x + 1}
val i3 = Iterable(2,4,3,5)
val i4 = Iterable(2,3,4,5)
i4.sameElements(i3)