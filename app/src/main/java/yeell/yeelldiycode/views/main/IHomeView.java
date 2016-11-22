package yeell.yeelldiycode.views.main;

import yeell.yeelldiycode.model.main.impl.UserModel;

/**
 * Created by yee on 11/21/16.
 */

public interface IHomeView {

    void updateUserInfo(UserModel userModel);

    void changeFragment(int tagId);
}
