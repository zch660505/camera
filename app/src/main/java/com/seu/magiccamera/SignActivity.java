package com.seu.magiccamera;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.seu.magiccamera.dao.DaoUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class SignActivity extends Activity implements View.OnClickListener  {



    Button btnLogin;

    private EditText et_mobile;
    private EditText et_password;
    private EditText et_password_one;
    private ImageView iv_clean_phone;
    private ImageView clean_password;
    private ImageView clean_password_one;
    private ImageView iv_show_pwd;
    private ImageView iv_show_pwd_one;
    private boolean flag = false;
    private boolean flag1 = false;

    private int screenHeight = 0;//屏幕高度
    private float scale = 0.8f; //logo缩放比例
    private View service, body;

    private View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        btnLogin  = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        initView();
        initListener();
    }


    private void initView() {
        et_mobile = (EditText) findViewById(R.id.et_mobile);
        et_password = (EditText) findViewById(R.id.et_password);
        et_password_one = (EditText) findViewById(R.id.et_password_one);
        iv_clean_phone = (ImageView) findViewById(R.id.iv_clean_phone);
        clean_password = (ImageView) findViewById(R.id.clean_password);
        clean_password_one = (ImageView) findViewById(R.id.clean_password_one);
        iv_show_pwd = (ImageView) findViewById(R.id.iv_show_pwd);
        iv_show_pwd_one = (ImageView) findViewById(R.id.iv_show_pwd_one);
        service = findViewById(R.id.service);
        body = findViewById(R.id.body);
        screenHeight = this.getResources().getDisplayMetrics().heightPixels; //获取屏幕高度
        root = findViewById(R.id.root);
        findViewById(R.id.close).setOnClickListener(this);
    }

    private void initListener() {
        iv_clean_phone.setOnClickListener(this);
        clean_password.setOnClickListener(this);
        iv_show_pwd.setOnClickListener(this);
        iv_show_pwd_one.setOnClickListener(this);

        et_mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && iv_clean_phone.getVisibility() == View.GONE) {
                    iv_clean_phone.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    iv_clean_phone.setVisibility(View.GONE);
                }
            }
        });
        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && clean_password.getVisibility() == View.GONE) {
                    clean_password_one.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    clean_password.setVisibility(View.GONE);
                }
                if (s.toString().isEmpty())
                    return;
                if (!s.toString().matches("[A-Za-z0-9]+")) {
                    String temp = s.toString();
                    Toast.makeText(SignActivity.this, R.string.please_input_limit_pwd, Toast.LENGTH_SHORT).show();
                    s.delete(temp.length() - 1, temp.length());
                    et_password.setSelection(s.length());
                }
            }
        });

        et_password_one.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && clean_password_one.getVisibility() == View.GONE) {
                    clean_password_one.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    clean_password_one.setVisibility(View.GONE);
                }
                if (s.toString().isEmpty())
                    return;
                if (!s.toString().matches("[A-Za-z0-9]+")) {
                    String temp = s.toString();
                    Toast.makeText(SignActivity.this, R.string.please_input_limit_pwd, Toast.LENGTH_SHORT).show();
                    s.delete(temp.length() - 1, temp.length());
                    et_password_one.setSelection(s.length());
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.regist:
//                startActivity(new Intent(MainActivity.this, SignActivity.class));
                break;
            case R.id.iv_clean_phone:
                et_mobile.setText("");
                break;
            case R.id.clean_password:
                et_password.setText("");
                break;
            case R.id.close:
                finish();
                break;
            case R.id.iv_show_pwd:
                if (flag == true) {
                    et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    iv_show_pwd.setImageResource(R.drawable.pass_gone);
                    flag = false;
                } else {
                    et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    iv_show_pwd.setImageResource(R.drawable.pass_visuable);
                    flag = true;
                }
                String pwd = et_password.getText().toString();
                if (!TextUtils.isEmpty(pwd))
                    et_password.setSelection(pwd.length());
                break;
            case R.id.iv_show_pwd_one:
                if (flag1 == true) {
                    et_password_one.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    iv_show_pwd_one.setImageResource(R.drawable.pass_gone);
                    flag1 = false;
                } else {
                    et_password_one.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    iv_show_pwd_one.setImageResource(R.drawable.pass_visuable);
                    flag1 = true;
                }
                String password = et_password_one.getText().toString();
                if (!TextUtils.isEmpty(password))
                    et_password_one.setSelection(password.length());
                break;
            case R.id.btn_login:

                String phoneNum = et_mobile.getText().toString();
                String password1 = et_password.getText().toString();
                String passwordOne = et_password_one.getText().toString();
                if (isChinaPhoneLegal(phoneNum)) {
                    Log.d("zch", "onClick: 2");
                    if (password1.equals(passwordOne)) {

                        if (DaoUtils.getInstance().insertDao(phoneNum, password1)) {
                            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                        }
                        finish();
                    } else {
                        Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "请输入正确的电话号码", Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.forget_password:
                break;
            default:
                break;
        }
    }

    public boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
