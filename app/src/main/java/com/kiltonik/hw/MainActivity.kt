package com.kiltonik.hw

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), RecycleFragment.FragmentListener {

    companion object {
        const val BIG_NUMBER = "BIG_NUMBER"
        const val RECYCLE = "RECYCLE"
        const val NUMBER = "Number"
    }

    private val repository = NumberRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frame, RecycleFragment.newInstance(), RECYCLE)
                .commitAllowingStateLoss()
        else
            repository.setItems(savedInstanceState.get(NUMBER))
    }

    override fun onNumberClicked(number: Int) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(RECYCLE)
            .replace(R.id.frame, NumberFragment.newInstance(number), BIG_NUMBER)
            .commitAllowingStateLoss()
    }


    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt(NUMBER, repository.list().size)
    }
}
