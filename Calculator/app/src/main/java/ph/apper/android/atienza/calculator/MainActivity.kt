package ph.apper.android.atienza.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.util.*

class MainActivity : AppCompatActivity() {
    var isOperator = true
    var isOperand = true
    var isNewOperation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberPress(view: View) {

        var inputExp = mainDisplay.text.toString()
        var exprDisplay = expDisplay.text.toString()
        var btnPress: Button = view as Button

        if(isNewOperation) {
            inputExp = ""
            expDisplay.setText(inputExp)
        }

        if(isOperator and !isOperand){
            inputExp = ""
            mainDisplay.setText(inputExp)
        }

         when (btnPress.id) {
            btnPct.id -> {
                if (inputExp.isNotEmpty())
                    inputExp = (inputExp.toDouble() / 100).toString()
            }
            btnSign.id -> {
                if (inputExp.isNotEmpty())
                    inputExp = (inputExp.toDouble() * -1).toString()

            }
            else -> inputExp = inputExp.plus(btnPress.text)
        }
        mainDisplay.setText(inputExp)
        isOperator = false
        isOperand = true
        isNewOperation = false
    }

    fun clearScreen(view: View) {
        mainDisplay.setText("")
        expDisplay.setText("")
    }

    fun opPress(view: View) {
        var inputExp = mainDisplay.text.toString()
        var exprDisplay = expDisplay.text.toString()
        var operation = ""
        var btnPress: Button = view as Button

        if(isNewOperation and !isOperator)
            expDisplay.setText(inputExp)

        if(!isNewOperation and isOperand and !isOperator)
            expDisplay.append(inputExp)

        isOperator = true
        when(btnPress.id){
            btnAdd.id -> {
                operation = "+"
            }
            btnMinus.id -> {
                operation = "-"
            }
            btnMult.id -> {
                operation = "*"
            }
            btnDiv.id -> {
                operation = "/"
            }
        }
        mainDisplay.setText(operation)

        if(isOperand and isOperator) {
            expDisplay.append(operation)
        }

        isOperand = false
        isNewOperation = false
    }

    fun delPress(view: View) {
        var inputExp = mainDisplay.text.toString()
        if(inputExp.isNotEmpty()){
            inputExp = inputExp.dropLast(1)
        }
        mainDisplay.setText(inputExp)
    }

    fun operate(view: View) {
        var inputExpression = mainDisplay.text.toString()
        var exprDisplay = expDisplay.text.toString()

        if(isOperand and exprDisplay.isNotEmpty()) {
            exprDisplay += inputExpression
            expDisplay.append(inputExpression)
            try {
                val expression = ExpressionBuilder(exprDisplay).build()
                val result = expression.evaluate()
                mainDisplay.setText(result.toString())
            } catch (e: Exception) {
                Log.e("Exception", "Caught Exception: " + e.message)
                mainDisplay.setText("Err")
            }
        } else {
            mainDisplay.setText("")
        }

        isNewOperation = true
    }
}