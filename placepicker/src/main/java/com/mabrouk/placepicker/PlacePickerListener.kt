package com.mabrouk.placepicker

import com.google.android.gms.common.api.Status
import com.google.android.gms.location.places.Place
import java.io.Serializable


/*
* Created By mabrouk on 20/08/19
* PlacePicker
*/

interface PlacePickerListener : Serializable {
     fun onPlaceSelected(place: Place?)
     fun onError(var1: Status?)
}