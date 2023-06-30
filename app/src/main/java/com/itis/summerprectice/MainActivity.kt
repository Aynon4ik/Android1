
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.itis.summerprectice.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.textView)
        val nameText = findViewById<EditText>(R.id.name)
        val heightText = findViewById<EditText>(R.id.height)
        val weightText = findViewById<EditText>(R.id.weight)
        val ageText = findViewById<EditText>(R.id.age)

        fun validateFields(name: String, age: String, weight: String, height: String): Boolean {
            if (name.isEmpty() || age.isEmpty() || height.isEmpty() || weight.isEmpty() ) {
                return false
            }


            val ageValue = age.toIntOrNull()
            val weightValue = weight.toDoubleOrNull()
            val heightValue = height.toIntOrNull()


            if (name.length >= 15 || name == null){
                return false
            }

            if (ageValue == null || ageValue <= 0 || ageValue >= 150) {
                return false
            }

            if (weightValue == null || weightValue <= 0 || weightValue >= 250) {
                return false
            }

            if (heightValue == null || heightValue <= 0 || heightValue >= 250) {
                return false
            }

            return true
        }

        fun calculateResult(name: String, age: Int, weight: Double, height: Int): Double {
            val result = name.length + age + weight + height
            return result
        }

        button.setOnClickListener{

            val name = nameText.text.toString().trim()
            val ageString = ageText.text.toString().trim()
            val weightString = weightText.text.toString().trim()
            val heightString = heightText.text.toString().trim()
            val isValid = validateFields(name, ageString, weightString, heightString)

            if (isValid){
                val height = heightString.toInt()
                val weight = weightString.toDouble()
                val age = ageString.toInt()

                val result = calculateResult(name, age, weight, height)
                resultTextView.text = result.toString()
            }else{
                resultTextView.text = "Данные введены не корректно"
            }
        }
    }
}