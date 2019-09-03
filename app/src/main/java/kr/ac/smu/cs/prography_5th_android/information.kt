package kr.ac.smu.cs.prography_5th_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_information.*

class information : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)
        var title=intent.getStringExtra("title")
        var des=intent.getStringExtra("des")
        var prod=intent.getStringExtra("prod")
        var reD=intent.getStringExtra("reD")
        var rtS=intent.getStringExtra("rtS")
        infTitle.text=title
        infDes.text=des
        infProd.text=prod
        infReD.text=reD
        infRtS.text=rtS
    }
}
