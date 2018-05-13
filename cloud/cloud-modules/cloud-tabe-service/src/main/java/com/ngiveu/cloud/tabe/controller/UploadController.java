package com.ngiveu.cloud.tabe.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.luhuiguo.fastdfs.domain.StorePath;
import com.luhuiguo.fastdfs.service.FastFileStorageClient;
import com.ngiveu.cloud.common.bean.config.FdfsPropertiesConfig;
import com.ngiveu.cloud.common.web.BaseController;
import com.xiaoleilu.hutool.io.FileUtil;

/**
 * 上传文件控制类
 * 
 * @author gaz
 * @date 2018年5月13日
 */
@RestController
@RequestMapping("/upload")
public class UploadController extends BaseController {
	
	 @Autowired
	 private FastFileStorageClient fastFileStorageClient;
	    
	 @Autowired
	 private FdfsPropertiesConfig fdfsPropertiesConfig;
	 
	 /**
	  * 上传文件
	  * 
	  * @param multipartFile => RequestParam("file")
	  * @return filename=url
	  * @author gaz
	  */
	 @GetMapping
	 public Map<String, String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
		Map<String, String> result = new HashMap<String, String>(1);
		try {
			StorePath storePath = this.fastFileStorageClient.uploadFile(multipartFile.getBytes(), FileUtil.extName(multipartFile.getOriginalFilename()));
			result.put("filename", this.fdfsPropertiesConfig.getFileHost() + storePath.getFullPath());
		} catch (IOException e) {
			logger.error("[上传错误] - 文件上传出错");
			e.printStackTrace();
			result.put("filename", "");
		}
		return result;
	 }
}
