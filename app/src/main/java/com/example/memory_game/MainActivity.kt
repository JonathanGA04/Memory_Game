package com.example.memory_game

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

       //ELEMENTOS PARA INTERACTUAR CON LA PARTE VISUAl(INTERFAZ GRAFICA)
    //Imagenes
    lateinit var iv_11:ImageView
    lateinit var iv_12:ImageView
    lateinit var iv_13:ImageView
    lateinit var iv_14:ImageView

    lateinit var iv_21:ImageView
    lateinit var iv_22:ImageView
    lateinit var iv_23:ImageView
    lateinit var iv_24:ImageView

    lateinit var iv_31:ImageView
    lateinit var iv_32:ImageView
    lateinit var iv_33:ImageView
    lateinit var iv_34:ImageView

    // Imagenes jugadores
    lateinit var  tv_j1:TextView
    lateinit var  tv_j2:TextView

    lateinit var ib_sonido:ImageButton

    lateinit var mp: MediaPlayer
    lateinit var mpFondo: MediaPlayer
    lateinit var imagen1:ImageView
    lateinit var imagen2:ImageView

    //Variables
    var imagenesArray = arrayOf(11,12,13,14,15,16,21,22,23,24,25,26)
    var barcelona = 0
    var real = 0
    var betis = 0
    var valencia = 0
    var  atletic= 0
    var socie = 0
    var atleticom = 0

    var turno = 1
    var puntosj1 = 0
    var puntosj2 = 0
    var numeroImagen = 1
    var escuchar = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enlazarINTER()

    }

    private fun enlazarINTER() {
        iv_11 = findViewById(R.id.iv_12)
        iv_12 = findViewById(R.id.iv_13)
        iv_13 = findViewById(R.id.iv_14)
        iv_14 = findViewById(R.id.iv_11)
        iv_21 = findViewById(R.id.iv_21)
        iv_22 = findViewById(R.id.iv_22)
        iv_23 = findViewById(R.id.iv_23)
        iv_24 = findViewById(R.id.iv_24)
        iv_31 = findViewById(R.id.iv_31)
        iv_32 = findViewById(R.id.iv_32)
        iv_33 = findViewById(R.id.iv_33)
        iv_34 = findViewById(R.id.iv_34)

        ib_sonido = findViewById(R.id.ib_sonido)
        ib_sonido.setColorFilter(Color.GREEN)
        sonido("background", true)

        //tag: sirve para saber la posicion de la imagen
        iv_11.tag = "0"
        iv_12.tag = "1"
        iv_13.tag = "2"
        iv_14.tag = "3"
        iv_21.tag = "4"
        iv_22.tag = "5"
        iv_23.tag = "6"
        iv_24.tag = "7"
        iv_31.tag = "8"
        iv_32.tag = "9"
        iv_33.tag = "10"
        iv_34.tag = "11"

        barcelona = R.drawable.barcelona
        real = R.drawable.real
        valencia = R.drawable.valencia
        socie = R.drawable.socie
        atletic = R.drawable.atletic
        atleticom = R.drawable.atleticom
        betis = R.drawable.betis

        imagenesArray.shuffle()

        tv_j1 = findViewById(R.id.tv_1)
        tv_j2 = findViewById(R.id.tv_2)


        tv_j2.setTextColor(Color.GRAY)
        tv_j1.setTextColor(Color.WHITE)

    }
     //Metodo para utilizar el sonido en general
    private fun sonido(sonidoName: String, loop: Boolean= false) {
        var resID = resources.getIdentifier(sonidoName, "raw", packageName)
            if(sonidoName == "background"){
                mpFondo = MediaPlayer.create(this, resID)
                mpFondo.isLooping = loop
                mpFondo.setVolume(0.04F,0.4F)
                if (!mpFondo.isPlaying){
                    mpFondo.start()
                }
            }else{
                mp = MediaPlayer.create(this, resID)
                mp.setOnCompletionListener (MediaPlayer.OnCompletionListener { mediaPlayer ->
                    mediaPlayer.stop()
                    mediaPlayer.release()
                })
                if (!mp.isPlaying){
                    mp.start()
                }
            }
    }
    fun musicFondo(v: View){
        if (escuchar){
            mpFondo.pause()
            ib_sonido.setImageResource(R.drawable.ic_volume_off_24)
            ib_sonido.setColorFilter(Color.GRAY)
        }else{
            mpFondo.start()
            ib_sonido.setImageResource(R.drawable.ic_volume_on)
            ib_sonido.setColorFilter(Color.GREEN)

        }
        escuchar = !escuchar
    }
}