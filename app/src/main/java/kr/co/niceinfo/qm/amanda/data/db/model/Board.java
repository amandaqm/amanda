package kr.co.niceinfo.qm.amanda.data.db.model;

/**
 * Created by Woo-Young on 2017-08-27.
 */

public class Board extends BaseModel {

    private String board_id;            // 게시판 코드 (공지사항: B0001)
    private Long posting_id;            // 게시글 번호
    private String posting_title;       // 게시글 제목
    private String posting_content;     // 게시글 내용
    private String alarm_yn;            // 알림 여부

    public String getBoard_id() {
        return board_id;
    }

    public void setBoard_id(String board_id) {
        this.board_id = board_id;
    }

    public Long getPosting_id() {
        return posting_id;
    }

    public void setPosting_id(Long posting_id) {
        this.posting_id = posting_id;
    }

    public String getPosting_title() {
        return posting_title;
    }

    public void setPosting_title(String posting_title) {
        this.posting_title = posting_title;
    }

    public String getPosting_content() {
        return posting_content;
    }

    public void setPosting_content(String posting_content) {
        this.posting_content = posting_content;
    }

    public String getAlarm_yn() {
        return alarm_yn;
    }

    public void setAlarm_yn(String alarm_yn) {
        this.alarm_yn = alarm_yn;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board_id='" + board_id + '\'' +
                ", posting_id=" + posting_id +
                ", posting_title='" + posting_title + '\'' +
                ", posting_content='" + posting_content + '\'' +
                ", alarm_yn='" + alarm_yn + '\'' +
                "} " + super.toString();
    }
}
