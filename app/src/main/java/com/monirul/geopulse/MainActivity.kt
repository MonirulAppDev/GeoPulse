package com.monirul.geopulse

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import org.maplibre.compose.camera.CameraPosition
import org.maplibre.compose.camera.rememberCameraState
import org.maplibre.compose.map.MaplibreMap
import org.maplibre.compose.style.BaseStyle
import org.maplibre.spatialk.geojson.Position

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val cameraState = rememberCameraState(
                firstPosition = CameraPosition(
                    target = Position(longitude = 90.4125, latitude = 23.8103),
                    zoom = 13.0
                )
            )

            MaplibreMap (
                modifier = Modifier.fillMaxSize(),
                baseStyle = BaseStyle.Uri("https://tiles.openfreemap.org/styles/liberty"),
                cameraState = cameraState
            )
        }
    }
}