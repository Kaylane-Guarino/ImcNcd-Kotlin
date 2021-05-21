package br.senai.sp.jandira.imc_app_b

fun calcularNcd(sexo: String, idade: Int, peso: Double, atividade: String) : Double { // Retorna o que? int  / sei la

    var resultado : Double = 0.0
    var resultAtividade : Double = 0.0

    if (sexo == "Feminino"){

        if (idade >= 18 && idade < 30){

            resultado = 14.7 * peso + 496

        }else if (idade >= 31 && idade <= 60){

            resultado = 8.7 * peso + 829

        }else if (idade > 60){

            resultado = 10.5 * peso + 596

        }



        if (atividade == "Leve"){

            resultAtividade = resultado * 1.6

        }else if (atividade == "Moderado"){

            resultAtividade = resultado * 1.6

        }else if (atividade == "Intenso"){

            resultAtividade = resultado * 1.8

        }else if (atividade == "Nenhuma"){
            resultAtividade = resultado
        }

    } else{
        if (idade >= 18 && idade < 30){

            resultado = 15.3 * peso + 679

        }else if (idade >= 31 && idade <= 60){

            resultado = 11.6 * peso + 879

        }else if (idade > 60){

            resultado = 13.5 * peso + 487

        }

        if (atividade == "Leve"){

            resultAtividade = resultado * 1.5

        }else if (atividade == "Moderado"){

            resultAtividade = resultado * 1.8

        }else if (atividade == "Intenso"){

            resultAtividade = resultado * 2.1

        }else if (atividade == "Nenhuma"){
            resultAtividade = resultado
        }
    }

    return resultAtividade

}