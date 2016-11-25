package yeell.yeelldiycode.adapter.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yeell.yeelldiycode.R;
import yeell.yeelldiycode.models.home.TopicModel;
import yeell.yeelldiycode.utils.ImageLoader;

/**
 * Created by YeeLL on 11/24/16.
 */

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.viewHolder> {

    private List<TopicModel> mList;
    private Context mContext;
    private ImageLoader mImageLoader;

    public TopicAdapter(List<TopicModel> list, Context context) {
        this.mList = list;
        this.mContext = context;
        mImageLoader = ImageLoader.getInstance();
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_topic, parent, false));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        TopicModel topicModel = mList.get(position);
        holder.title.setText(topicModel.title);
        holder.name.setText(topicModel.user.name);
        mImageLoader.loadImage(holder.header, topicModel.user.avatar_url, mContext);
        holder.type.setText("· " + topicModel.node_name);
//        holder.time.setText(topicModel.created_at);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_home_topic_collection_img)
        ImageView collection;
        @BindView(R.id.item_home_topic_desc_txt)
        TextView desc;
        @BindView(R.id.item_home_topic_desc_img)
        ImageView descImg;
        @BindView(R.id.item_home_topic_header_img)
        ImageView header;
        @BindView(R.id.item_home_topic_name_txt)
        TextView name;
        @BindView(R.id.item_home_topic_time_txt)
        TextView time;
        @BindView(R.id.item_home_topic_title_txt)
        TextView title;
        @BindView(R.id.item_home_topic_type)
        TextView type;
        @BindView(R.id.item_home_topic_zhan_img)
        ImageView zhan;

        public viewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
