// zad 5
object cw2more {
  class Osoba(val imie: String, val nazwisko: String, _podatek: Double){
    def podatek = _podatek
  }

  trait Pracownik extends Osoba {
    var _pensja = 2000.00
    def pensja: Double = _pensja
    def pensja_=(value: Double): Unit = _pensja = value
    override def podatek = 0.2 * pensja
  }

  trait Nauczyciel extends Pracownik {
    override def podatek = 0.1 * pensja
  }

  trait Student extends Osoba {
    override def podatek = 0.0
  }

  def main(args: Array[String]): Unit = {
        val student = new Osoba("Jan", "Kowalski", 45.0) with Student
        val nauczyciel = new Osoba("Czesiek", "Bojanek", 45.0) with Pracownik
        val pracownik = new Osoba("Mietek", "Mazur", 45.0) with Pracownik
        val pracstud =  new Osoba("Stasiek", "Pies", 45.0) with Pracownik with Student
        val studprac =  new Osoba("Stasiek", "Kot", 45.0)  with Student with Pracownik
        println(student.nazwisko)
        println(student.podatek)
        println(nauczyciel.nazwisko)
        nauczyciel.pensja = 4000.0
        println(nauczyciel.podatek)
        pracownik.pensja = 6000.0
        println(pracownik.nazwisko)
        println(pracownik.podatek)
        println(pracstud.nazwisko)
        println(pracstud.podatek)
        println(studprac.nazwisko)
        println(studprac.podatek)
      }
}
