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
    private var pontuacaoAndroid: Int = 0
    private var pontuacaoJogador: Int = 0
    private var pedra: String = "pedra"
    private var tesoura: String = "tesoura"
    private var papel: String = "papel"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvPlacarAndroid.text = pontuacaoAndroid.toString()
        binding.tvPlacarVc.text = pontuacaoJogador.toString()

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
        val array = arrayOf(pedra, tesoura, papel)

        configuraImagemDaJogada(jogadaUsuario, binding.ivVoce)
        configuraImagemDaJogada(array[jogadaAdversario], binding.ivAndroid)
        val resultado = Resultado.quemGanhou(jogadaUsuario, array[jogadaAdversario])
        when (resultado){
            "Você ganhou" -> {
                pontuacaoJogador += 1
                atualizaPontuacao(pontuacaoJogador, binding.tvPlacarVc)
            }
            "Android ganhou" -> {
                pontuacaoAndroid += 1
                atualizaPontuacao(pontuacaoAndroid, binding.tvPlacarAndroid)
            }
        }

        binding.tvResultado.text = resultado
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

    private fun atualizaPontuacao(pontuacao: Int, elmentoEmTela: TextView) {
        elmentoEmTela.text = pontuacao.toString()
    }
}