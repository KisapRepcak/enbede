import scala.annotation.tailrec
import scala.language.postfixOps
object days {
  private val weekList = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  def main(args: Array[String]): Unit = {

    def week(a:List[String]):String = {
      var days:String = ""
      for (i <- a){
        days += i
        if(i != a.last) {days += ", "}
      }
      days
    }
    println("\n1a) Petla for\n"+week(weekList))

    def weekP(a:List[String]):String = {
      var days:String = ""
      for (i <- a){
        if(i.startsWith("P"))
          if(days == "") days += i
          else days += ", " + i
      }
      days
    }
    println("\n1b) Petla for, ale tylko na litere p\n"+weekP(weekList))

    def weekWhile(a:List[String]):String = {
      var days:String = ""
      var i:Int = 0
      while (i < a.length){
        days += a(i)
        if(a(i) != a.last) {days += ", "}
        i +=1
      }
      days
    }
    println("\n1c) While\n"+weekWhile(weekList))

    def weekRek(myList: List[String]):String={
      if (myList.isEmpty)
        ""
      else{
        myList.head + ", " + weekRek(myList.tail)
      }
    }
    println("\n2b) Rekurencyjnie\n"+weekRek(weekList))

    def weekRekTyl(myList:List[String]):String = {
      if (myList.isEmpty)
        ""
      else{
        myList.last + ", " + weekRekTyl(myList.init)
      }
    }
    println("\n2b) Rekurencyjnie od konca\n"+weekRekTyl(weekList))

    def tailRecWraper(myList:List[String]):String = {
      @tailrec
      def tailRec(x:List[String], accumulator1: String, accumulator2:String): String =
        if (x.isEmpty) accumulator2
        else tailRec(x.tail, ", ", accumulator2 + accumulator1 + x.head)
      tailRec(myList, "", "")
    }
    println("\n3) Rekurencja ogonowa\n"+tailRecWraper(weekList))

    def foldLeft(days:List[String]):String = {
      days.foldLeft("")(_+_+", ")
    }
    println("\n4a) FoldLeft\n"+foldLeft(weekList))

    def foldingRight(days:List[String]):String = {
      days.foldRight("")(_ + ", " + _)
    }
    println("\n4b) FoldRight\n"+foldingRight(weekList))

    def foldOnlyP(days:List[String]):String = {
      days.filter(_.startsWith("P")).foldRight("")(_ + ", " + _)
    }
    println("\n4c) Fold, ale tylko na litere p\n"+foldOnlyP(weekList))

    val phones = Map("Xiaomi" -> 1500, "Samsung" -> 2500, "OnePlus" -> 3500, "iPhone" -> 4500)
    val phones_sales = phones map {case (k, v) => (k, v * 0.9)}
    println("\n5) Mapowanie kolekcji\n"+phones_sales)

    val t = Tuple3(3, 5.5, "abc")
    def printTuple(myTuple: (Int, Double, String)): Any = {
      myTuple
    }
    println("\n6) Krotka\n"+printTuple(t))

    def show(x: Option[Int]) = x match {
      case Some(s) => s
      case None => "Nie ma takiego produktu :("
    }
    println("\n7) Options\n"+"phones.get(\"Samsung\") : "+show(phones.get("Ssamsung")))
    val listWithzeros = List(4, 7, 3, 0 ,4, 6, 0, 3, 8, 0, 2, 8, 5, 2, 0)
    def noZero(myList:List[Int], listAccumulator:List[Int] = List.empty):List[Int] = myList match {
      case Nil => listAccumulator.reverse
      case 0 :: x => noZero(x, listAccumulator)
      case y :: x => noZero(x, y :: listAccumulator)
    }
    println("\n8) Lista bez zer, rekurencja\n"+noZero(listWithzeros))

    val listInt: List[Int] = List(1, 4, 6, 9)
    def listIncr(myList:List[Int]):List[Int] = {
      myList map (n => n +1)
    }
    println("\n9) Lista z intami +1, mapowanie\n"+listIncr(listInt))

    val listInt2: List[Int] = List(1, 4, -5, 6, -2, 12)

    def listFiltr(myList:List[Int]):List[Int] = {
      myList.filter(x => x >= -5 && x <= 12).map(math.abs)

    }
    println("\n10) Lista z warosciami z przedzialu filtrowanie\n"+listFiltr(listInt2))
  }
}
