package com.emmanuel_yegon.foodordering.Activity;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.emmanuel_yegon.foodordering.Adapter.PopularAdapter;
import com.emmanuel_yegon.foodordering.Domain.FoodDomain;
import com.emmanuel_yegon.foodordering.Helper.ManagementCart;
import com.emmanuel_yegon.foodordering.R;
import com.emmanuel_yegon.foodordering.databinding.ActivityShowDetailBinding;

public class ShowDetailActivity extends AppCompatActivity {

    ActivityShowDetailBinding binding;

    private TextView addToCartBtn;
    private TextView txtTitle, txtPrice, txtDescription, txtNumberOrder;
    private ImageView plusBtn, minusBtn, picFood;
    private FoodDomain object;
    PopularAdapter adapter;
    int numberOrder = 1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managementCart = new ManagementCart(this);

        initView();
        getBundle();

        binding.getRoot();
    }

    private void getBundle() {
        object = (FoodDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        txtTitle.setText(object.getTitle());
        txtPrice.setText("$" + object.getFee());
        txtDescription.setText(object.getDescription());
        txtNumberOrder.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder += 1;
                txtNumberOrder.setText(String.valueOf(numberOrder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOrder > 1) {
                    numberOrder = numberOrder - 1;
                }
                txtNumberOrder.setText(String.valueOf(numberOrder));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(numberOrder);
                managementCart.insertFood(object);
            }
        });

    }
    private void initView() {
        addToCartBtn = binding.addToCartBtn;
        txtTitle = binding.txtTitle;
        txtPrice = binding.txtPrice;
        txtDescription = binding.txtDescription;
        txtNumberOrder = binding.txtNumberOrder;
        plusBtn = binding.plusBtn;
        minusBtn = binding.minusBtn;
        picFood=binding.picFood;
    }

}