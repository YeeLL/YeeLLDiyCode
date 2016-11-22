package yeell.yeelldiycode.rxUtils.apiutils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yee on 11/21/16.
 */
public class ApiManagers {

    private static ApiService mApiService;

    public static ApiService getApiService() {
        if (mApiService == null) {
           Retrofit mRetrofit = new Retrofit.Builder()
                    .baseUrl("http://diycode.cc/api/v3/")
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mApiService = mRetrofit.create(ApiService.class);
        }
        return mApiService;
    }

}
