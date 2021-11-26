package com.example.garden;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MyPageFragment extends Fragment{
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.mypage_frag,container, false);

        ImageButton ShoppingCart = view.findViewById(R.id.btnShoppingCart);
        ShoppingCart.setColorFilter(Color.parseColor("#000000"));
        ShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingCartActivity.class);
                startActivity(intent);
            }
        });

        TabLayout tL;
        ViewPager vP;

        tL = (TabLayout) view.findViewById(R.id.my_tab);
        vP = (ViewPager) view.findViewById(R.id.my_view);

        tL.addTab(tL.newTab().setText("프로필"));
        tL.addTab(tL.newTab().setText("나의 쇼핑"));

        MyPageAdapter adapter = new MyPageAdapter(getChildFragmentManager(),
                tL.getTabCount());

        vP.setAdapter(adapter);

        tL.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vP.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

        return view;

    }
}
