package kr.co.niceinfo.qm.amanda.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import kr.co.niceinfo.qm.amanda.R;
import kr.co.niceinfo.qm.amanda.data.db.model.Board;
import kr.co.niceinfo.qm.amanda.utils.ViewUtils;
import timber.log.Timber;

/**
 * Created by fruitbites on 2017-09-17.
 */

public class NoticeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    public static final int CONTENT = 2;

    // 아이템 리스트
    private List<Board> data = new ArrayList<Board>();


    private PublishSubject<Board> mPublishSubject;

    private Context mContext;


    public NoticeListAdapter(Context context) {
        this.mContext = context;
        this.mPublishSubject = PublishSubject.create();
    }

    public void addAll(List<Board> boards) {
        data.addAll(boards);
    }

    public void add(Board incident) {
        data.add(incident);
    }

    public void add(int index,Board incident) { data.add(index,incident);}

    public void clear() {
        data.clear();
    }

    public int size() {
        return data.size();
    }

    public void remove(int position) {
        data.remove(position);
    }
    public Board get(int position) {
        return data.get(position);
    }





    @Override
    public int getItemViewType(int position) {
        Board incident = data.get(position);
        return CONTENT;
    }


    @Override
    public int getItemCount()
    {
        return data.size();
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int i)
    {

        BoardViewHolder vh = (BoardViewHolder)holder;
        final Board board = data.get(i);

        try {

            vh.mTvPostingTitle.setText(board.getPostingTitle());
            vh.mTvPostingRegdt.setText(ViewUtils.standard(board.getRegDt()));
            vh.mTvPostingContent.setText(board.getPostingContent());
            vh.mTvPostingRegid.setText(board.getRegId());
        }
        catch(Exception e) {
            Timber.i(e,"onBindViewHolder(...)");
        }


        vh.getClickObserver(board).subscribe(mPublishSubject);


    }

    public PublishSubject<Board> getPublishSubject() {
        return mPublishSubject;
    }
    
    /* (non-Javadoc)
     * @see android.support.v7.widget_info.RecyclerView.Adapter#onCreateViewHolder(android.view.ViewGroup, int)
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {


        RecyclerView.ViewHolder holder = null;

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());


        View itemView = inflater.inflate(R.layout.item_notice_list, parent, false);
        return new BoardViewHolder(itemView);
    }



    public class AdViewHolder extends RecyclerView.ViewHolder {
        
        public AdViewHolder(View view) {
            super(view);
        }
    }

    /**
     * The Class CardViewHolder is the View Holder class for Adapter views.
     */
    public class BoardViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.item) View view;

        @BindView(R.id.tv_posting_title) TextView mTvPostingTitle;
        @BindView(R.id.tv_posting_regdt)  TextView mTvPostingRegdt;
        @BindView(R.id.tv_posting_regid) TextView mTvPostingRegid;
        @BindView(R.id.tv_posting_content) TextView mTvPostingContent;
        



        public BoardViewHolder(View v)
        {
            super(v);
            ButterKnife.bind(this,v);
        }

        Observable<Board> getClickObserver(Board board)  {

            return Observable.create(e->view.setOnClickListener(view->e.onNext(board)));
        }


    }
}