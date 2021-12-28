package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.service.FileIOService;

@RestController
@RequestMapping("/files")
@CrossOrigin(origins = "*")
public class FileIOController {
	@Autowired
	private FileIOService fileIoService;

	@RequestMapping(method = RequestMethod.POST, value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadFile(@RequestPart("file") MultipartFile file) {
		String status = fileIoService.uploadFile(file);
		return status;
	}

}
