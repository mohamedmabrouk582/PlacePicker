package com.mabrouk.placepicker

import android.app.Activity
import android.content.Intent
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

class PlacePicker {

  class IntentBuilder {

    private lateinit var activity: Activity
    private var showLatLong: Boolean = false
    private var latitude: Double = Constants.DEFAULT_LATITUDE
    private var longitude: Double = Constants.DEFAULT_LONGITUDE
    private var zoom: Float = Constants.DEFAULT_ZOOM
    private var addressRequired: Boolean = true
    private var hideMarkerShadow: Boolean = false
    private var markerDrawableRes: Int = -1
    private var markerImageColorRes: Int = -1
    private var fabBackgroundColorRes: Int = -1
    private var primaryTextColorRes: Int = -1
    private var secondaryTextColorRes: Int = -1
    private var mapType:MapType=MapType.Normal
    private var isIndoorEnabled:Boolean=false
    private var isTrafficEnabled:Boolean=false
    private var hasPlaceAutocomplete:Boolean=false
    private var filterCountry:String?=null
    var placePickerListener : PlacePickerListener?=null

    fun showLatLong(showLatLong: Boolean) = apply { this.showLatLong = showLatLong }

    fun setLatLong(
      latitude: Double,
      longitude: Double
    ) = apply {
      if (latitude == -1.0 || longitude == -1.0) {
        this.latitude = Constants.DEFAULT_LATITUDE
        this.longitude = Constants.DEFAULT_LONGITUDE
      } else {
        this.latitude = latitude
        this.longitude = longitude
      }
    }

        fun setPlacePickerListenerr(placePickerListener:PlacePickerListener) = apply { this.placePickerListener=placePickerListener }

    fun setFilterCountry(filterCountry:String) = apply { this.filterCountry=filterCountry }

    fun setPlaceAutocomplete(hasPlaceAutocomplete:Boolean) = apply { this.hasPlaceAutocomplete=hasPlaceAutocomplete }

    fun setIndoorEnabled(isIndoorEnabled:Boolean) = apply { this.isIndoorEnabled=isIndoorEnabled }

    fun setTrafficEnabled(isTrafficEnabled:Boolean) = apply { this.isTrafficEnabled=isTrafficEnabled }

    fun setMapType(mapType:MapType) = apply { this.mapType=mapType }

    fun setMapZoom(zoom: Float) = apply { this.zoom = zoom }

    fun setAddressRequired(addressRequired: Boolean) = apply { this.addressRequired = addressRequired }

    fun hideMarkerShadow(hideMarkerShadow: Boolean) = apply { this.hideMarkerShadow = hideMarkerShadow }

    fun setMarkerDrawable(@DrawableRes markerDrawableRes: Int) = apply { this.markerDrawableRes = markerDrawableRes }

    fun setMarkerImageImageColor(@ColorRes markerImageColorRes: Int) = apply { this.markerImageColorRes = markerImageColorRes }

    fun setFabColor(@ColorRes fabBackgroundColor: Int) = apply { this.fabBackgroundColorRes = fabBackgroundColor }

    fun setPrimaryTextColor(@ColorRes primaryTextColor: Int) = apply { this.primaryTextColorRes = primaryTextColor }

    fun setSecondaryTextColor(@ColorRes secondaryTextColorRes: Int) = apply { this.secondaryTextColorRes = secondaryTextColorRes }

    fun build(activity: Activity): Intent {
      this.activity = activity
      val intent = Intent(activity, PlacePickerActivity::class.java)
      Constants.placePickerListener=placePickerListener
      intent.putExtra(Constants.MAP_TYPE,mapType)
      intent.putExtra(Constants.SHOW_LAT_LONG_INTENT, showLatLong)
      intent.putExtra(Constants.INITIAL_LATITUDE_INTENT, latitude)
      intent.putExtra(Constants.INITIAL_LONGITUDE_INTENT, longitude)
      intent.putExtra(Constants.INITIAL_ZOOM_INTENT, zoom)
      intent.putExtra(Constants.HIDE_MARKER_SHADOW_INTENT, hideMarkerShadow)
      intent.putExtra(Constants.MARKER_DRAWABLE_RES_INTENT, markerDrawableRes)
      intent.putExtra(Constants.MARKER_COLOR_RES_INTENT, markerImageColorRes)
      intent.putExtra(Constants.FAB_COLOR_RES_INTENT, fabBackgroundColorRes)
      intent.putExtra(Constants.PRIMARY_TEXT_COLOR_RES_INTENT, primaryTextColorRes)
      intent.putExtra(Constants.SECONDARY_TEXT_COLOR_RES_INTENT, secondaryTextColorRes)
      intent.putExtra(Constants.IS_INDOOR_ENABLE, isIndoorEnabled)
      intent.putExtra(Constants.IS_TRAFFIC_ENABLE, isTrafficEnabled)
      intent.putExtra(Constants.HAS_PlaceAutocomplete,hasPlaceAutocomplete)
      intent.putExtra(Constants.FILTER_COUNTRY,filterCountry)
     // intent.putExtra(Constants.PLACE_LISTENER,placeSelectionListener)
      return intent
    }
  }

}