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

}
