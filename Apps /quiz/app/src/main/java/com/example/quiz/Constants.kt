package com.example.quiz

object Constants {

    fun getQuestion() : ArrayList<Question>{

        val questionsList = ArrayList<Question>()

        val que1 = Question(1,
            "Quien no es GOGOGO?",
            R.drawable.potaxie1,
            "JIAFEI",
            "CUPPCAKE",
            "AIMEP3", "TERNURA69",
            3)



        val que2 = Question(2,
            "Pinpon se lava la carita con?", R.drawable.potaxie2,
            "AGUA Y JABON ",
            "DETERGENTE DE COCINA",
            "TIERRA",
            "SOLO AGUA",
            1)


        val que3 = Question(3,
            "Quien es la creadora del GOGOGO", R.drawable.potaxie3,
            "JIAFEI",
            "BRITNEY SPEARS",
            "TERNURA69",
            "CUPCAKKE",
            4)


        val que4 = Question(4,
            "Quien es la reina Potaxie?", R.drawable.potaxie4,
            "CUPCAKKE",
            "MADONNA",
            "JIAFEI",
            "TERNURA69",
            3)


        val que5 = Question(5,
            "Deja el bullying...", R.drawable.potaxie5,
            "NO ES BUENO",
            "NO ES GOGOGO",
            "ES BUENO",
            "NO ES POSAY",
            1)




        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)





        return questionsList
    }

}