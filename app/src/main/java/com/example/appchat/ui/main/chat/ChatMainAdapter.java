package com.example.appchat.ui.main.chat;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.appchat.ui.main.addfriend.OtherFriendFragment;
import com.example.appchat.ui.main.checkfriend.FriendWaitResponse;

public class ChatMainAdapter extends FragmentPagerAdapter {

    public ChatMainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new FriendFrag();
        }
        if (position == 1){
            return new OtherFriendFragment();
        }
        return new FriendWaitResponse();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return "Friend";
        }
        if (position == 1){
            return "Other Friend";
        }
        return "Accept make Friend";
    }

}
