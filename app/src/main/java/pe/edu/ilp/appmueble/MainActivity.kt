package pe.edu.ilp.appmueble

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clik_ButonClien()
        clik_ButonAdmin()

    }
    //https://www.youtube.com/watch?v=uXvTSjgoU4A
    fun clik_ButonClien(){
    val cliente=findViewById<android.view.View>(R.id.btnCliente)
        cliente.setOnClickListener {
            val cli:Intent= Intent(applicationContext,Cliente::class.java)
            startActivity(cli)
        }
    }
    fun clik_ButonAdmin(){
        val adm=findViewById<android.view.View>(R.id.btnAdmin)
        adm.setOnClickListener {
            val Ad:Intent= Intent(applicationContext,Admin::class.java)
            startActivity(Ad)
        }
    }


}