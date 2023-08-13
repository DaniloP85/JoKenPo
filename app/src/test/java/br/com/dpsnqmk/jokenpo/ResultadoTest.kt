package br.com.dpsnqmk.jokenpo

import org.junit.Assert
import org.junit.Test

class ResultadoTest {

    @Test
    fun deve_android_ganhar_quando_android_for_papel() {
        val resultado = Resultado.quemGanhou("pedra", "papel")
        Assert.assertEquals("Android ganhou", resultado)
    }
    @Test
    fun deve_android_ganhar_quando_android_for_pedra() {
        val resultado = Resultado.quemGanhou("tesoura", "pedra")
        Assert.assertEquals("Android ganhou", resultado)
    }

    @Test
    fun deve_android_ganhar_quando_android_for_tesoura() {
        val resultado = Resultado.quemGanhou("papel", "tesoura")
        Assert.assertEquals("Android ganhou", resultado)
    }

    @Test
    fun deve_empatar() {
        val resultado = Resultado.quemGanhou("papel", "papel")
        Assert.assertEquals("Empate", resultado)
    }

    @Test
    fun deve_jogador_ganhoar_quando_for_papel() {
        val resultado = Resultado.quemGanhou("papel", "pedra")
        Assert.assertEquals("Você ganhou", resultado)
    }

    @Test
    fun deve_jogador_ganhoar_quando_for_pedra() {
        val resultado = Resultado.quemGanhou("pedra", "tesoura")
        Assert.assertEquals("Você ganhou", resultado)
    }

    @Test
    fun deve_jogador_ganhoar_quando_for_tesoura() {
        val resultado = Resultado.quemGanhou("tesoura", "papel")
        Assert.assertEquals("Você ganhou", resultado)
    }
}