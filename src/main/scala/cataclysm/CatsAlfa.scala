package cataclysm

import cats._
import cats.instances.all._
import cats.syntax.all._

class CatsAlfa {

  def First(): Unit = {
    val f: String => Int = _.length

    //Applying function f to List passed to fmap function
    val result = Functor[List].fmap(List("scala", "cataclysm"))(f)
    println(s"Functor for List: $result")

    //Without toMap it returns List like List("scala", 5)
    val output = List("scala", "cataclysm").fproduct(f).toMap
    println(s"Functor fproduct function for List: $output")

    val g: Int => Int = _ + 1

    val res1 = Functor[Option].fmap(Some(3))(g)
    println(s"Option functor: $res1")

    val res2 = Option(4).fproduct(g).toMap
    println(s"fproduct Functor function for Option: $res2")
  }

  def Second(): Unit ={
    val addASymbol: String => String = _ + "_A"

    val res1 = Apply[List].ap(List(addASymbol))(List("A", "B", "C"))
    println(s"Apply for List: $res1")

    val res2 = Apply[Option].ap(Some(addASymbol))(Some("Sat"))
    println(s"Apply for Option: $res2")

    val res3 = (addASymbol).some ap Some("Artur")
    println(s"Apply for Option with less typing: $res3")

    val res4 = List(addASymbol) ap List("Daulet")
    println(s"Apply for List with less typing: $res4")
  }

  def Third(): Unit = {
    println("Applicative ------->")

    val res1 = Applicative[Option].pure(3)
    println(s"Applicative on Option: $res1")

    val res2 = Applicative[List].pure(4, 7)
    println(s"Applicative on List: $res2")

    println("Semigroup ---------->")

    val res3 = 3.combine(7)
    println(s"Semigroup on Int: $res3")

    val res4 = Option(5).combine(None)
    println(s"Semigroup on Option[Int]: $res4")

    val res5 = Option(7).combine(Option(3))
    println(s"Semigroup on Option[Int]: $res5")

    val res6 = List(1, 2, 3) |+| List(3, 6, 7)
    println(s"Symbolic operator for Semigroup |+| (Example for List): $res6")

    println("Monoid ------------->")

    val intAddition = new Monoid[Int]{
      override def combine(x: Int, y: Int): Int = x + y

      override def empty: Int = 0
    }

    val res7 = List(1, 2, 3).fold(intAddition.empty)(intAddition.combine)
    println(s"Monoid intAddition for List of Ints: $res7")

    val res8 = Monoid[Map[String, Int]].combineAll(List(Map("a" -> 1, "b" -> 7), Map("a" -> 3)))
    println(s"Monoid's combineAll for Map[String, Int] : $res8")
  }

  def Fourth(): Unit = {
    
  }

}
