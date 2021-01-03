object cw9 {
  def main(args: Array[String]): Unit = {
//    1.
    class Container[A](private val value: A) {
      def getContent: A = value
      def applyFunction[R](fun: A => R): R = {
        fun(value)
      }
    }

    val cw91 = new Container[String]("some string")
    val content = cw91.getContent
    print(content+"\n")
    val content2 = cw91.applyFunction((x: String) => x.length)
    println(content2)

//    2.
    trait Maybe[+A]

    class No extends Maybe[Nothing]

    class Yes[A](val value: A) extends Maybe[A]

    val nope = new No
    val yeap = new Yes("something")
    val is_nope = nope.isInstanceOf[Maybe[_]]
    val is_yeap = yeap.isInstanceOf[Maybe[_]]
    println("NO: " + is_nope + " \nYes: " + is_yeap)

//    3.
    class AnswerContainer[A](private val value: Maybe[A]){
      def applyFunction[R](fun: A => R): Maybe[R] = {
        if (value.isInstanceOf[No]) {
          new No
        }
        else{
          new Yes[R](fun(value.asInstanceOf[Yes[A]].value))
        }

      }
}
    val c = new AnswerContainer[String](new Yes[String]("test"))
    println(c.applyFunction((x: String) => x.length).asInstanceOf[Yes[Int]].value)
//    4.
//TODO

  }
}