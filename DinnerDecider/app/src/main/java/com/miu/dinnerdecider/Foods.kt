package com.miu.dinnerdecider

class Foods {
    private var dinners = ArrayList<String>()

    constructor() {
        this.dinners = ArrayList<String>(arrayListOf("Hamburger", "Pizza", "Mexican" , "American", "Chinese"))
    }

    open fun addFood(food: String) {
        dinners.add(food);
    }

    open fun getRandomFood(): String {
        return dinners.random();
    }
}