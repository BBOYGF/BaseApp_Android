package com.example.baseapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.baseapp.R;
import com.example.baseapp.dao.MyUserDao;
import com.example.baseapp.database.Database;
import com.example.baseapp.po.MyUser;
import com.example.baseapp.view_model.FragmentViewModel;
import com.example.baseapp.view_model.MainViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private FragmentViewModel fragmentViewModel;

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentViewModel = new ViewModelProvider(this).get(FragmentViewModel.class);
        fragmentViewModel.a++;
        getLifecycle().addObserver(fragmentViewModel);
        Log.i("测试是否会再次创建", "f: " + fragmentViewModel.hashCode() + "|" + fragmentViewModel.a);
        View view = inflater.inflate(R.layout.fragment_choice, container, false);
        Button bt1 = view.findViewById(R.id.button);
        Database userDatabase = Room.databaseBuilder(getActivity().getApplication(), Database.class, "user_database")
                .allowMainThreadQueries()
                .build();
        MyUserDao userDao = userDatabase.getUserDao();
        userDao.insertUser(new MyUser("张三", 18));
        List<MyUser> allUser = userDao.getAllUser();
        for (int i = 0; i < allUser.size(); i++) {
            Log.i("数据", "onCreateView: " + allUser.get(i).getName());
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        Log.i("测试是否会再次创建", "f: " + fragmentViewModel.hashCode() + "|" + fragmentViewModel.a);
    }
}