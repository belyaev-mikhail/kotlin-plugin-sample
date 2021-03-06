/*
 * Copyright (C) 2021 Mikhail Belyaev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.spbstu

import org.junit.Test
import ru.spbstu.executeExpr
import ru.spbstu.executeSource
import kotlin.test.assertEquals

class CompilerTest {
    @Test
    fun simple() {
        assertEquals(2, executeExpr("2"))
        assertEquals(
            2, executeSource(
                """
        annotation class DataLike(val genEquals: Boolean = true)
        const val dddd = true
        fun <T> generated(): T = TODO()
        @DataLike(dddd)
        class Data(val x: Int, val y: List<String>?): Comparable<Data> {
            override fun compareTo(other: Data): Int = generated() 
        }
        fun main(): Int {
            val data1 = Data(1, listOf())
            println(data1)
            return if (Data(2, listOf()) == Data(2, listOf())) 2 else 3
        }
    """
            )
        )
    }
}
