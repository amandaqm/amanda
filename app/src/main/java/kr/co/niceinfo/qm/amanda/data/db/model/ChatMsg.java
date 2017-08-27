package kr.co.niceinfo.qm.amanda.data.db.model;

/**
 * Created by Woo-Young on 2017-08-27.
 */

//채팅 대화내용
public class ChatMsg extends BaseModel {

    private String chatRoomId;  //채팅방번호
    private String userId;      // 사용자ID
    private String chatContent; //채팅대화내용

    public String getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(String chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    @Override
    public String toString() {
        return "ChatMsg{" +
                "chatRoomId='" + chatRoomId + '\'' +
                ", userId='" + userId + '\'' +
                ", chatContent='" + chatContent + '\'' +
                "} " + super.toString();
    }
}
