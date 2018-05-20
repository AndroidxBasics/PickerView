package com.mychatapp.lubuntupc.pickerview

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.weigan.loopview.OnItemSelectedListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    var toast: Toast? = null
    var context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<String>()
        for (i in 0..14) {
            list.add("item " + i)
        }

        loopView.setItems(list)
        loopView.setNotLoop()
        loopView.setCurrentPosition(list.size / 2)
        loopView.setCenterTextColor(Color.WHITE)

        loopView.setListener(object: OnItemSelectedListener {
            override fun onItemSelected(index: Int) {
                if (toast == null) {
                    toast = Toast.makeText(context, "item " + index, Toast.LENGTH_SHORT)
                }
                toast!!.setGravity(Gravity.BOTTOM, 0, 70)
                toast!!.setText("item " + index);
                toast!!.show();            }


        })
    }


}
