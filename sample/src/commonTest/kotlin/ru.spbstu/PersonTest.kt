package ru.spbstu

import kotlin.test.Test
import kotlin.test.assertTrue

class PersonTest {

    data class MultipleCustom(val data: Array<Expr>)

    @Test
    fun smokey() {
        assertTrue { Binary(Var("x"), Val(10), "+") == Binary(Var("x"), Val(10), "+") }
        assertTrue { Binary(Var("x"), Val(10), "+") <= Binary(Var("x"), Val(10), "+") }
        assertTrue { Var("a") < Var("b") }
        assertTrue { Val(12) < Val(13) }

//        val mm = Multiple(Var("x"), Var("y"), Var("z"))
//        val mm1 = Multiple(Var("x"), Var("y"), Var("z"))
//        println(mm == mm1)
//        println("mm = $mm")
//        println("mm.hashCode() = ${mm.hashCode()}")
//        //assertTrue { mm.hashCode() == mm1.hashCode() }
//        val mmc = MultipleCustom(arrayOf(Var("x"), Var("y"), Var("z")))
//        println("mmc = $mmc")
//        println("mmc.hashCode() = ${mmc.hashCode()}")
    }
}
