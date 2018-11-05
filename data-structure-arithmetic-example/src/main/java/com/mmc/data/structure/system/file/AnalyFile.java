package com.mmc.data.structure.system.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @packageName：com.mmc.data.structure.system.file
 * @desrciption: 分析日志文件中请求响应时间大于某个时间点
 * @author: gaowei
 * @date： 2018-11-05 14:10
 * @history: (version) author date desc
 */
public class AnalyFile {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final String total = "total";
    private static final String branch = "branch";

    public static void main(String[] args) {
        String filePath = "D:\\code\\infogw_ice_server.2018110401.log";
        System.out.println(filePath);
        readFile(filePath);

        filePath = "D:\\code\\infogw_ice_server.2018110402.log";
        System.out.println(filePath);
        readFile(filePath);
    }

    public static void readFile(String filePath) {
        FileReader fr = null;
        BufferedReader br = null;
        Scanner scanner = null;

        Map<AnalyEtity, String> map = new HashMap<>(18);
        Map<String, AtomicLong> totalMap = new HashMap<>(48);
        totalMap.put(total, new AtomicLong(0));
        totalMap.put(branch, new AtomicLong(0));

        try {
            br = new BufferedReader(new FileReader(filePath));
            String str = null;
            while ((str = br.readLine()) != null) {
                if (!isStartEnd(str)) {
                    continue;
                }
                analyContent(str, map, totalMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("统计结果：");
        System.out.println("total: " + totalMap.get(total).get());
        System.out.println("大于10s : " + totalMap.get(branch).get());
    }

    public static void analyContent(String content, Map<AnalyEtity, String> map, Map<String, AtomicLong> totalMap) throws ParseException {
        // parse content
        String startStr = "[infogw-ice]";
        content = content.substring(startStr.length());
        String[] contentResult = content.split(" ");
        String last = contentResult[7];
        if (last == null) {
            return;
        }
        String date = contentResult[0] + " " + contentResult[1];
        String thread = contentResult[2].substring(1, contentResult[2].length() - 1);
        String uuid = contentResult[4];
        uuid = uuid.substring(1, uuid.length() - 1);

        AnalyEtity analyEtity = new AnalyEtity(uuid, thread);
        if (last.endsWith("Start")) {
            map.put(analyEtity, date);
        } else if (last.endsWith("End")) {
            if (map.containsKey(analyEtity)) {
                String tempDate = map.get(analyEtity);
                Date startDate = dateFormat.parse(tempDate);
                Date endDate = dateFormat.parse(date);
                long sec = (endDate.getTime() - startDate.getTime()) / 1000;
                if (sec >= 10) {
                    totalMap.get(total).incrementAndGet();
                    totalMap.get(branch).incrementAndGet();
                } else {
                    totalMap.get(total).incrementAndGet();
                }
            }
        }
    }



    public static boolean isStartEnd(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        if (str.endsWith("Start") || str.endsWith("End")) {
            return true;
        }
        return false;
    }


    static class AnalyEtity {
        private String uuid;
        private String thread;

        public AnalyEtity(){

        }

        public AnalyEtity(String uuid, String thread) {
            this.uuid = uuid;
            this.thread = thread;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            AnalyEtity that = (AnalyEtity) o;

            if (!uuid.equals(that.uuid)) {
                return false;
            }
            return thread.equals(that.thread);
        }

        @Override
        public int hashCode() {
            int result = uuid.hashCode();
            result = 31 * result + thread.hashCode();
            return result;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getThread() {
            return thread;
        }

        public void setThread(String thread) {
            this.thread = thread;
        }
    }
}
