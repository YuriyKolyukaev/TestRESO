package ru.kolyukaev.testreso.view.fragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import moxy.presenter.InjectPresenter;
import ru.kolyukaev.testreso.R;
import ru.kolyukaev.testreso.data.model.Office;
import ru.kolyukaev.testreso.presenter.OfficeListPresenter;
import ru.kolyukaev.testreso.view.OfficeListView;
import ru.kolyukaev.testreso.view.adapters.OfficesAdapter;

public class OfficeListFragment extends BaseFragment implements OfficeListView {
    OfficesAdapter officesAdapter;

    @InjectPresenter
    OfficeListPresenter officeListPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_office_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView officesList = view.findViewById(R.id.rv_offices);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        officesList.setLayoutManager(linearLayoutManager);
        officesList.setHasFixedSize(true);
        officesAdapter = new OfficesAdapter();
        officesList.setAdapter(officesAdapter);

        // получить список офисов
        officeListPresenter.loadOffices(checkBundleData());
    }

    public Integer checkBundleData() {
        int region = getArguments().getInt(ButtonsFragment.REGION);
        return region;
    }

    @Override
    public void showOffices(List<Office> offices) {
        officesAdapter.updateAdapter(offices);
    }

    @Override
    public void showError(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

}