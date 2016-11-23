package yeell.yeelldiycode.rxUtils.apiutils;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;
import yeell.yeelldiycode.home.Impl.TopicFragment;
import yeell.yeelldiycode.home.Impl.TopicModel;
import yeell.yeelldiycode.home.Impl.UserModel;

/**
 * Created by yee on 11/19/16.
 */

public interface ApiService {

    @GET("news.json")
    Observable<Object> getNews();

    @GET("users.json")
    Observable<UserModel> getListModel();

    @GET("topics.json")
    Observable<List<TopicModel>> getTopicList();
}
