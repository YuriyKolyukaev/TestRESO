package ru.kolyukaev.testreso.data.network;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.kolyukaev.testreso.data.network.api.DataOfOfficesService;
import ru.kolyukaev.testreso.data.network.api.DataOfRegionService;

public class RestClient {

    Interceptor createLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    public DataOfRegionService createRetrofitRegion() {
        Interceptor loggingInterceptor = createLoggingInterceptor();
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mobile.reso.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(DataOfRegionService.class);
    }

    public DataOfOfficesService createRetrofitOffices() {
        Interceptor loggingInterceptor = createLoggingInterceptor();
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mobile.reso.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(DataOfOfficesService.class);
    }
}
