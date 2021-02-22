package ru.kolyukaev.testreso.view.fragments;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import moxy.presenter.InjectPresenter;
import ru.kolyukaev.testreso.R;
import ru.kolyukaev.testreso.data.model.Office;
import ru.kolyukaev.testreso.presenter.OfficeListPresenter;
import ru.kolyukaev.testreso.view.OfficeListView;
import ru.kolyukaev.testreso.view.adapters.OfficeItemListener;
import ru.kolyukaev.testreso.view.adapters.OfficesAdapter;

public class OfficeListFragment extends BaseFragment implements OfficeListView, OfficeItemListener {
    OfficesAdapter officesAdapter;

    @InjectPresenter
    OfficeListPresenter officeListPresenter;

    private FrameLayout flRoot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_office_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        flRoot = view.findViewById(R.id.fl_office_root);
        RecyclerView officesList = view.findViewById(R.id.rv_offices);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        officesList.setLayoutManager(linearLayoutManager);
        officesList.setHasFixedSize(true);
        officesAdapter = new OfficesAdapter(this);
        officesList.setAdapter(officesAdapter);

        // получить список офисов
        officeListPresenter.loadOffices(checkBundleData());
    }

    public Integer checkBundleData() {
        return getArguments().getInt(ButtonsFragment.ARG_REGION);
    }

    @Override
    public void showOffices(List<Office> offices) {
        officesAdapter.updateAdapter(offices);
    }

    @Override
    public void showError(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemClick(String officeName) {
        Snackbar.make(flRoot, officeName, Snackbar.LENGTH_SHORT)
                .setAction(getString(R.string.close), view -> { })
                .show();
    }
}