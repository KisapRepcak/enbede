object cw10 {
//  1.
  println("1.\n")
  def main(args: Array[String]): Unit = {
    def mutagenic = for {
      num_int <- Iterator.from(1)
      num_div <- 1 until (num_int + 1)
      if num_int % num_div == 0
    } yield (num_int, num_div)

    val mutagenic_buffe = mutagenic.buffered

    println(mutagenic_buffe.next)
    mutagenic_buffe take 9 foreach println
    println(mutagenic_buffe.next)
    println(mutagenic_buffe.next)
    println(mutagenic_buffe.next)
    mutagenic_buffe take 7 foreach println

    //Zad 2:
    println("\n2.\n")

    trait Maybe[+A] {

      def getContent: A

      def map[B](function: A => B): Maybe[B] = {
        if (this.isInstanceOf[No]) {
          new No
        }
        else {
          val yep = this.asInstanceOf[Yes[A]]
          new Yes(function(yep.value))
        }
      }

      def flatMap[B](function: A => Maybe[B]): Maybe[B] = {
        if (this.isInstanceOf[No]) {
          new No
        }
        else {
          val yep = this.asInstanceOf[Yes[A]]
          function(yep.value)
        }
      }
    }

    class No extends Maybe[Nothing] {
      override def getContent = throw new NoSuchElementException()
    }

    class Yes[A](val value: A) extends Maybe[A] {
      override def getContent: A = value
    }

    val nop: Maybe[String] = new No
    println(nop.map(_ * 7))
    val yes2: Maybe[String] = new Yes("stokrotka")
    println(yes2.flatMap((mon: String) => new Yes(mon)).getContent)
  }

}
