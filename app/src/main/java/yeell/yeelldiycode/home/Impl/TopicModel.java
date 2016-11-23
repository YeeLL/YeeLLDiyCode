package yeell.yeelldiycode.home.Impl;

import java.io.Serializable;

/**
 * Created by yee on 11/23/16.
 */

public class TopicModel implements Serializable {
    private static final long serialVersionUID = 8151841239396791155L;

    int id;
    String title;
    String created_at;
    String updated_at;
    String replied_at;
    int replies_count;
    String node_name;
    int node_id;
    int last_reply_user_id;
    String last_reply_user_login;
    boolean deleted;
    boolean excellent;
    AbilitiesModel abilities;
    UserModel user;
}
