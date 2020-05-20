package com.naibeck.googlemapcompose

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.*
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.drawBorder
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.text.font.FontFamily
import androidx.ui.unit.TextUnit
import androidx.ui.unit.dp
import androidx.ui.viewinterop.AndroidView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private var mapView: MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapView = generateMapView(bundle = savedInstanceState)
        setContent {
            MaterialTheme {
                MainContent(view = mapView)
            }
        }
    }

    private fun generateMapView(bundle: Bundle?): MapView {
        return MapView(applicationContext).also {
            it.onCreate(bundle)
            it.getMapAsync(this)
        }
    }

    override fun onMapReady(map: GoogleMap?) {
        mapView?.onResume()
        val latLng = LatLng(-34.905262, -56.136192)
        map?.apply {
            moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18.0f))
            addMarker(MarkerOptions().position(latLng).draggable(false))
        }
    }
}


@Composable
fun MainContent(view: View?) {
    ConstraintLayout(constraintSet = ConstraintSet {
        val image = tag("centerImage")
        image.apply {
            center()
        }
    }) {
        Column {
            Row(modifier = Modifier.weight(1.0f, fill = true)) {
                view?.let { view ->
                    MapContent(mapView = view as MapView)
                }
            }
            Row(modifier = Modifier.weight(1.0f, fill = true)) {
                DetailContent()
            }
        }
        CenterImage()
    }
}

@Composable
fun CenterImage() {
    val image = imageResource(id = R.drawable.overactive)
    Image(
        image,
        modifier = Modifier.tag(tag = "centerImage")
            .height(200.dp)
            .width(200.dp)
            .drawShadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(100.dp)
            )
            .drawBorder(size = 2.dp, color = Color.White, shape = RoundedCornerShape(100.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MapContent(mapView: MapView) {
    AndroidView(view = mapView)
}

@Composable
fun DetailContent() {
    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "Overactive's HQ",
            fontSize = TextUnit.Companion.Sp(24),
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Text(text = "WTC, Tower #3", modifier = Modifier.weight(2.0f))
            Text(text = "Montevideo", modifier = Modifier.weight(1.0f))
        }
    }
}

