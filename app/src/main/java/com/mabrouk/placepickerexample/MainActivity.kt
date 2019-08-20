package com.mabrouk.placepickerexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.api.Status
import com.mabrouk.placepicker.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.open_place_picker_button).setOnClickListener {
            val intent = PlacePicker.IntentBuilder()
                .setLatLong(30.0517014, 31.2053958)
                .showLatLong(true)
                .setPlaceAutocomplete(true)
                .setFilterCountry("EG")
                .setPlaceSelectionListener(object : PlacePickerListener{
                    override fun onPlaceSelected(p0: com.google.android.gms.location.places.Place?) {
                      Toast.makeText(this@MainActivity,"${p0?.address}",Toast.LENGTH_SHORT).show()
                    }

                    override fun onError(p0: Status?) {
                    }

                })
                .build(this)
            startActivityForResult(intent, Constants.PLACE_PICKER_REQUEST)
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        if (requestCode == Constants.PLACE_PICKER_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                try {
                    val addressData = data?.getParcelableExtra<AddressData>(Constants.ADDRESS_INTENT)
                    findViewById<TextView>(R.id.address_data_text_view).text = addressData.toString()
                } catch (e: Exception) {
                    Log.e("MainActivity", e.message)
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
