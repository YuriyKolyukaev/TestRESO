package ru.kolyukaev.testreso.data.network.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.kolyukaev.testreso.data.network.response.FullResponceOfOffices;

public interface DataOfOfficesService {
    @GET("/free/v2/agencies/{reg}")
    Call<List<FullResponceOfOffices>> loadOffices(@Path("reg") int region);
}
