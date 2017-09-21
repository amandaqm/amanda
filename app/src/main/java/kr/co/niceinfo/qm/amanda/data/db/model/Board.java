package kr.co.niceinfo.qm.amanda.data.db.model;

/**
 * Created by Woo-Young on 2017-08-27.
 */

//게시판(공지사항)

public class Board extends BaseModel {

    private String key;                 // 게시글 번호
    private String postingTitle;       // 게시글 제목
    private String postingContent;     // 게시글 내용


    public Board() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPostingTitle() {
        return postingTitle;
    }

    public void setPostingTitle(String postingTitle) {
        this.postingTitle = postingTitle;
    }

    public String getPostingContent() {
        return postingContent;
    }

    public void setPostingContent(String postingContent) {
        this.postingContent = postingContent;
    }


    @Override
    public String toString() {
        return "Board{" +
                "key='" + key + '\'' +
                ", postingTitle='" + postingTitle + '\'' +
                ", postingContent='" + postingContent + '\'' +
                '}';
    }
}

