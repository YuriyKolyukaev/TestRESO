package ru.kolyukaev.testreso.data.network.api;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.kolyukaev.testreso.data.network.response.Region;

public interface DataOfRegionService {

    @GET("/free/v2/myregion/{lat}/{lon}")
    Call<List<Region>> loadRegion(@Path("lat") double lat,
                                 @Path("lon") double lon);

}
