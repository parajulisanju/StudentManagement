package com.example.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Service
public class FileIOService {

	public String uploadFile(MultipartFile multipartFile) {
		try {
			File file = new File(System.getProperty("java.io.tmpdir") + "/" + multipartFile.getOriginalFilename());
			multipartFile.transferTo(file);
			AmazonS3 amazonS3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
			String bucketName = "sanju-students";
			amazonS3.putObject(bucketName, multipartFile.getOriginalFilename(), file);
			return "success";

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}

	}
}
