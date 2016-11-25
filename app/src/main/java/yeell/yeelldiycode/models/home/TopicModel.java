package yeell.yeelldiycode.models.home;

import java.io.Serializable;

/**
 * Created by yee on 11/23/16.
 */

public class TopicModel implements Serializable {
    private static final long serialVersionUID = 8151841239396791155L;

    public int id;
    public String title;
    public String created_at;
    public String updated_at;
    public String replied_at;
    public int replies_count;
    public String node_name;
    public int node_id;
    public int last_reply_user_id;
    public String last_reply_user_login;
    public boolean deleted;
    public boolean excellent;
    public AbilitiesModel abilities;
    public UserModel user;
}
