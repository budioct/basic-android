package com.tutorial

import org.junit.Assert
import org.junit.Test

class HelloTest {

    // package org.junit.Test            versi 4
    // package org.junit.jupiter.Test    versi 5

    @Test
    fun testSayHello(){

        val name = Hello.sayHello("budhi", "octaviansyah") // sayHello dari object class kotlin (akan menjadi object static)

        Assert.assertEquals("Hello broo budhi octaviansyah", name)

    }

}