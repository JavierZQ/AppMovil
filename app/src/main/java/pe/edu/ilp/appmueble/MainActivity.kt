package pe.edu.ilp.appmueble

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.Toast
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clik_ButonClien()
        clik_ButonAdmin()

    }

    fun clik_ButonClien(){
    val cliente=findViewById<android.view.View>(R.id.btnCliente)
        cliente.setOnClickListener {
            val cli:Intent= Intent(applicationContext,Cliente::class.java)
            startActivity(cli)
            dbConn()
        }
    }
    fun clik_ButonAdmin(){
        val adm=findViewById<android.view.View>(R.id.btnAdmin)
        adm.setOnClickListener {
            val Ad:Intent= Intent(applicationContext,Admin::class.java)
            startActivity(Ad)
        }
    }

    private val ip ="192.168.0.10:1400";
    private val db ="BDVentas";
    private val username ="sa";
    private val password ="zamorano"
    fun dbConn(): Connection?{
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn: Connection? = null
        var connString:String
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance()
            connString ="jdbc:jtds:sqlserver://$ip;databaseName=$db;user=$username;password=$password"
            conn = DriverManager.getConnection(connString)
            Toast.makeText(applicationContext,"Conectado!!", Toast.LENGTH_LONG).show()
        }catch (ex: SQLException){
            Toast.makeText(applicationContext,"error!!", Toast.LENGTH_LONG).show()
        }
        return conn
    }
}