package com.example.language3605;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class SplashScreenFragment extends Fragment {
    private TextView ssUnderstand, mDisclaimer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_splash_screen, container, false);

        //code here
        ssUnderstand = contentView.findViewById(R.id.tv_IUnderstand);
        mDisclaimer = contentView.findViewById(R.id.tv_disclaimer);
        mDisclaimer.setMovementMethod(new ScrollingMovementMethod());

        ssUnderstand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new HomeFragment());
                fragmentTransaction.commit();
            }
        });

        return contentView;
    }
}
