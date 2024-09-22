package com.example.pizza_roshan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pizza_roshan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //switch to make the pizza count either 0 0r 8
        binding.isEntirePizza.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                binding.sliceCount.setText("8")
            }else{

                binding.sliceCount.setText("0")
            }
        }

        binding.btnSubmit.setOnClickListener {

            val intent: Intent = Intent(this@MainActivity, ReceiptActivity::class.java)

            val selectedPizzaTypeId:Int = binding.rbPizzaType.checkedRadioButtonId
            val sliceCount : Int = binding.sliceCount.text.toString().toInt()
            val isEntirePizza: Boolean = binding.isEntirePizza.isChecked
            var isDelivery: Boolean = binding.isDelivery.isChecked

            var pizzaType: String = ""


            if (selectedPizzaTypeId == R.id.rbMeat){
                pizzaType = "Meat"
            }
            else if (selectedPizzaTypeId == R.id.rbVeg) {
                pizzaType = "Vegetarian"
            }

            //creating instance of order object to pass data to second screen
            val orderDetail: Order = Order(pizzaType, sliceCount, isEntirePizza, isDelivery)
            intent.putExtra("orderDetail", orderDetail)

            startActivity(intent)
        }
    }
}
