package com.example.jettests

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
            var currency by remember {
                mutableStateOf("")
            }
            var value by remember {
                mutableStateOf("")
            }
            viewModel.getUsd()
            viewModel.myResponse.observe(this, Observer {
                Log.d(TAG, it.code)
                Log.d(TAG, it.rate.toString())
                Log.d(TAG, it.name)
                currency = it.name
                value = it.rate.toString()
            })
            ApplicationUI(currency, value)
        }
    }
}

@Composable
fun ApplicationUI(currency: String, cryptoValue: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff6c2bb3))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.bitcoin),
                contentDescription = "Bitcoin logo",
                modifier = Modifier
                    .size(100.dp)
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xff863bd9))
                        .fillMaxSize(), contentAlignment = Alignment.TopCenter
                ) {
                   Text(text = "$currency value: $cryptoValue", textAlign = TextAlign.Center)
                }
            }
        }
    }
}
