package com.example.calculator_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator_final.adapter.CategoryAdapter;
import com.example.calculator_final.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewDataBinding binding;
    EditText etNums;
    TextView tvResult;
    ImageButton btnOne,btnTwo;
    //String oper;
    //LinearLayout llRes;
    RecyclerView categoryRecycler;
    //CategoryAdapter categoryAdapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        List<Category> categoryList=new ArrayList<>();
        categoryList.add(new Category(1,"Простой"));
        categoryList.add(new Category(2,"Инженерный"));
        categoryList.add(new Category(3,"Бухгалтерский"));
        categoryList.add(new Category(4,"Финансовый"));
        categoryList.add(new Category(5,"Графический"));
        
        setCategoryRecycler(categoryList);
        etNums=(EditText) findViewById(R.id.etNums);
        btnOne=(ImageButton) findViewById(R.id.btnOne);
        btnTwo=(ImageButton) findViewById(R.id.btnTwo);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);



    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        categoryRecycler=findViewById(R.id.recyclerView);
        categoryRecycler.setLayoutManager(layoutManager);
        CategoryAdapter categoryAdapter = new CategoryAdapter(this,categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }


    @Override
    public void onClick(View view) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);

        switch (view.getId()){
            case R.id.btnOne:etNums.setText(binding.getText() + "0");
            break;
            case R.id.btnTwo:etNums.setText('2');
            break;
            default:
                break;
        }

    }
}