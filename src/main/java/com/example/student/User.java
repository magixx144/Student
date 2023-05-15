package com.example.student;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Magixx
 * @Date 2023 04 17 15 59
 **/
public class User {

    //public static String paths = "D:\\work\\SoftwareEngineering\\Student\\Student\\info\\stuinfo.txt";

    public static List readTxts(String paths) throws IOException {  //把文件读成beans
        InputStreamReader isr = new InputStreamReader(new FileInputStream(paths), "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        int count = 0;
        List list = new ArrayList();
        while ((line = br.readLine()) != null) {
            LoginTxtObject txt = new LoginTxtObject();
            String[] arr = line.split(",");
            if (arr.length > 3) {
                txt.setFirstname(arr[0]);
                txt.setLastname(arr[1]);
                txt.setUsername(arr[2]);
                txt.setPassword(arr[3]);
                list.add(txt);
            }
            count++;

        }
        System.out.println(list);
        System.out.println("读取总条数：" + count + "||读取的list的长度" + list.size());

        return list;

    }
}