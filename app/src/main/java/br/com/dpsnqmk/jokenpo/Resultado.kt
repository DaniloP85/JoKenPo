package br.com.dpsnqmk.jokenpo

object Resultado {

    fun quemGanhou(jogador: String, android :String) :String {
        if (jogador == android){
            return "Empate"
        }

        if (jogador == "pedra" && android == "tesoura"){
            return "Você ganhou"
        }

        if (jogador == "papel" && android == "pedra"){
            return "Você ganhou"
        }

        if (jogador == "tesoura" && android == "papel"){
            return "Você ganhou"
        }

        return "Android ganhou"
    }
}