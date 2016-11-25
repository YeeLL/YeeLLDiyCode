package yeell.yeelldiycode.utils.apiutils;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
import yeell.yeelldiycode.models.TokenModel;
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

    /**
     *
     * @param client_id 97309948
     * @param client_secret 1b0f75ba32713d58a7b1ea96f000d8da65e42035253c93a65b3998bff8d6df96
     * @param grant_type password
     * @param password 密码
     * @param username 账号
     * @return
     */
    @POST("oauth/token")
    Observable<TokenModel> getCookieAndToken(@Query("client_id") String client_id,
                                             @Query("client_secret") String client_secret,
                                             @Query("grant_type") String grant_type,
                                             @Query("password") String password,
                                             @Query("username") String username);
}
