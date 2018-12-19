package com.mmc.data.structure.system.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @packageName：com.mmc.data.structure.system.file
 * @desrciption:
 * @author: gaowei
 * @date： 2018-11-06 13:33
 * @history: (version) author date desc
 */
public class AnalyNameFile {


    public static void main(String[] args) {
        String filePath = "D:\\code\\whole.txt";
        String desPath = "D:\\code\\gao.txt";
        readFile(filePath, desPath);
    }

    public static void readFile(String filePath, String desPath) {
        BufferedReader br = null;
        BufferedWriter fw = null;

        try {
            br = new BufferedReader(new FileReader(filePath));
            fw = new BufferedWriter(new FileWriter(desPath));
            String str = null;
            while ((str = br.readLine()) != null) {
                if (str.contains("高")) {
                    fw.write(str);
                    fw.write("\r\n");
                } else {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

            if (fw != null) {
                try {
                    fw.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
