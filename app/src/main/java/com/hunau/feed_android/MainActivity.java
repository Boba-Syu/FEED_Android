package com.hunau.feed_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hunau.feed_android.cmd.Command;

import transsocket.TcpClient;

public class MainActivity extends AppCompatActivity {
    TcpClient tcpClient;
    private String FAN = Command.OPENFAN;
    private String FAN02 = Command.OPENFANTWO;
    private String GUA = Command.OPENGUA;
    private String CHUANG = Command.OPENCHUANG;
    private String TOU = Command.OPENTOU;
    private String SHUI = Command.OPENSHUI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void link(View view) throws Exception {
        tcpClient = new TcpClient();
    }

    public void fan(View view) throws Exception {
        if (tcpClient != null) {
            tcpClient.sendMsg(FAN);
            FAN = FAN == Command.CLOSEFAN ? Command.OPENFAN : Command.CLOSEFAN;
        } else
            System.out.println("请先建立连接!");
    }

    public void fanTwo(View view) throws Exception {
        if (tcpClient != null) {
            tcpClient.sendMsg(FAN02);
            FAN02 = FAN == Command.CLOSEFANTWO ? Command.OPENFANTWO : Command.CLOSEFANTWO;
        } else
            System.out.println("请先建立连接!");
    }

    public void gua(View view) throws Exception {
        if (tcpClient != null) {
            tcpClient.sendMsg(GUA);
            GUA = GUA == Command.CLOSEGUA ? Command.OPENGUA : Command.CLOSEGUA;
        } else
            System.out.println("请先建立连接!");
    }

    public void chuang(View view) throws Exception {
        if (tcpClient != null) {
            tcpClient.sendMsg(CHUANG);
            CHUANG = CHUANG == Command.CLOSECHUANG ? Command.OPENCHUANG : Command.CLOSECHUANG;
        } else
            System.out.println("请先建立连接!");
    }

    public void tou(View view) throws Exception {
        if (tcpClient != null) {
            tcpClient.sendMsg(TOU);
            TOU = TOU == Command.CLOSETOU ? Command.OPENTOU : Command.CLOSETOU;
        } else
            System.out.println("请先建立连接!");
    }

    public void shui(View view) throws Exception {
        if (tcpClient != null) {
            tcpClient.sendMsg(SHUI);
            SHUI = SHUI == Command.CLOSESHUI ? Command.OPENSHUI : Command.CLOSESHUI;
        } else
            System.out.println("请先建立连接!");
    }
}
