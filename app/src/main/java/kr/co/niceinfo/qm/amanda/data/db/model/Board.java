package kr.co.niceinfo.qm.amanda.data.db.model;

/**
 * Created by Woo-Young on 2017-08-27.
 */

public class Board extends BaseModel {

    private String boardId;            // 게시판 코드 (공지사항: B0001)
    private Long postingId;            // 게시글 번호
    private String postingTitle;       // 게시글 제목
    private String postingContent;     // 게시글 내용
    private String alarmYn;            // 알림 여부

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public Long getPostingId() {
        return postingId;
    }

    public void setPostingId(Long postingId) {
        this.postingId = postingId;
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

    public String getAlarmYn() {
        return alarmYn;
    }

    public void setAlarmYn(String alarmYn) {
        this.alarmYn = alarmYn;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId='" + boardId + '\'' +
                ", postingId=" + postingId +
                ", postingTitle='" + postingTitle + '\'' +
                ", postingContent='" + postingContent + '\'' +
                ", alarmYn='" + alarmYn + '\'' +
                "} " + super.toString();
    }
}
