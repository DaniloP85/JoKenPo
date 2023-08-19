package br.com.dpsnqmk.jokenpo

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Test

class MainActivityTest {

    @Test
    fun deve_verificar_texto_fixo_na_tela(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(ViewMatchers.withText("JoKenPo")).check(matches(isDisplayed()))
        onView(ViewMatchers.withText("Última Jogada")).check(matches(isDisplayed()))
        onView(ViewMatchers.withText("Resultado")).check(matches(isDisplayed()))
        onView(ViewMatchers.withText("Placar")).check(matches(isDisplayed()))
    }

    @Test
    fun deve_verificar_os_elementos_em_tela(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.papel)).check(matches(isDisplayed()))
        onView(withId(R.id.pedra)).check(matches(isDisplayed()))
        onView(withId(R.id.tesoura)).check(matches(isDisplayed()))
        onView(withId(R.id.ivVoce)).check(matches(isDisplayed()))
        onView(withId(R.id.ivAndroid)).check(matches(isDisplayed()))
    }

    @Test
    fun click(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.papel)).perform(ViewActions.click())
        //onView(withId(R.id.tvResultado)).check(matches(withText(containsString("Empate"))))
    }
}