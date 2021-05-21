package br.senai.sp.jandira.imc_app_b

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class NcdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ncd)

        val buttonCalcular : Button = findViewById(R.id.button_calcular_ncd)
        val editTextPeso : EditText = findViewById(R.id.edit_text_peso)
        val editTextIdade : EditText = findViewById(R.id.edit_text_idade)
        val spinnerAtividade : Spinner = findViewById(R.id.spinner)
        val radioGroup : RadioGroup = findViewById(R.id.radio_button)

        var grupo : RadioGroup

        buttonCalcular.setOnClickListener {
            val itemSelecionado = spinnerAtividade.getItemAtPosition(spinnerAtividade.selectedItemPosition).toString()
            val radioSelecionado: RadioButton = findViewById(radioGroup.checkedRadioButtonId)

            if (editTextPeso.text.isEmpty()) {
                editTextPeso.error = ""
                showMessage("O campo peso é obrigatório!")

            }else if (editTextIdade.text.isEmpty()){
                editTextIdade.error = "Você não me disse o sua idade!"
                showMessage("O campo idade é obrigatório!")
            }else if (itemSelecionado.equals("Selecione")){
                (spinnerAtividade.selectedView as TextView).error = "Você precisa selecionar um nivel."
                showMessage("Você precisa selecionar um nivel!")
            }else{


                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("ncd_activity", true)
                intent.putExtra("peso", editTextPeso.text.toString().toDouble())
                intent.putExtra("idade", editTextIdade.text.toString().toInt())
                intent.putExtra("atividade", itemSelecionado) //Double é numero e voce tem "átivo por exemplo, isso nao é double / numero
                intent.putExtra("sexo", radioSelecionado.text.toString())

//                showMessage(radioSelecionado.text.toString())
                startActivity(intent)
            }
        }

    }

    private  fun showMessage(mensagem: String){
        val snack = Snackbar.make(window.decorView.rootView, mensagem, Snackbar.LENGTH_LONG)
        snack.setAction("Fechar"){snack.dismiss()}
        snack.show()
    }

}