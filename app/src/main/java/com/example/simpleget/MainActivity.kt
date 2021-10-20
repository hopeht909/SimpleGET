package com.example.simpleget

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //response text for the text view in the scrollView
        val responseText = findViewById<View>(R.id.textView) as TextView
     
        //an object from APIInterface to call the method
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        //progress dialog to show that something happened
        val progressDialog = ProgressDialog(this@MainActivity)
        progressDialog.setMessage("Please wait")
        progressDialog.show()


        if (apiInterface != null) {
            apiInterface.getUser()?.enqueue(object : Callback<List<People.PeopleDetailed>> {
                override fun onResponse(
                    call: Call<List<People.PeopleDetailed>>,
                    response: Response<List<People.PeopleDetailed>>
                ) {
                    progressDialog.dismiss()
                    var stringToBePritined: String? = ""
                    for (User in response.body()!!) {
                        stringToBePritined =
                            stringToBePritined + User.name + "\n"
                    }
                    responseText.text = stringToBePritined
                }

                override fun onFailure(call: Call<List<People.PeopleDetailed>>, t: Throwable) {
                    //  onResult(null)
                    progressDialog.dismiss()
                    Toast.makeText(applicationContext, "" + t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }

    }

}