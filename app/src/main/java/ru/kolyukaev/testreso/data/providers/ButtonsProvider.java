package ru.kolyukaev.testreso.data.providers;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.kolyukaev.testreso.data.network.RestClient;
import ru.kolyukaev.testreso.data.network.api.DataOfRegionService;
import ru.kolyukaev.testreso.data.network.response.Region;
import ru.kolyukaev.testreso.presenter.ButtonsPresenter;

public class ButtonsProvider {
    private final ButtonsPresenter buttonsPresenter;
    DataOfRegionService dataOfRegionService = new RestClient().createRetrofitRegion();

    public ButtonsProvider(ButtonsPresenter buttonsPresenter) {
        this.buttonsPresenter = buttonsPresenter;
    }

    public void loadingRegion(double lat, double lon) {
        Log.i("kyus1", "lat " + lat + " lon " + lon);

        Call<List<Region>> call = dataOfRegionService.loadRegion(lat, lon);
        call.enqueue(new Callback<List<Region>>() {
            @Override
            public void onFailure(@NotNull Call<List<Region>> call, @NotNull Throwable t) {
                buttonsPresenter.onError(String.valueOf(t));
            }

            @Override
            public void onResponse(@NotNull Call<List<Region>> call, @NotNull Response<List<Region>> response) {
                if (response.code() == 200) {
                    Integer region = response.body().get(0).getId();
                    buttonsPresenter.loadedRegion(region);
                }
            }
        });
    }




}


