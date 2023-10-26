package com.example.homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private var userInput: String = ""
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        ბათონის, ტექსტვიუს და ედითტექსტის ინიციალიზაცია
        val button: Button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)

        button.setOnClickListener() {
            val editText: EditText = findViewById(R.id.editText)
            userInput = editText.text.toString()
            logic()
        }
    }

    //    მთავარი ლოგიკა სადაც ხდება ტექსტვიუში ინფუთის გამოტანა
    private fun logic() {
        if (userInput.getOrNull(0)?.isDigit() == true && userInput.isNotEmpty()) {
            if (userInput[0] != '-' && userInput[0] > '0') {
                if (userInput.length == 3) {
                    if (userInput[1] == '0' && userInput[2] == '0') {
                        textView.text = hundreds(userInput[0].toString())
                    } else if (userInput[1] != '0' && userInput[2] == '0') {
                        textView.text = hundreds(userInput[0].toString()).dropLast(1).plus(" ")
                            .plus(twoDigits(userInput[1].toString()))
                    } else if (userInput[1] == '0' && userInput[2] != '0') {
                        textView.text = hundreds(userInput[0].toString()).dropLast(1).plus(" ")
                            .plus(digits(userInput[2].toString()))
                    } else {
                        if (userInput[1] == '2' || userInput[1] == '4' || userInput[1] == '6' || userInput[1] == '8') {
                            textView.text = hundreds(userInput[0].toString()).dropLast(1).plus(" ")
                                .plus(daebi(userInput[1].toString()))
                                .plus(digits(userInput[2].toString()))
                        } else {
                            textView.text = hundreds(userInput[0].toString()).dropLast(1).plus(" ")
                                .plus(daebi(userInput[1].toString()))
                                .plus(elevenToTwenty(userInput[2].toString()))
                        }
                    }
                } else if (userInput.length == 2) {
                    if (userInput[1] == '0') {
                        textView.text = twoDigits(userInput[0].toString())
                    } else if (userInput[1] != '0') {
                        if (userInput[0] == '1') {
                            textView.text = elevenToTwenty(userInput[1].toString())
                        } else if (userInput[0] == '2' || userInput[0] == '4' || userInput[0] == '6' || userInput[0] == '8') {
                            textView.text =
                                daebi(userInput[0].toString()).plus(digits(userInput[1].toString()))
                        } else {
                            textView.text =
                                daebi(userInput[0].toString()).plus(elevenToTwenty(userInput[1].toString()))
                        }
                    }
                } else if (userInput.length == 1) {
                    textView.text = digits(userInput[0].toString())
                } else if (userInput == "1000") {
                    textView.text = "ათასი"
                } else {
                    Toast.makeText(
                        applicationContext,
                        "გთხოვთ შეიყვანოთ რიცხვი 1-დან 1000-მდე",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        }
        Toast.makeText(
            applicationContext,
            "გთხოვთ შეიყვანოთ რიცხვი 1-დან 1000-მდე",
            Toast.LENGTH_LONG
        ).show()
    }

    //    1 ციფრიანი
    private fun digits(number: String): String {
        return when (number) {
            "1" -> "ერთი"
            "2" -> "ორი"
            "3" -> "სამი"
            "4" -> "ოთხი"
            "5" -> "ხუთი"
            "6" -> "ექვსი"
            "7" -> "შვიდი"
            "8" -> "რვა"
            "9" -> "ცხრა"

            else -> "არასწორი ინფუთი"
        }
    }

    //    დაები :D
    private fun daebi(number: String): String {
        return when (number) {
            "1" -> ""
            "2" -> "ოცდა"
            "3" -> "ოცდა"
            "4" -> "ორმოცდა"
            "5" -> "ორმოცდა"
            "6" -> "სამოცდა"
            "7" -> "სამოცდა"
            "8" -> "ოთხმოცდა"
            "9" -> "ოთხმოცდა"

            else -> "არასწორი ინფუთი"
        }
    }

    //    ორ ციფრიანი
    private fun twoDigits(number: String): String {
        return when (number) {
            "1" -> "ათი"
            "2" -> "ოცი"
            "3" -> "ოცდაათი"
            "4" -> "ორმოცი"
            "5" -> "ორმოცდაათი"
            "6" -> "სამოცი"
            "7" -> "სამოცდაათი"
            "8" -> "ოთხმოცი"
            "9" -> "ოთხმოცდაათი"

            else -> "არასწორი ინფუთი"
        }
    }


    //    11 დან 20 მდე
    private fun elevenToTwenty(number: String): String {
        return when (number) {
            "1" -> "თერთმეტი"
            "2" -> "თორმეტი"
            "3" -> "ცამეტი"
            "4" -> "თოთხმეტი"
            "5" -> "თხუტმეტი"
            "6" -> "თექვსმეტი"
            "7" -> "ჩვიდმეტი"
            "8" -> "თვრამეტი"
            "9" -> "ცხრამეტი"

            else -> "არასწორი ინფუთი"
        }
    }

    //    ასები
    private fun hundreds(number: String): String {
        return when (number) {
            "1" -> "ასი"
            "2" -> "ორასი"
            "3" -> "სამასი"
            "4" -> "ოთხასი"
            "5" -> "ხუთასი"
            "6" -> "ექვსასი"
            "7" -> "შვიდასი"
            "8" -> "რვაასი"
            "9" -> "ცხრაასი"

            else -> "არასწორი ინფუთი"
        }
    }
}