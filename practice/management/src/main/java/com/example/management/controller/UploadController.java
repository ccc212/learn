package com.example.management.controller;

import com.example.management.pojo.Result;
import com.example.management.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {


//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws Exception {
//        log.info("文件上传: {},{},{}",username,age,image);
//
//        String originalFilename = image.getOriginalFilename();
//
//        //构造唯一文件名 - uuid(通用唯一识别码)
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);
//        String newFileName = UUID.randomUUID() +extname;
//        log.info("新的文件名: {}",newFileName);
//
//        image.transferTo(new File("E:\\gitProject\\learn\\practice\\management\\images\\"+newFileName));
//
//        return Result.success();
//    }

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传,文件名:{}",image.getOriginalFilename());

        String url = aliOSSUtils.upload(image);

        log.info("文件上传成功,文件路径:{}",url);

        return Result.success(url);
    }
}
