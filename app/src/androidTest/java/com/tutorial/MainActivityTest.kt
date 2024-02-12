package com.tutorial

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class) // jika ingin menjalankan library Espresso (UI Test Automation(Robot pengerak))
class MainActivityTest {

    /**
     * kotlin generic
     * Any adalah super type dari kotlin
     * invariant         tidak bisa di subtitusi dari super type (parent) dan sub type (child) --> SuperType<Any> <---> x SubType<String>
     * covariant         bisa di subtitusi dari sub type (child) ke super type (parent) --> SubType<out T>=   SubType<String>  <---> v SuperType<Any>
     * contravariant     bisa di subtitusi dari super type (parent) ke sub type (child) --> SuperType<in T>=  SubType<Any>  <---> v SuperType<String>
     *
     * java generic
     * Object adalah super type dari java
     * invariant         tidak bisa di subtitusi dari super type (parent) dan sub type (child) --> SuperType<Object> <---> x SubType<String>
     * covariant         bisa di subtitusi dari sub type (child) ke super type (parent) --> SubType<? extends Object>=   SubType<String>  <---> v SuperType<Object>
     * contravariant     bisa di subtitusi dari super type (parent) ke sub type         --> SuperType<? super String>=   SuperType<Object>  <---> v SubType<String>
     *
     */


    // manual
//    lateinit var mainActivityScenario: ActivityScenario<MainActivity> // ActivityScenario<A extends Activity> implements AutoCloseable, Closeable // initialization Scenario
//
//    @Before // di jalankan awal sebelum unit test
//    fun setUp(){
//
//        mainActivityScenario = ActivityScenario.launch(MainActivity::class.java) // static <A extends Activity> ActivityScenario<A> launch(Class<A> activityClass) // mejalankan ActivityScenario
//    }
//
//    @After // di jalankan setelah unit testing
//    fun tearDwon(){
//
//        mainActivityScenario.close() // void close() //
//    }

    // otomatis tanpa harus, lauch dan close object mainActivityScenario
    @get:Rule
    var mainActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java) // initialization Scenario // menjalankan UI Main Activity

    @Test
    fun testsayHello(){

        /**
         * Instrumentation Test (melakukan test dengan secara otomatis)
         * ketika di jalankan dia akan mengirim ke android dan di teruskan ke MainActivity.. setelah selesai di close() lagi
         */

        val context = ApplicationProvider.getApplicationContext<Context>() // untuk mendapatkan context provider android
        val name = "budhi"

        // ketik ada Id nya maka ketikan sesuai variable
        Espresso.onView(ViewMatchers.withId(R.id.nameEditText))
            .perform(ViewActions.typeText(name))

        // ketika ada view dengan Id nya maka klik button
        Espresso.onView(ViewMatchers.withId(R.id.sayHelloButton))
            .perform(ViewActions.click())

        // untuk check apakah berubah, dan pastikan dengan match value yang ada MainActiviry dengan unit testing
        Espresso.onView(ViewMatchers.withId(R.id.sayHelloTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText(context.getString(R.string.sayHelloTextView, name))))

        Thread.sleep(2000L)

    }

}