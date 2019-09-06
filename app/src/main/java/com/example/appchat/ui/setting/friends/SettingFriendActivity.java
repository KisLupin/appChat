package com.example.appchat.ui.setting.friends;

import android.os.Bundle;
import android.os.UserManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appchat.R;
import com.example.appchat.interact.Common;
import com.example.appchat.interact.CommonData;
import com.example.appchat.interact.UserService;
import com.example.appchat.model.LastMess;
import com.example.appchat.model.response.FriendChated;
import com.example.appchat.model.response.FriendResponse;
import com.example.appchat.model.response.MessageChatResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SettingFriendActivity extends AppCompatActivity implements View.OnClickListener, FragAllImageSendedAdapter.IIMage {

    private FriendChated friendChated;
    private RecyclerView rc;
    private UserService userService;
    private ImageView ava;
    private List<MessageChatResponse> messageChatResponses;
    private FragAllImageSendedAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_setting_friend_chat);
        friendChated =
                (FriendChated) getIntent()
                        .getSerializableExtra(
                                "detail");
        findViewById(R.id.backButton).setOnClickListener(this);
        ava = findViewById(R.id.ava_in_set);
        Glide.with(this)
                .load(friendChated.getFriend_avatar())
                .into(ava);
        rc = findViewById(R.id.rc_photo_in_setting_friend_chat);
        rc.setLayoutManager(new GridLayoutManager(this,3));
        adapter = new FragAllImageSendedAdapter(this);
        rc.setAdapter(adapter);
        getAllImage();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backButton:
                finish();
                break;
                default:
                    break;
        }
    }

    private void getAllImage(){
        userService = Common.getUserService();
        if (  CommonData.getInstance().getUserProfile() == null ){
            return;
        }
        userService.getImg("IMG"
                ,CommonData.getInstance().getUserProfile().getId()
                ,friendChated.getFriend_id())
                .enqueue(new Callback<List<MessageChatResponse>>() {
                    @Override
                    public void onResponse(Call<List<MessageChatResponse>> call, Response<List<MessageChatResponse>> response) {
                        messageChatResponses = response.body();
                        adapter.notifyDataSetChanged();
                    }
                    @Override
                    public void onFailure(Call<List<MessageChatResponse>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }


    @Override
    public int getCount() {
        if (messageChatResponses == null)
        {
            return 0;
        }
        return messageChatResponses.size();
    }

    @Override
    public MessageChatResponse getData(int pos) {
        return messageChatResponses.get(pos);
    }

    @Override
    public void onClick(int pos) {

    }
}
