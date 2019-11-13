package com.vms.driver.activities.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.vms.driver.R;

public class ProfileProofFragment extends Fragment {

    private ProfileProofFragmentViewModel profileProofFragmentViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        profileProofFragmentViewModel =
                ViewModelProviders.of(this).get(ProfileProofFragmentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile_proof, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        profileProofFragmentViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
