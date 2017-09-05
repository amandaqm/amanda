package kr.co.niceinfo.qm.amanda.data.db.model;

/**
 * Created by Woo-Young on 2017-08-27.
 */

//채팅 대화내용
public class ChatMsg extends BaseModel {

    private String chatRoomId;  //채팅방번호
    private String userId;      // 사용자ID
    private String chatContent; //채팅대화내용

    public ChatMsg() {
    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatMsg chatMsg = (ChatMsg) o;

        if (chatRoomId != null ? !chatRoomId.equals(chatMsg.chatRoomId) : chatMsg.chatRoomId != null)
            return false;
        if (userId != null ? !userId.equals(chatMsg.userId) : chatMsg.userId != null) return false;
        return chatContent != null ? chatContent.equals(chatMsg.chatContent) : chatMsg.chatContent == null;

    }

    @Override
    public int hashCode() {
        int result = chatRoomId != null ? chatRoomId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (chatContent != null ? chatContent.hashCode() : 0);
        return result;
    }
}
