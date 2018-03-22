package com.heyi.demo.annotation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.heyi.demo.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);

        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                annotationField();
                break;
            case R.id.bt2:
                annotationMethod();
                break;
        }
    }

    private void annotationMethod() {
        try {
            Class c = Class.forName("com.heyi.demo.annotation.TestClass");
            TestClass tc = (TestClass) c.newInstance();

            Method[] methods = c.getDeclaredMethods();
            for(Method method: methods){
                if(method.isAnnotationPresent(BindGet.class)){
                    BindGet bindGet = method.getAnnotation(BindGet.class);
                    String param = bindGet.value();
                    method.invoke(tc, param);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 对于类属性（成员变量）设定注解
    private void annotationField() {

        try {
            Class c = Class.forName("com.heyi.demo.annotation.TestClass");
            TestClass tc = (TestClass) c.newInstance();

            Field[] fields = c.getDeclaredFields();
            for(Field field: fields){
                if(field.isAnnotationPresent(BindPort.class)){
                    BindPort port = field.getAnnotation(BindPort.class);
                    field.setAccessible(true);
                    field.set(tc, port.value());
                }
                if(field.isAnnotationPresent(BindAddress.class)){
                    BindAddress address = field.getAnnotation(BindAddress.class);
                    field.setAccessible(true);
                    field.set(tc, address.value());
                }
            }
            tc.printInfo();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
