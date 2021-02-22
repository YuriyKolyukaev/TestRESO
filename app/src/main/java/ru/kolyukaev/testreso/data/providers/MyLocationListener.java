package ru.kolyukaev.testreso.data.providers;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class MyLocationListener implements LocationListener {
    private RLocationListener locationListener;

    @Override
    public void onLocationChanged(Location location) {
        locationListener.onLocationChanged(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public void setLocationListener(RLocationListener locationListener) {
        this.locationListener = locationListener;
    }
}
