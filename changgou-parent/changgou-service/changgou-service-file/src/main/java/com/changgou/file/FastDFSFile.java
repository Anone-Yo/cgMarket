package com.changgou.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/*****
 * @Author: www.itheima.com
 * @Description: com.changgou.file
 * 封装要上传的文件的信息
 ****/
public class FastDFSFile implements Serializable {

    //文件名字
    private String name;         //multipartFile.getOriginalFilename()
    //文件内容
    private byte[] content;     //multipartFile.getBytes()
    //文件扩展名
    private String ext;         //可以获取  124356.jpg   ->  jpg
    //文件MD5摘要值
    private String md5;
    //文件创建作者
    private String author;

    public FastDFSFile() {
    }

    public FastDFSFile(String name, byte[] content, String ext) {
        this.name = name;
        this.content = content;
        this.ext = ext;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
