package com.changgou.controller;

import com.changgou.file.FastDFSFile;
import com.changgou.util.FastDFSClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/*****
 * @Author: www.itheima.com
 * @Description: com.changgou.controller
 ****/
@RestController
public class FileUploadController {


    /***
     * 文件上传
     * @param file  文件包装对象
     */
    @PostMapping(value = "/upload")
    public Result upload(MultipartFile file) throws Exception{
        //文件信息封装
        FastDFSFile fastDFSFile = new FastDFSFile(
                file.getOriginalFilename(),        // 文件名字
                file.getBytes(),                   // 文件内容
                StringUtils.getFilenameExtension(file.getOriginalFilename())); // 文件扩展名

        //调用FastDFSClient实现文件上传
        String[] uploads = FastDFSClient.upload(fastDFSFile);
        //String url = "http://192.168.211.132:8080/"+uploads[0]+"/"+uploads[1];
        String url = "http://:8080/"+uploads[0]+"/"+uploads[1];
        return new Result(true, StatusCode.OK,"文件上传成功！",url);
    }
}
