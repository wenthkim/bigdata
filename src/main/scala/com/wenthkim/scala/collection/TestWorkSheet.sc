
import scala.collection.mutable

val t1 = Traversable(1,2,3)

val t2 = Traversable(4,5,6)

val add = t1 ++ t2

val muMap1 = mutable.Map("k1" -> "v1","k2" -> "v2")
val muMap2 = mutable.Map("k4" -> "v4","k5" -> "v5")
val keys = muMap1.keys
muMap1.put("k3","v3")
for (elem <- keys) {
  print(muMap1(elem))
}
