object cw2 {
  def main(args: Array[String]): Unit = {
//    zad1
    def check_day(day:String):String = day match  {
      case "Poniedzialek" | "Wtorek" | "Sroda" | "Czwartek" | "Piatek" => "Praca"
      case "Sobota" | "Niedziela" => "Weekend"
      case a => "Nie ma takiego dnia"
    }
    println(check_day("Wtorek"))
    println(check_day("Sobota"))
    println(check_day("lama"))
//   zad2



    class KontoBankowe(){
      private var _stanKonta = 0.0
      def this(stanKonta: Double){
        this()
        this._stanKonta=stanKonta
      }
      def podajstanKonta = _stanKonta

      def wyplata(money:Double): Unit = {
        if (_stanKonta < money) println("Nie ma tyle funduszy na koncie.")
        else _stanKonta -= money
      }

      def wplata(money:Double): Unit = {
        _stanKonta += money
      }
    }
    val d = new KontoBankowe
    println(d.podajstanKonta)
    d.wplata(123)
    println(d.podajstanKonta)
    d.wyplata(33)
    d.wyplata(999)
    println(d.podajstanKonta)

// zad 3
    case class Osoba(var imie:String, var nazwisko:String)
    val person1 = new Osoba("Tomek", "Kowalski")
    val person2 = new Osoba("Marek", "Kajak")
    val person3 = new Osoba("Marcelina", "Nowak")
    val person4 = new Osoba("Marysia", "Wieckiewicz")

    def greetings(man:Osoba): String = man match {
      case Osoba(imie, _) if man.imie == "Tomek" => "Hello Tomek, How are You?"
      case Osoba(imie, _) if man.nazwisko == "Nowak" => "Oh another one"
      case Osoba(imie, _) => "Hello " + man.imie + " " + man.nazwisko +", First time?"
    }
    println(greetings(person1))
    println(greetings(person2))
    println(greetings(person3))
    println(greetings(person4))

//  zad 4
    def fx(a: Int):Int = a*2
    def functionX(number:Int, fx: Int => Int):Int = {
      if (fx(number) >= 6) fx(number) * number * 2 * fx(number)
      else fx(number) + 4
    }
    print((functionX(4, fx)))
  }
}

