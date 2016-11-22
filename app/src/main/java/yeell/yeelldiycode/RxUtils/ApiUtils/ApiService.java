package yeell.yeelldiycode.RxUtils.ApiUtils;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yee on 11/19/16.
 */

public interface ApiService {

    @GET("hello.json")
    Observable<Object> hello();

    @GET("news.json")
    Observable<Object> getNews();
}
