package yeell.yeelldiycode.home;


import java.util.List;

import yeell.yeelldiycode.home.Impl.TopicModel;
import yeell.yeelldiycode.home.Impl.UserModel;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by yee on 11/21/16.
 */

public interface IHomeView {

     <T> void loadData(List<T> topicModel);

}
