package ru.kolyukaev.testreso.data.network;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.kolyukaev.testreso.data.network.api.DataOfOfficesService;
import ru.kolyukaev.testreso.data.network.api.DataOfRegionService;

public class RestClient {

    private static final String WEB_SERVER_URL = "https://mobile.reso.ru/";

    Interceptor createLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    public DataOfRegionService createRetrofitRegion() {
        Interceptor loggingInterceptor = createLoggingInterceptor();
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WEB_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(DataOfRegionService.class);
    }

    public DataOfOfficesService createRetrofitOffices() {
        Interceptor loggingInterceptor = createLoggingInterceptor();
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WEB_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(DataOfOfficesService.class);
    }
}
