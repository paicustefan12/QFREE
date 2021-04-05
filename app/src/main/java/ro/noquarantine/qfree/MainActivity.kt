package ro.noquarantine.qfree

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*

//private const val STATE_TYPE = "TYPE"
//private const val STATE_TYPE_STORED = "TYPE_Stored"
//
//private const val STATE_COUNTER = "COUNTER"
//private const val STATE_COUNTER_STORED = "COUNTER_Stored"
//
//private const val STATE_GOALCAL = "GOALCAL"
//private const val STATE_GOALCAL_STORED = "GOALCAL_Stored"
//
//private const val STATE_ARRALIMENT = "ARRALIMENT"
//private const val STATE_ARRALIMENT_STORED = "ARRALIMENT_Stored"


class MainActivity : AppCompatActivity() {

    private val TAG = "Main Activity"
    private var goalCal: Float = 0.0f
    private var counter: Int = 0
    private var type = 0
    private var arrAliment = Array(6) { Aliment() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate called")

        val alimentType = resources.getStringArray(R.array.alimentsArray)
        val spinner = findViewById<Spinner>(R.id.alimentType)
        if (spinner != null) {
            val adapater = ArrayAdapter(this, android.R.layout.simple_spinner_item, alimentType)
            spinner.adapter = adapater
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?, position: Int, id: Long
                ) {
                    Log.d(TAG, "Spinner: onItemSelected called")
                    Toast.makeText(
                        this@MainActivity,
                        alimentType[position], Toast.LENGTH_SHORT
                    ).show()
                    when {
                        alimentType[position] == "Dairy" -> {
                            type = 0
                        }
                        alimentType[position] == "Meat" -> {
                            type = 1
                        }
                        alimentType[position] == "Carbohydrates" -> {
                            type = 2
                        }
                        alimentType[position] == "Vegetables" -> {
                            type = 3
                        }
                        alimentType[position] == "Fruits" -> {
                            type = 4
                        }
                        alimentType[position] == "Sweets" -> {
                            type = 5
                        }
                    }

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    Log.d(TAG, "Spinner: onNothingSelected called")
                    Toast.makeText(
                        this@MainActivity,
                        "No aliment type selected",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        btnSubmit?.setOnClickListener {
            Log.d(TAG, "Submit: ")
            goalCal = findViewById<EditText>(R.id.goalCal).text.toString().toFloat()
            Toast.makeText(this, goalCal.toString(), Toast.LENGTH_SHORT).show()

            val layout = layoutInflater.inflate(R.layout.activity_display, null) as ConstraintLayout
            setContentView(layout)
            val displayAliments = layout.findViewById<TextView>(R.id.displayAliments)
            var auxFloat: Int

            if (!arrAliment[1].getGrams().equals(0F)) {
                auxFloat = ((goalCal * 100) / (arrAliment[1].getGrams() * counter)).toInt()

                // goalCal -= auxFloat * arrAliment[1].getGrams() / 100
                displayAliments.append(arrAliment[1].getName())
                displayAliments.append(" : ")
                displayAliments.append("$auxFloat grams")
                displayAliments.append("\n")
            }

            if (!arrAliment[2].getGrams().equals(0F)) {
                auxFloat = ((goalCal * 100) / (arrAliment[2].getGrams() * counter)).toInt()

                displayAliments.append(arrAliment[2].getName())
                displayAliments.append(" : ")
                displayAliments.append("$auxFloat grams")
                displayAliments.append("\n")
            }

            if (!arrAliment[3].getGrams().equals(0F)) {
                auxFloat = ((goalCal * 100) / (arrAliment[3].getGrams() * counter)).toInt()

                displayAliments.append(arrAliment[3].getName())
                displayAliments.append(" : ")
                displayAliments.append("$auxFloat grams")
                displayAliments.append("\n")
            }

            if (!arrAliment[0].getGrams().equals(0F)) {
                auxFloat = ((goalCal * 100) / (arrAliment[0].getGrams() * counter)).toInt()

                displayAliments.append(arrAliment[0].getName())
                displayAliments.append(" : ")
                displayAliments.append("$auxFloat grams")
                displayAliments.append("\n")
            }

            if (!arrAliment[4].getGrams().equals(0F)) {
                auxFloat = ((goalCal * 100) / (arrAliment[4].getGrams() * counter)).toInt()

                displayAliments.append(arrAliment[4].getName())
                displayAliments.append(" : ")
                displayAliments.append("$auxFloat grams")
                displayAliments.append("\n")
            }

            if (!arrAliment[5].getGrams().equals(0F)) {
                auxFloat = ((goalCal * 100) / (arrAliment[5].getGrams() * counter)).toInt()

                displayAliments.append(arrAliment[5].getName())
                displayAliments.append(" : ")
                displayAliments.append("$auxFloat grams")
                displayAliments.append("\n")
            }

        }
        btnSubmitAliment?.setOnClickListener {
            Log.d(TAG, "SubmitAliment")

            arrAliment[type].setGrams(
                findViewById<EditText>(R.id.enterCal).text.toString().toFloat()
            )
            arrAliment[type].setName(findViewById<EditText>(R.id.alimentName).text.toString())
            counter++
            findViewById<EditText>(R.id.alimentName).setText("")
            findViewById<EditText>(R.id.enterCal).setText("")
        }

        btnCamera?.setOnClickListener {
            Log.d(TAG, "Camera Clicked")
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }

    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        if (type != null) {
//            outState.putInt(STATE_TYPE, type!!)
//            outState.putBoolean(STATE_TYPE_STORED, true)
//        }
//        if (counter != null) {
//            outState.putInt(STATE_COUNTER, counter!!)
//            outState.putBoolean(STATE_COUNTER_STORED, true)
//        }
//        if (goalCal != null) {
//            outState.putFloat(STATE_GOALCAL, goalCal!!)
//            outState.putBoolean(STATE_GOALCAL_STORED, true)
//        }
//        if (arrAliment != null) {
//            outState.putParcelableArray(STATE_ARRALIMENT, arrAliment!!)
//            outState.putBoolean(STATE_ARRALIMENT_STORED, true)
//        }
//    }
//
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        type = (if (savedInstanceState.getBoolean(STATE_TYPE_STORED, false)) {
//            savedInstanceState.getInt(STATE_TYPE)
//        } else {
//            null
//        })!!
//
//        counter = (if (savedInstanceState.getBoolean(STATE_COUNTER_STORED, false)) {
//            savedInstanceState.getInt(STATE_COUNTER)
//        } else {
//            null
//        })!!
//
//        goalCal = (if (savedInstanceState.getBoolean(STATE_GOALCAL_STORED, false)) {
//            savedInstanceState.getFloat(STATE_GOALCAL)
//        } else {
//            null
//        })!!
//
//        arrAliment = (if (savedInstanceState.getBoolean(STATE_ARRALIMENT_STORED, false)) {
//            savedInstanceState.getParcelableArray(STATE_ARRALIMENT)
//        } else {
//            null
//        })!! as Array<Aliment>
//
//    }
//
//    override fun onPause() {
//        super.onPause()
//    }
}

