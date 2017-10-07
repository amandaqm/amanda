package kr.co.niceinfo.qm.amanda.ui.event;

import kr.co.niceinfo.qm.amanda.data.db.model.Board;

/**
 * Created by fruitbites on 2017-10-07.
 */

public class NoticeEditEvent {
    Board board;
    public NoticeEditEvent(Board board) {
        this.board = board;
    }
    public Board getBoard() {
        return board;
    }
}
