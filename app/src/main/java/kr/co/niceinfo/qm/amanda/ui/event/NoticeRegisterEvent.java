package kr.co.niceinfo.qm.amanda.ui.event;

import kr.co.niceinfo.qm.amanda.data.db.model.Board;

/**
 * Created by fruitbites on 2017-10-07.
 */

public class NoticeRegisterEvent {
    Board board;
    public NoticeRegisterEvent(Board board) {
        this.board = board;
    }
    public Board getBoard() {
        return board;
    }
}
