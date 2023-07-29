package br.com.dpsnqmk.jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import br.com.dpsnqmk.jokenpo.databinding.ActivityMainBinding
import java.util.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var androidScore: Int = 0
    private var playerScore: Int = 0
    private var pedra: String = "pedra"
    private var tesoura: String = "tesoura"
    private var papel: String = "papel"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvPlacarAndroid.text = androidScore.toString()
        binding.tvPlacarVc.text = playerScore.toString()

        binding.papel.setOnClickListener {
            realizarJogada(papel)
        }

        binding.pedra.setOnClickListener {
            realizarJogada(pedra)
        }

        binding.tesoura.setOnClickListener {
            realizarJogada(tesoura)
        }
    }

    private fun realizarJogada(jogadaUsuario: String) {
        val jogadaAdversario = Random().nextInt(3)
        val arr = arrayOf(pedra, tesoura, papel)

        configuraImagemDaJogada(jogadaUsuario, binding.ivVoce)
        configuraImagemDaJogada(arr[jogadaAdversario], binding.ivAndroid)
        binding.tvResultado.text = definiGanhador(jogadaUsuario, arr[jogadaAdversario])
    }

    private fun configuraImagemDaJogada(jogada: String, imageView: ImageView) {
        when(jogada) {
            pedra -> {configuraImagem(R.drawable.pedra, imageView)}
            tesoura -> {configuraImagem(R.drawable.tesoura, imageView)}
            papel -> {configuraImagem(R.drawable.papel, imageView)}
        }
    }

    private fun configuraImagem(resourceID: Int, imageView: ImageView) {
        imageView.setImageDrawable(ContextCompat.getDrawable(this, resourceID))
    }

    private fun updateScore(score: Int, element: TextView){
        element.text = score.toString()
    }

    private fun definiGanhador(jogador: String, android :String) :String {
        if (jogador == android){
            return "Empate"
        }

        if (jogador == pedra && android == tesoura){
            playerScore += 1
            updateScore(playerScore, binding.tvPlacarVc)
            return "Você ganhou"
        }

        if (jogador == papel && android == pedra){
            playerScore += 1
            updateScore(playerScore, binding.tvPlacarVc)
            return "Você ganhou"
        }

        if (jogador == tesoura && android == papel){
            playerScore += 1
            updateScore(playerScore, binding.tvPlacarVc)
            return "Você ganhou"
        }

        androidScore += 1
        updateScore(androidScore, binding.tvPlacarAndroid)
        return "Android ganhou"
    }
}