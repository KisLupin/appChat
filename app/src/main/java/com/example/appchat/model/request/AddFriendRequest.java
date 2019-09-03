package com.example.appchat.model.request;

public class  AddFriendRequest {

    private int sender_id;
    private int receiver_id;
    private boolean is_sended;

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    public boolean isIs_sended() {
        return is_sended;
    }

    public void setIs_sended(boolean is_sended) {
        this.is_sended = is_sended;
    }
}
