package yeell.yeelldiycode.utils.apiutils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by YeeLL on 11/25/16.
 */

public class ApiCookieMannager {

    private static ApiService mApiService;

    public static ApiService getCookie() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl("http://www.diycode.cc/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApiService = mRetrofit.create(ApiService.class);
        return mApiService;
    }
}
