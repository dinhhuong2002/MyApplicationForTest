package com.example.myTestGK

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.Manifest;
import android.widget.Toast;


class MainActivity : AppCompatActivity() {
    private val SEND_SMS_CODE = 123
    private val INTERNERT_CODE=321
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Kiểm tra quyền người dùng xem đã được cấp phép chưa
        if (checkSelfPermission(Manifest.permission.INTERNET)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // Yêu cầu quyền người dùng
            requestPermissions(arrayOf(Manifest.permission.INTERNET), INTERNERT_CODE)
        }


        val textView = findViewById<TextView>(R.id.text_view)
        val editText = findViewById<EditText>(R.id.edit_text)
        findViewById<Button>(R.id.button_show).setOnClickListener {
            textView.text = editText.text.toString().uppercase()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // Lắng nghe xem người dùng có đồng ý cấp phép không?
        if (requestCode == INTERNERT_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(
                    applicationContext,
                    "Internet permission granted",
                    Toast.LENGTH_SHORT
                ).show()
                doSomething()
            } else {
                Toast.makeText(applicationContext, "Internet permission denied", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun doSomething() {
        // Làm gì đó sau khi người dùng đã đồng ý cấp phép quyền gửi tin nhắn
    }
}