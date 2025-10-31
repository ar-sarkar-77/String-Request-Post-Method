package com.anondo.stringrequestpostmethod

import android.content.ContextParams
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.anondo.stringrequestpostmethod.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.uploadBtn.setOnClickListener {

            var names = binding.edname.text.toString()
            var numbers = binding.ednumber.text.toString()

            var queue = Volley.newRequestQueue(this)

            var url = "https://arsarkar.xyz/SMR_practices/str_post.php"


            var stringRequest = object : StringRequest(Request.Method.POST , url ,
                { responce ->

                binding.name.text = responce.toString()

            },{ error ->
                binding.name.text = error.toString()
            } )  {
                override fun getParams(): MutableMap<String, String> {
                    var param = HashMap<String , String>()
                    param["name"] = names
                    param["number"] = numbers
                    return param
                }
            }

            queue.add(stringRequest)

        }


    }

}