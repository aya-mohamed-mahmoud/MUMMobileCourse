package com.example.recyclercardviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    var r1: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null

    var madr : MyAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayOf(Product("Mac Probook",300.0,"silver",R.drawable.macprobook,1,"6.5-inch Super Retina XDR display1\n" +
                "IP68 Water and dust resistant2\n" +
                "Triple 12MP rear cameras\n" +
                "12MP TrueDepth front camera"),
            Product("Mac Mini",300.0,"space gray",R.drawable.mac_mini,1,"6.5-inch Super Retina XDR display1\n" +
                    "IP68 Water and dust resistant2\n" +
                    "Triple 12MP rear cameras\n" +
                    "12MP TrueDepth front camera"),
            Product("IpnonePro Max",300.0,"Gold",R.drawable.promax,1,"6.5-inch Super Retina XDR display1\n" +
                    "IP68 Water and dust resistant2\n" +
                    "Triple 12MP rear cameras\n" +
                    "12MP TrueDepth front camera"),
            Product("Iphone11",300.0,"blue",R.drawable.iphone11,1," 6.5-inch Super Retina XDR display1\n" +
                    "IP68 Water and dust resistant2\n" +
                    "Triple 12MP rear cameras\n" +
                    "12MP TrueDepth front camera"),
            Product("Mac Air",300.0,"Space Gray",R.drawable.mac_air,1,"6.5-inch Super Retina XDR display1\n" +
                    "IP68 Water and dust resistant2\n" +
                    "Triple 12MP rear cameras\n" +
                    "12MP TrueDepth front camera"))

        println(list)

        r1 = findViewById<RecyclerView>(R.id.rv)

        madr = MyAdapter(this,list)

        layoutManager = LinearLayoutManager(this)
        r1?.layoutManager = layoutManager
        r1?.adapter = madr

    }
}
