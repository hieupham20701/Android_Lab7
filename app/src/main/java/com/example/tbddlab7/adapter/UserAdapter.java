package com.example.tbddlab7.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tbddlab7.R;
import com.example.tbddlab7.model.User;

import org.w3c.dom.Text;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<User> users;

    public UserAdapter(Context context, int idLayout, List<User> users) {
        this.context = context;
        this.idLayout = idLayout;
        this.users = users;
    }

    @Override
    public int getCount() {
        if (users.size() != 0) {
            return users.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout, viewGroup, false);
        }

        TextView name = (TextView) view.findViewById(R.id.textView);
        User user = users.get(position);
        name.setText(user.getName());
        return view;
    }
}
