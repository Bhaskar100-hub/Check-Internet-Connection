package wary.bhaskar.checkinternetconnection

import android.app.Service
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var context = this
    var connectivity : ConnectivityManager? = null
    var info : NetworkInfo? = null

    private lateinit var btnCheckConnection : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCheckConnection = findViewById(R.id.btnCheckConnection)
        btnCheckConnection.setOnClickListener {
            connectivity = context.getSystemService(Service.CONNECTIVITY_SERVICE)
            as ConnectivityManager
            if (connectivity != null) {
                info = connectivity!!.activeNetworkInfo
                if(info != null) {
                    if(info!!.state == NetworkInfo.State.CONNECTED) {
                        Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Not Connected", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}