package com.asiradnan.vangtichai2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var current: Int = 0;
}

class MainActivity : AppCompatActivity() {
    private val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportActionBar?.setTitle("VangtiChai App")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val one: Button = findViewById(R.id.one);
        val two: Button = findViewById(R.id.two);
        val four: Button = findViewById(R.id.four);
        val three: Button = findViewById(R.id.three);
        val five: Button = findViewById(R.id.five);
        val six: Button = findViewById(R.id.six);
        val seven: Button = findViewById(R.id.seven);
        val eight: Button = findViewById(R.id.eight);
        val nine: Button = findViewById(R.id.nine);
        val zero: Button = findViewById(R.id.zero);
        val clear:Button = findViewById(R.id.clear)
        val display: TextView = findViewById(R.id.textView3)

        val fiveH: TextView = findViewById(R.id.fiveH);
        val oneH: TextView = findViewById(R.id.oneH);
        val fifty: TextView = findViewById(R.id.fifty);
        val twenty: TextView = findViewById(R.id.twenty);
        val ten: TextView = findViewById(R.id.ten);
        val fivetaka: TextView = findViewById(R.id.fivetaka);
        val twotaka: TextView = findViewById(R.id.twotaka);
        val onetaka: TextView = findViewById(R.id.onetaka);

        var a500=0;
        var a100=0;
        var a50=0;
        var a20=0;
        var a10 = 0;
        var a5 = 0;
        var a2 = 0;
        var a1 = 0;


        fun update(note:Int, koyta:Int){
            if (note==500) {
                a500=koyta;
                fiveH.text = "500: "+ a500.toString();
            }
            else if (note==100) {
                a100=koyta;
                oneH.text = "100: "+ a100.toString();
            }
            else if (note==50) {
                a50=koyta;
                fifty.text = "50: "+ a50.toString();
            }
            else if (note==20) {
                a20=koyta;
                twenty.text = "20: "+ a20.toString();
            }
            else if (note==10) {
                a10=koyta;
                ten.text = "10: "+ a10.toString();
            }
            else if (note==5) {
                a5=koyta;
                fivetaka.text = "5: "+ a5.toString();
            }
            else if (note==2) {
                a2=koyta;
                twotaka.text = "2: "+ a2.toString();
            }
            else{
                a1=koyta;
                onetaka.text = "1: "+ a1.toString();
            }
        }
        fun vangao(money:Int){
            val notes = arrayOf(500,100,50,20,10,5,2,1);
            var moneyy = money;
            for (i in notes){
                update(i,moneyy/i);
                moneyy %= i;
            }
        }

        fun show(){
            display.text = "Taka: " + viewModel.current.toString();
            vangao(viewModel.current);
        }
        show();
        println("new: "+viewModel.current);
        one.setOnClickListener{
            viewModel.current = viewModel.current*10+1;
            show();
        }
        two.setOnClickListener{
            viewModel.current = viewModel.current*10+2;
            show();
        }
        three.setOnClickListener{
            viewModel.current = viewModel.current*10+3;
            show();
        }
        four.setOnClickListener{
            viewModel.current = viewModel.current*10+4;
            show();
        }
        five.setOnClickListener{
            viewModel.current = viewModel.current*10+5;
            show();
        }
        six.setOnClickListener{
            viewModel.current = viewModel.current*10+6;
            show();
        }
        seven.setOnClickListener{
            viewModel.current = viewModel.current*10+7;
            show();
        }
        eight.setOnClickListener{
            viewModel.current = viewModel.current*10+8;
            show();
        }
        nine.setOnClickListener{
            viewModel.current = viewModel.current*10+9;
            show();
        }
        zero.setOnClickListener{
            viewModel.current*=10;
            show();
        }
        clear.setOnClickListener{
            viewModel.current = 0;
            show();
        }

    }
}