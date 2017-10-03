package kr.co.niceinfo.qm.amanda.ui.notice.list;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.ui.base.BaseViewHolder;

/**
 * Created by Woo-Young on 2017-09-16.
 */

public class NoticeAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final String TAG = "NoticeAdapter extends";

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private List<Board> mBoardList;

    // Pass in the contact array into the constructor
    public NoticeAdapter(List<Board> BoardList) {
        Log.i(TAG, "[wychoi] NoticeAdapter - BoardList: "+BoardList.size());
        this.mBoardList = BoardList;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Log.i(TAG, "[wychoi] onBindViewHolder - position: "+ position);
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(TAG, "[wychoi] onCreateViewHolder - viewType: "+viewType);

        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notice_list, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        Log.i(TAG, "[wychoi] getItemViewType - position: "+position);
        if (mBoardList != null && mBoardList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "[wychoi] getItemCount");
        if (mBoardList != null && mBoardList.size() > 0) {
            return mBoardList.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<Board> boardList) {
        Log.i(TAG, "[wychoi] addItems: "+boardList.size());
        mBoardList.addAll(boardList);
        notifyDataSetChanged();
    }



    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_posting_id)
        TextView tvPostingId;

        @BindView(R.id.tv_posting_title)
        TextView tvPostingTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            Log.i(TAG, "[wychoi] ViewHolder");
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            Log.i(TAG, "[wychoi] clear");
            tvPostingId.setText("");
            tvPostingTitle.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);
            Log.i(TAG, "[wychoi] onBind - position : "+position);

            final Board notice = mBoardList.get(position);

            if (notice.getKey() != null) {
                tvPostingId.setText(notice.getKey());
            }

            if (notice.getPostingTitle() != null) {
                tvPostingTitle.setText(notice.getPostingTitle());
            }
        }
    }


    public class EmptyViewHolder extends BaseViewHolder {

        @BindView(R.id.btn_retry)
        Button retryButton;

        @BindView(R.id.tv_message)
        TextView messageTextView;

        public EmptyViewHolder(View itemView) {
            super(itemView);
            Log.i(TAG, "[wychoi] EmptyViewHolder");
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {
            Log.i(TAG, "[wychoi] clear()");

        }
    }
}
