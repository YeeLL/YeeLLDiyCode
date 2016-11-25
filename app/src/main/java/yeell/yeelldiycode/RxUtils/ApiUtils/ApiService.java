package yeell.yeelldiycode.rxUtils.apiutils;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
import yeell.yeelldiycode.models.home.TopicModel;
import yeell.yeelldiycode.models.home.UserModel;

/**
 * Created by yee on 11/19/16.
 */

public interface ApiService {

    @GET("news.json")
    Observable<Object> getNews();

    @GET("users.json")
    Observable<UserModel> getListModel();

    @POST("topics.json")
    Observable<List<TopicModel>> getTopicList(@Query("offset") int offset);
}
