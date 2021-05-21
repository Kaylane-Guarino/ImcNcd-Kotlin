package br.senai.sp.jandira.imc_app_b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        // Declarar os componentes do nosso layout
        val textViewImc: TextView = findViewById(R.id.text_view_resultado_imc)
        val textViewStatus: TextView = findViewById(R.id.text_view_status_imc)
        val textViewDicaStatus: TextView = findViewById(R.id.text_view_dica_status)
        val textViewDica: TextView = findViewById(R.id.text_view_dica)
        val textViewTituloDica: TextView = findViewById(R.id.text_view_titulo_dica)

        // Recuperando o peso e a altura que estão na intent
        val isImcActivity = intent.getBooleanExtra("imc_activity", false)
        val isNcdActivity = intent.getBooleanExtra("ncd_activity", false)

        var result = 0.0
        var resultados = listOf<String>()

        if (isImcActivity){
            result = pegarValoresImc()
            // Recupera o status e a frase de status do IMC
            resultados = obterStatusImc(result)
            // Exibimos os resultados - Status e frase
            textViewStatus.text = resultados[0]
            textViewDicaStatus.text = resultados[1]
        }else if (isNcdActivity) {
            result = pegarValoresNcd()
            textViewStatus.setText("NE")
            textViewDicaStatus.visibility = View.GONE
        }


        // Exibimos o valor do IMC formatado com 1 casa decimal
        textViewImc.text = String.format("%.1f", result)

        // Recupera a dica do dia, que é um array (List<String>)
        val dica = getDica()

        // Exibimos a dica recuperadas no array
        textViewTituloDica.text = dica[0]
        textViewDica.text = dica[1]

    }

    private fun pegarValoresImc() : Double {
        val peso = intent.getDoubleExtra("peso", 3.9)
        val altura = intent.getDoubleExtra("altura", 0.0)

        // Cálculo do IMC
        return calcularImc(peso, altura)
    }

    private fun pegarValoresNcd() : Double {
        val peso = intent.getDoubleExtra("peso", 3.9)
        val idade = intent.getIntExtra("idade", 0)
        val atividade = intent.getStringExtra("atividade").toString()
        val sexo = intent.getStringExtra("sexo").toString()

        return  calcularNcd(sexo, idade, peso, atividade)
    }

}