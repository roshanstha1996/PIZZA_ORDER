package com.example.pizza_roshan

import java.io.Serializable

class Order: Serializable {
    var pizzaType: String
    var sliceCount: Int
    var isEntirePizza: Boolean
    var isDelivery: Boolean

    constructor(pizzaType: String, sliceCount: Int, isEntirePizza: Boolean, isDelivery: Boolean) {
        this.pizzaType = pizzaType
        this.sliceCount = sliceCount
        this.isEntirePizza = isEntirePizza
        this.isDelivery = isDelivery
    }

    override fun toString(): String {
        return "Order(pizzaType='$pizzaType', sliceCount=$sliceCount, isEntirePizza=$isEntirePizza, isDelivery=$isDelivery)"
    }


}