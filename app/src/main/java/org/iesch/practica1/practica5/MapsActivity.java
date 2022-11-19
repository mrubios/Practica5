package org.iesch.practica1.practica5;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.iesch.practica1.practica5.databinding.ActivityMapsBinding;
import org.iesch.practica1.practica5.modelo.IES;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    private List<IES> listaIES;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        añadirIES();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void añadirIES() {
        listaIES = new ArrayList<>();
        listaIES.add(new IES("IES Segundo de Chomón", 40.326661,-1.098318));
        listaIES.add(new IES("IES Santa Emerenciana", 40.333129, -1.106468));
        listaIES.add(new IES("IES Vega del Turia", 40.341010, -1.108578));
        listaIES.add(new IES("IES Francés de Aranda", 40.351363913011305, -1.1100639896163713));
        listaIES.add(new IES("Escuela de Hostelería", 40.34340547937843, -1.1075374026132745));
        listaIES.add(new IES("CPFP de San Blas", 40.348413325388755, -1.1695804838164572));
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng teruel = new LatLng(40.34215462530947, -1.1071156044052786);
        for(IES i:listaIES){
            LatLng posicion = new LatLng(i.getLatitud(),i.getLongitud());
            String nombre = i.getNombre().toString();
            int imgId = 0;
            switch (nombre){
                case "IES Segundo de Chomón":
                    imgId = R.drawable.segundo;
                    break;
                case "IES Santa Emerenciana":
                    imgId = R.drawable.santa;
                    break;
                case "IES Vega del Turia":
                    imgId = R.drawable.vega;
                    break;
                case "IES Francés de Aranda":
                    imgId = R.drawable.frances;
                    break;
                case "Escuela de Hostelería":
                    imgId = R.drawable.cocina;
                    break;
                case "CPFP de San Blas":
                    imgId = R.drawable.pantano;
                    break;
            }
            mMap.addMarker(new MarkerOptions().position(posicion).icon(BitmapDescriptorFactory
                    .fromResource(imgId)).title(nombre));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(teruel,11.7f));
    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}