package com.hello.rechargeapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] ints = new int[]{1, 5, 10, 20, 50, 100};
    private ItemAdapter itemAdapter;
    private EditText edt_phone;
    private RecyclerView rv_recharge;
    private Button btn_recharge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        rv_recharge.setLayoutManager(layoutManager);
        itemAdapter = new ItemAdapter(ints);
        rv_recharge.setAdapter(itemAdapter);
    }

    private void initView() {
        edt_phone = (EditText) findViewById(R.id.edt_phone);
        rv_recharge = (RecyclerView) findViewById(R.id.rv_recharge);
        btn_recharge = (Button) findViewById(R.id.btn_recharge);
        btn_recharge.setOnClickListener(this);
    }

    private void submit() {
        // validate
        String phone = edt_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "充值号码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        int index = itemAdapter.getPositionIndex();
        String money = ints[index] + "元";
        Toast.makeText(this, "充值账户：" + phone + " 充值金额：" + money, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_recharge:
                submit();
                break;
        }
    }
}
