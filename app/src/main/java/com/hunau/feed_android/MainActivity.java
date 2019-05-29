package com.hunau.feed_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hunau.feed_android.cmd.Command;

import transsocket.TcpClient;

public class MainActivity extends AppCompatActivity {
    TcpClient tcpClient;

    private String FAN = Command.CLOSEFAN;
    private String FAN02 = Command.CLOSEFANTWO;
    private String GUA = Command.CLOSEGUA;
    private String CHUANG = Command.CLOSECHUANG;
    private String TOU = Command.CLOSETOU;
    private String SHUI = Command.CLOSESHUI;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        FAN = Command.CLOSEFAN;
        FAN02 = Command.CLOSEFANTWO;
        GUA = Command.CLOSEGUA;
        CHUANG = Command.CLOSECHUANG;
        TOU = Command.CLOSETOU;
        SHUI = Command.CLOSESHUI;
    }

    public void link(View view) throws Exception {
        tcpClient = new TcpClient();
        if (tcpClient == null)
            textView.setText("建立连接失败!");
        else
            textView.setText("建立连接成功!");
    }

    public void fan(View view) throws Exception {
        if (tcpClient != null) {
            FAN = FAN.equals(Command.CLOSEFAN) ? Command.OPENFAN : Command.CLOSEFAN;
            tcpClient.sendMsg(FAN);
            if (FAN.equals(Command.OPENFAN))
                textView.setText("已打开风扇1!");
            else
                textView.setText("已关闭风扇1!");
        } else {
            System.out.println("请先建立连接!");
            textView.setText("请先建立连接!");
        }
    }

    public void fanTwo(View view) throws Exception {
        if (tcpClient != null) {
            FAN02 = FAN02.equals(Command.CLOSEFANTWO) ? Command.OPENFANTWO : Command.CLOSEFANTWO;
            tcpClient.sendMsg(FAN02);
            if (FAN02.equals(Command.OPENFANTWO))
                textView.setText("已打开风扇2!");
            else
                textView.setText("已关闭风扇2!");
        } else {
            System.out.println("请先建立连接!");
            textView.setText("请先建立连接!");
        }
    }

    public void gua(View view) throws Exception {
        if (tcpClient != null) {
            GUA = GUA.equals(Command.CLOSEGUA) ? Command.OPENGUA : Command.CLOSEGUA;
            tcpClient.sendMsg(GUA);
            if (GUA.equals(Command.OPENGUA))
                textView.setText("已打开刮粪板!");
            else
                textView.setText("已关闭刮粪板!");
        } else {
            System.out.println("请先建立连接!");
            textView.setText("请先建立连接!");
        }
    }

    public void chuang(View view) throws Exception {
        if (tcpClient != null) {
            CHUANG = CHUANG.equals(Command.CLOSECHUANG) ? Command.OPENCHUANG : Command.CLOSECHUANG;
            tcpClient.sendMsg(CHUANG);
            if (CHUANG.equals(Command.OPENCHUANG))
                textView.setText("已打开窗帘!");
            else
                textView.setText("已关闭窗帘!");
        } else {
            System.out.println("请先建立连接!");
            textView.setText("请先建立连接!");
        }
    }

    public void tou(View view) throws Exception {
        if (tcpClient != null) {
            TOU = TOU.equals(Command.CLOSETOU) ? Command.OPENTOU : Command.CLOSETOU;
            tcpClient.sendMsg(TOU);
            if (TOU.equals(Command.OPENTOU))
                textView.setText("已打开投食!");
            else
                textView.setText("已关闭投食!");
        } else
            System.out.println("请先建立连接!");
    }

    public void shui(View view) throws Exception {
        if (tcpClient != null) {
            SHUI = SHUI.equals(Command.CLOSESHUI) ? Command.OPENSHUI : Command.CLOSESHUI;
            tcpClient.sendMsg(SHUI);
            if (SHUI.equals(Command.OPENSHUI))
                textView.setText("已打开喂水!");
            else
                textView.setText("已关闭喂水!");
        } else {
            System.out.println("请先建立连接!");
            textView.setText("请先建立连接!");
        }
    }
}
