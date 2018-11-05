package com.mmc.data.structure.system.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @packageName：com.mmc.data.structure.system.file
 * @desrciption: 读取文件
 * @author: gaowei
 * @date： 2018-11-05 14:10
 * @history: (version) author date desc
 */
public class ReadAccessFile {

    private File checkFile;
    private FileChannel fileChannel;
    private final long DEFAULT_BUFFER_SIZE = 4096;
    private long offset = 0;
    private final long fileSize;
    private final String desc;

    public ReadAccessFile(File checkFile, String desc) throws FileNotFoundException {
        this.checkFile = checkFile;
        this.desc = desc;
        this.fileSize = this.checkFile.length();
        this.fileChannel = new RandomAccessFile(this.checkFile, "r").getChannel();
    }

    /**
     * 读取一批次数据
     * @return
     */
    public synchronized String[] readNextString() throws IOException {
        byte[] byteBuffer = readNextbytes();
        if (byteBuffer.length == 0) {
            return null;
        }
        String readerStrs = new String(byteBuffer);
        int pos = readerStrs.lastIndexOf("");
        if (pos == 0) {
            return null;
        }
        readerStrs = readerStrs.substring(0, pos);
        long bufferSize = readerStrs.getBytes().length;
        offset = offset + bufferSize;
        // 获取批次查找对账数据
        String[] datas = readerStrs.split("");
        return datas;
    }

    /**
     * 读取字节数组
     * @return
     * @throws IOException
     */
    private byte[] readNextbytes() throws IOException {
        long len = (offset + DEFAULT_BUFFER_SIZE) > this.fileSize ? (fileSize - offset) : DEFAULT_BUFFER_SIZE;
        MappedByteBuffer mbb = this.fileChannel.map(FileChannel.MapMode.READ_ONLY, offset, len);
        int capacity = mbb.capacity();
        byte[] byteBuffer = new byte[capacity];
        for (int i = 0; i < capacity; i++) {
            byteBuffer[i] = mbb.get();
        }
        mbb.clear();
        return byteBuffer;
    }

    /**
     * 释放
     */
    public void clear() throws Exception {
        if (fileChannel != null && fileChannel.isOpen()) {
            fileChannel.close();
        }
    }

}
