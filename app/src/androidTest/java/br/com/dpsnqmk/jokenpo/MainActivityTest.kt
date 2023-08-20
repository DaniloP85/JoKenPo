package br.com.dpsnqmk.jokenpo

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.containsString
import org.junit.Test

class MainActivityTest {

    @Test
    fun deve_empatar(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.editTextAndroid)).perform(ViewActions.typeText("papel"))
        onView(withId(R.id.papel)).perform(ViewActions.click())
        onView(withId(R.id.tvResultado)).check(matches(withText(containsString("Empate"))))
    }

    @Test
    fun deve_Android_ganhar(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.editTextAndroid)).perform(ViewActions.typeText("papel"))
        onView(withId(R.id.pedra)).perform(ViewActions.click())
        onView(withId(R.id.tvResultado)).check(matches(withText(containsString("Android ganhou"))))
    }

    @Test
    fun deve_Jogador_ganhar(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.editTextAndroid)).perform(ViewActions.typeText("tesoura"))
        onView(withId(R.id.pedra)).perform(ViewActions.click())
        onView(withId(R.id.tvResultado)).check(matches(withText(containsString("Você ganhou"))))
    }
}