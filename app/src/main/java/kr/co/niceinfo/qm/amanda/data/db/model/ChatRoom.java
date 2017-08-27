package kr.co.niceinfo.qm.amanda.data.db.model;

/**
 * Created by Woo-Young on 2017-08-27.
 */

//채팅방
public class ChatRoom extends BaseModel{

    private String chatRoomId;  //채팅방번호
    private String chatRoomNm;  // 채팅방명
    private String forAllChatRoomYn;  // 전체 채팅방 여부
    private String deptCd;  // 부서코드

    public String getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(String chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getChatRoomNm() {
        return chatRoomNm;
    }

    public void setChatRoomNm(String chatRoomNm) {
        this.chatRoomNm = chatRoomNm;
    }

    public String getForAllChatRoomYn() {
        return forAllChatRoomYn;
    }

    public void setForAllChatRoomYn(String forAllChatRoomYn) {
        this.forAllChatRoomYn = forAllChatRoomYn;
    }

    public String getDeptCd() {
        return deptCd;
    }

    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "chatRoomId='" + chatRoomId + '\'' +
                ", chatRoomNm='" + chatRoomNm + '\'' +
                ", forAllChatRoomYn='" + forAllChatRoomYn + '\'' +
                ", deptCd='" + deptCd + '\'' +
                "} " + super.toString();
    }
}
