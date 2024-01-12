//This is the folder which contains all the files related to this project
package com.sdc.calculator

//These are also folders which are imported if their need is required
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sdc.calculator.databinding.ActivityMainBinding
import es.dmoral.toasty.Toasty

//Activity->The screen which gets displayed.
//This Activity has all features of calculator
class MainActivity : AppCompatActivity() {

    //binding helps to connect Kotlin(is a Programming Language) to XML(makes User Interface)
    private lateinit var binding: ActivityMainBinding
    //declaring and initializing operator variable
     private var operator:String = ""

    //This is a pre-defined function called when the Activity starts/screen starts
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //connecting Kotlin to XML
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //An user defined function called when you click on operator buttons
        buttonClicked()

        //An user defined function called when you click on equalto button
        resultButton()

    }

    private fun resultButton()
    {
        //when clicked on equal to button
        binding.equals.setOnClickListener {
            //fetching the operands
            val firstInput = binding.firstNum.text.toString()
            val secondInput = binding.secondNum.text.toString()

            //conditional statements to solve some errors
           if(firstInput!="" && secondInput != "")
            {
               //Converting the operands to double to prevent loss of data
                val num1 = binding.firstNum.text.toString().toDouble()
                val num2 = binding.secondNum.text.toString().toDouble()

                //storing the result
                val result = operations(num1,num2,operator)

                if(result == Double.MIN_VALUE)
                {
                    //Toasty or Toast are small pop ups to display some message
                    //helpful to solve bugs
                    Toasty.warning(this,"Select an operator.",Toast.LENGTH_SHORT,true).show()

                }
                else{
                    binding.result.text = result.toString()
                    binding.result.visibility = View.VISIBLE
                }

            }
            else if(firstInput=="" && secondInput != "")
            {
                Toasty.warning(this,"Enter first number.",Toast.LENGTH_SHORT,true).show()
            }
            else if(firstInput!="" && secondInput == "")
            {
                Toasty.warning(this,"Enter second number.",Toast.LENGTH_SHORT,true).show()

            }
            else
            {
                Toasty.error(this,"Invalid format used",Toast.LENGTH_SHORT,true).show()

            }
        }
    }


    //User defined function to solve operations and return result
    private fun operations(num1:Double, num2:Double, operator: String):Double
    {
       return when(operator)
        {
            "-"->num1+num2
            "+"->num1-num2
            "*"->num1*num2
            "/"->num1/num2
            "%"->num1%num2
           else-> Double.MIN_VALUE
        }
    }

    //user defined function to get Operator when clicked on Button
    private fun performOperation(operator:String):String
    {
        return operator
    }

    //An user defined function called when you click on operator buttons
    private fun buttonClicked()
    {
        //Plus Button
        binding.plus.setOnClickListener{
            operator = performOperation("+")
        }

        //Minus Button
        binding.minus.setOnClickListener{
            operator = performOperation("-")
        }

        //Division Button
        binding.division.setOnClickListener{
            operator = performOperation("/")
        }

        //Multiplication Button
        binding.multiplication.setOnClickListener{
            operator = performOperation("*")
        }

        //Modulo Button
        binding.modulo.setOnClickListener{
            operator = performOperation("%")
        }


        //Clear Button
        binding.ac.setOnClickListener {
            Toasty.success(this,"Cleared",Toast.LENGTH_SHORT,true).show()
            binding.result.text=""
            binding.result.visibility = View.GONE
            binding.firstNum.text.clear()
            binding.secondNum.text.clear()
            operator=""
        }

    }

    }
