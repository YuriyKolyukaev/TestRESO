package ru.kolyukaev.testreso.data.providers;

import android.util.Log;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.kolyukaev.testreso.data.model.Office;
import ru.kolyukaev.testreso.data.network.RestClient;
import ru.kolyukaev.testreso.data.network.api.DataOfOfficesService;
import ru.kolyukaev.testreso.data.network.response.FullResponceOfOffices;
import ru.kolyukaev.testreso.presenter.OfficeListPresenter;

public class OfficeListProvider {
    OfficeListPresenter officeListPresenter;
    DataOfOfficesService dataOfOfficesService = new RestClient().createRetrofitOffices();

    public OfficeListProvider(OfficeListPresenter officeListPresenter) {
        this.officeListPresenter = officeListPresenter;
    }

    public void loadingOffices(int region) {
        Log.i("kyus2", "region " + region);

        Call<List<FullResponceOfOffices>> call = dataOfOfficesService.loadOffices(region);
        call.enqueue(new Callback<List<FullResponceOfOffices>>() {
            @Override
            public void onFailure(@NotNull Call<List<FullResponceOfOffices>> call, @NotNull Throwable t) {
                officeListPresenter.onError(String.valueOf(t));
            }

            @Override
            public void onResponse(@NotNull Call<List<FullResponceOfOffices>> call, @NotNull Response<List<FullResponceOfOffices>> response) {
                if (response.code() == 200) {
                    List<FullResponceOfOffices> fullResponse = response.body();
                    List<Office> officeResponce = new ArrayList<>();
                    Log.i("dasdas", "onResponse: " + fullResponse.size());

                    for (int i = 0; i < fullResponse.size(); i++) {
                        Office office = new Office();

                        FullResponceOfOffices item = fullResponse.get(i);

                        office.setsShortName(item.getSshortname());
                        office.setsShortAddress(item.getSshortAddress());
                        office.setGraf(item.getGraf());
                        officeResponce.add(office);
                    }

                    Log.i("dasdas", "onResponse: " + officeResponce.size());
                    officeListPresenter.onListOfficeLoaded(officeResponce);
                }
            }
        });
    }
}
