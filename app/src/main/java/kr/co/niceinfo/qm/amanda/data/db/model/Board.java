package kr.co.niceinfo.qm.amanda.data.db.model;

/**
 * Created by Woo-Young on 2017-08-27.
 */

//게시판(공지사항)
public class Board extends BaseModel {

    private String boardId;            // 게시판 코드 (공지사항: B0001)
    private Long postingId;            // 게시글 번호
    private String postingTitle;       // 게시글 제목
    private String postingContent;     // 게시글 내용
    private String alarmYn;            // 알림 여부

    public Board() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        if (boardId != null ? !boardId.equals(board.boardId) : board.boardId != null) return false;
        if (postingId != null ? !postingId.equals(board.postingId) : board.postingId != null)
            return false;
        if (postingTitle != null ? !postingTitle.equals(board.postingTitle) : board.postingTitle != null)
            return false;
        if (postingContent != null ? !postingContent.equals(board.postingContent) : board.postingContent != null)
            return false;
        return alarmYn != null ? alarmYn.equals(board.alarmYn) : board.alarmYn == null;

    }

    @Override
    public int hashCode() {
        int result = boardId != null ? boardId.hashCode() : 0;
        result = 31 * result + (postingId != null ? postingId.hashCode() : 0);
        result = 31 * result + (postingTitle != null ? postingTitle.hashCode() : 0);
        result = 31 * result + (postingContent != null ? postingContent.hashCode() : 0);
        result = 31 * result + (alarmYn != null ? alarmYn.hashCode() : 0);
        return result;
    }
}
