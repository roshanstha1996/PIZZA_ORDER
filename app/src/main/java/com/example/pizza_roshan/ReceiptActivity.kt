package com.example.pizza_roshan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pizza_roshan.databinding.ActivityReceiptBinding
import kotlin.random.Random

class ReceiptActivity : AppCompatActivity() {

    lateinit var binding: ActivityReceiptBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiptBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent != null){

            val orderDetail: Order = intent.getSerializableExtra("orderDetail") as Order

            val sliceCount: Int = orderDetail.sliceCount
            var pricePerSlice : Double = 0.0
            var deliveryCost : Double = 0.0

            if (orderDetail.isDelivery){
                deliveryCost = 5.25
            }else{
                deliveryCost = 0.0
            }

            if (orderDetail.pizzaType == "Meat") {
                pricePerSlice = 6.70
            }else{
                pricePerSlice = 4.25
            }

            val subTotal: Double = pricePerSlice * sliceCount
            val subTotalBeforeTax: Double = subTotal + deliveryCost
            val tax: Double = subTotalBeforeTax * 0.13
            val orderTotal: Double = subTotalBeforeTax + tax


            binding.confirmationCode.text = "Order Confirmed! Confirmation Code: #${Random.nextInt(1000, 10000).toString()}"

            binding.orderDetails.text = """
                Your Receipt:
                Pizza Type: ${orderDetail.pizzaType}
                Number of Slices: ${orderDetail.sliceCount}
                Price per Slice: ${pricePerSlice}
                Delivery cost: ${deliveryCost}
                """.trimIndent()

            binding.costBreakdown.text = """
                Subtotal: ${subTotalBeforeTax.toString()}
                Tax(13%): ${tax.toString()}
                Total: ${orderTotal.toString()}
                """.trimIndent()

        }
    }
}
