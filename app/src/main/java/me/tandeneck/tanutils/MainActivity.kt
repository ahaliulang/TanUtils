package me.tandeneck.tanutils

import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private var myPerson:Person? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)
        myPerson = Person()
        trans(myPerson!!)
        update(myPerson!!)
    }

    private fun update(person: Person){
        Log.d(TAG, "update: $myPerson $person")
        Log.d(TAG, "onCreate: ${myPerson == person} ${myPerson === person}")
        myPerson = null
        Log.d(TAG, "update: $myPerson $person")
        Log.d(TAG, "onCreate: ${myPerson == person} ${myPerson === person}")
    }

    data class Person(
            var name: String = "tam",
            var id: String = "isd"
    )

    private fun trans(person: Person) {
        person.id = "2314"
    }

    private fun isMain(): Boolean = Looper.getMainLooper() == Looper.myLooper()
}