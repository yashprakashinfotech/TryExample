package com.yash.tryexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        getUser()

    }

    private fun getUser() {

        val users = Services.tryInstance.getData()

        users.enqueue(object : Callback<AttachmentData>{

            override fun onFailure(call: Call<AttachmentData>, t: Throwable) {
                Log.d("prakash","Error in Fetching Data")
            }

            override fun onResponse(
                call: Call<AttachmentData>,
                response: Response<AttachmentData>
            ) {
                val userdata = response.body()

                if (userdata!=null){
                    Log.d("prakash",userdata.toString())
                    adapter = UserAdapter(this@MainActivity,userdata.results)
                    recyclerView.adapter = adapter
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                }

            }

        })

    }
}


