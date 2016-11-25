package yeell.yeelldiycode.utils.apiutils;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import yeell.yeelldiycode.utils.DataUtil;

/**
 * Created by yee on 11/21/16.
 */
public class ApiManagers {

    private static ApiService mApiService;
    private static String mToken;
    private static OkHttpClient.Builder httpClient;

    public static void setToken(String token, Context context) {
        mToken = token;
        DataUtil.getInstance().saveToken(context, DataUtil.TOKEN, token);
    }

    public static ApiService getApiService() {
        if (mApiService == null) {
            Retrofit mRetrofit = null;
            httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .addHeader("Authorization", "Bearer " + mToken)
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                }
            });
            OkHttpClient client = httpClient.build();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl("http://diycode.cc/api/v3/")
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

            mApiService = mRetrofit.create(ApiService.class);
        }
        return mApiService;
    }

}
