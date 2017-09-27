package kr.co.niceinfo.qm.amanda.ui.notice.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;

/**
 * Created by Woo-Young on 2017-09-16.
 */

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {


    private List<Board> mBoardList;
    private Context mContext;

    // Pass in the contact array into the constructor
    public NoticeAdapter(List<Board> mBoardList, Context mContext) {
        this.mBoardList = mBoardList;
        this.mContext = mContext;
    }

    // Easy access to the context object in the recyclerview
    private Context getmContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View noticeView = inflater.inflate(R.layout.item_notice_list, parent, false);

        // return a new holder instance
        ViewHolder viewHolder = new ViewHolder(noticeView);
        return viewHolder;

    }

    public void addItems(List<Board> boards) {
        mBoardList.addAll(boards);
        notifyDataSetChanged();
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(NoticeAdapter.ViewHolder viewHolder, int position) {

        Board board = mBoardList.get(position);

        TextView tvPostingId = viewHolder.tvPostingId;
        tvPostingId.setText(board.getKey());

        TextView tvPostingTitle = viewHolder.tvPostingTitle;
        tvPostingTitle.setText(board.getPostingTitle());
    }


    @Override
    public int getItemCount() {
        return mBoardList.size();
    }


    //inflate the view and its view holder
    //bind data to the view
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView tvPostingId;
        public TextView tvPostingTitle;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            tvPostingId = (TextView) itemView.findViewById(R.id.tv_posting_id);
            tvPostingTitle = (TextView) itemView.findViewById(R.id.tv_posting_title);
        }
    }
}
