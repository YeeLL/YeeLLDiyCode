package yeell.yeelldiycode.rxUtils.apiutils;

import retrofit2.http.GET;
import retrofit2.http.Header;
import rx.Observable;
import yeell.yeelldiycode.model.main.impl.UserModel;

/**
 * Created by yee on 11/19/16.
 */

public interface ApiService {

    @GET("news.json")
    Observable<Object> getNews();

    @GET("users.json")
    Observable<UserModel> getListModel();

}
