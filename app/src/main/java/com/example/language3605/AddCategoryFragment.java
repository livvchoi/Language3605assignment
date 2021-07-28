package com.example.language3605;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCategoryFragment extends Fragment {

    private static final String TAG = "AddCategoryFragment";

    DatabaseReference addDatabaseReference;

    Button buttonToCategoryFragment;

    EditText addCategory;

    DatabaseReference databaseCategories = FirebaseDatabase.getInstance().getReference("CategoriesLocale");
    DatabaseReference databaseCategory = FirebaseDatabase.getInstance().getReference("CategoriesList");

    public static String id;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_addcategory, container, false);

        buttonToCategoryFragment = contentView.findViewById(R.id.button3);
        buttonToCategoryFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction qFrag = getParentFragmentManager().beginTransaction();
                qFrag.replace(R.id.fragment_container, new CategoryFragment());
                qFrag.commit();

                addData();
            }
        });

        addCategory = contentView.findViewById(R.id.categoryPlainText);

        return contentView;
    }

    private void addData(){

        String Category = addCategory.getText().toString().trim();

        id = databaseCategories.push().getKey();

        String Language = HomeFragment.languageClicked;

        String image = databaseCategory.push().getKey();

        Category category = new Category(id, Category, Language, image);

        Category category1 = new Category(id,image, Category);


        databaseCategories.child(id).setValue(category);

        databaseCategory.child(id).setValue(category1);

    }
}
