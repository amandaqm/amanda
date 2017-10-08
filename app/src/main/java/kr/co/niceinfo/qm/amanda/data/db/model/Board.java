package kr.co.niceinfo.qm.amanda.data.db.model;

import java.util.Date;

/**
 * Created by Woo-Young on 2017-08-27.
 */

//게시판(공지사항)

public class Board extends BaseModel {

    private String key;                 // 게시글 번호
    private String postingTitle;       // 게시글 제목
    private String postingContent;     // 게시글 내용
    private String nofificationYn;     // 게시글 알림여부



    public Board() {
        this("",new Date(),"",new Date(),"",0,"","","","");
    }

    public Board(String status, Date regDt, String regId, Date modDt, String modId, int ver, String key, String postingTitle, String postingContent, String nofificationYn) {
        super(status, regDt, regId, modDt, modId, ver);
        this.key = key;
        this.postingTitle = postingTitle;
        this.postingContent = postingContent;
        this.nofificationYn = nofificationYn;
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

    public String getNofificationYn() {
        return nofificationYn;
    }

    public void setNofificationYn(String nofificationYn) {
        this.nofificationYn = nofificationYn;
    }

    @Override
    public String toString() {
        return "Board{" +
                "key='" + key + '\'' +
                ", postingTitle='" + postingTitle + '\'' +
                ", postingContent='" + postingContent + '\'' +
                ", nofificationYn='" + nofificationYn + '\'' +
                "} " + super.toString();
    }
}

