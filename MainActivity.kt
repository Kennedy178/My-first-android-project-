import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var principalEditText: EditText
    private lateinit var timeEditText: EditText
    private lateinit var rateEditText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        principalEditText = findViewById(R.id.principalEditText)
        timeEditText = findViewById(R.id.timeEditText)
        rateEditText = findViewById(R.id.rateEditText)
        resultTextView = findViewById(R.id.resultTextView)

        val resetButton: Button = findViewById(R.id.resetButton)
        val calculateButton: Button = findViewById(R.id.calculateButton)
        val displayInterestButton: Button = findViewById(R.id.displayInterestButton)

        // Reset button click listener
        resetButton.setOnClickListener {
            resetFields()
        }

        // Calculate button click listener
        calculateButton.setOnClickListener {
            calculateSimpleInterest()
        }

        // Display Interest button click listener
        displayInterestButton.setOnClickListener {
            displaySimpleInterest()
        }
    }

    private fun resetFields() {
        principalEditText.text.clear()
        timeEditText.text.clear()
        rateEditText.text.clear()
        resultTextView.text = ""
    }

    private fun calculateSimpleInterest() {
        val principal = principalEditText.text.toString().toFloatOrNull()
        val time = timeEditText.text.toString().toIntOrNull()
        val rate = rateEditText.text.toString().toFloatOrNull()

        if (principal != null && time != null && rate != null) {
            val simpleInterest = (principal * time * rate) / 100
            resultTextView.text = getString(R.string.simple_interest_result, simpleInterest)
        } else {
            resultTextView.text = getString(R.string.invalid_input)
        }
    }

    private fun displaySimpleInterest() {
        val result = resultTextView.text.toString()
        if (result.isNotEmpty()) {
            resultTextView.text = getString(R.string.display_simple_interest_result, result)
        }
    }
}
