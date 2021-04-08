package ru.kolyukaev.testreso.view.fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentTransaction;

import moxy.presenter.InjectPresenter;
import ru.kolyukaev.testreso.R;
import ru.kolyukaev.testreso.data.model.ProgressEuroProtocol;
import ru.kolyukaev.testreso.data.providers.MyLocationListener;
import ru.kolyukaev.testreso.data.providers.RLocationListener;
import ru.kolyukaev.testreso.presenter.ButtonsPresenter;
import ru.kolyukaev.testreso.view.ButtonsView;

import static android.app.Activity.RESULT_CANCELED;

public class ButtonsFragment extends BaseFragment implements ButtonsView, RLocationListener {

    private MyLocationListener myLocationListener;
    private LocationManager locationManager;

    private double lat = 0;
    private double lon = 0;
    int regionNumber = 0;

    private Button btnGetCoordinates;
    private Button btnGetRegion;
    private Button btnShowOffices;
    private ProgressBar progress;

    public final static String ARG_REGION = "Region";

    @InjectPresenter
    ButtonsPresenter buttonsPresenter;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_buttons, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnGetCoordinates = view.findViewById(R.id.bt_get_coordinates);
        btnGetRegion = view.findViewById(R.id.bt_get_region);
        btnShowOffices = view.findViewById(R.id.bt_get_offies);
        progress = view.findViewById(R.id.progress);

        ProgressEuroProtocol progressEuroProtocol = (ProgressEuroProtocol) view.findViewById(R.id.pb_euro_protocol);
        progressEuroProtocol.setValue(55);

        View.OnClickListener oclBtnGetCoordinates = v -> findLocation();
        btnGetCoordinates.setOnClickListener(oclBtnGetCoordinates);

        View.OnClickListener oclBtnGetRegion = v -> getRegion(lat, lon);
        btnGetRegion.setOnClickListener(oclBtnGetRegion);

        View.OnClickListener oclBtnShowOffices = v -> sendBundleData(regionNumber);
        btnShowOffices.setOnClickListener(oclBtnShowOffices);
    }

    @Override
    public void findLocation() {
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        myLocationListener = new MyLocationListener();
        myLocationListener.setLocationListener(this);
        checkPermission();
        btnGetCoordinates.setEnabled(false);
        progress.setVisibility(View.VISIBLE);
    }

    // запрос разрашения GPS, если ещё не дано.
    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 100);
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 600, 1000, myLocationListener);
        }
    }

    // ответ резрешения GPS
    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults[0] == RESULT_CANCELED) {
            checkPermission();
            btnGetCoordinates.setEnabled(false);
        } else {
            Toast.makeText(getActivity(), "No GPS permission", Toast.LENGTH_SHORT).show();
            progress.setVisibility(View.INVISIBLE);
        }
    }

    // получить координаты
    @Override
    public void onLocationChanged(Location loc) {
        btnGetCoordinates.setEnabled(false);
        btnGetRegion.setEnabled(true);
        progress.setVisibility(View.INVISIBLE);
        lat = loc.getLatitude();
        lon = loc.getLongitude();
    }

    // получить регион
    @Override
    public void getRegion(double lat, double lon) {
        progress.setVisibility(View.VISIBLE);
        buttonsPresenter.loadRegion(lat, lon);
    }

    // регион получен
    @Override
    public void regionReceived(int regionNumber) {
        this.regionNumber = regionNumber;
        btnGetRegion.setEnabled(false);
        progress.setVisibility(View.INVISIBLE);
        btnShowOffices.setEnabled(true);
    }

    // передать регион
    private void sendBundleData(int regionNumber) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        OfficeListFragment officeListFragment = new OfficeListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_REGION, regionNumber);
        officeListFragment.setArguments(bundle);
        transaction.replace(R.id.container, officeListFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void showError(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        btnShowOffices.setEnabled(false);
        btnGetCoordinates.setEnabled(true);
        super.onDestroyView();
    }
}