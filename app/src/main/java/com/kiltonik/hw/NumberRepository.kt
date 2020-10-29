package com.kiltonik.hw

object NumberRepository  {

    private val numberList = mutableListOf(1)

    fun newItem() : Int = numberList.size.apply { numberList.add(this + 1) }

    fun list() = numberList

    fun number(index: Int) = numberList[index]

    fun setItems(data: Any?) {
        data.let {
            if(data is Int && data != numberList.size) for (i in 2..data) numberList.add(i)
        }
    }
}
