package com.yazan.it.rtdbpro

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dbr=FirebaseDatabase.getInstance().getReference()

        dbr.child("users").child("ali").addValueEventListener(
                object: ValueEventListener{
                    override fun onCancelled(p0: DatabaseError?) {

                    }

                    override fun onDataChange(p0: DataSnapshot?) {
                        textView.text=p0?.value.toString()
                    }

                }
        )

        button2.setOnClickListener {

            dbr.child("users").child("ali")
                    .setValue(editText.text.toString())
        }

    }
}
