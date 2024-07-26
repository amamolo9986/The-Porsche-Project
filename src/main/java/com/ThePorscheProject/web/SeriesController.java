package com.ThePorscheProject.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ThePorscheProject.service.FileService;

@Controller
public class SeriesController {
	
	private FileService fileService;
	
	public SeriesController(FileService fileService) {
		super();
		this.fileService = fileService;
	}

	@GetMapping("/series")
	public String getSeries() {
		return "series";
	}
	
	@GetMapping("/process-csv")
	public ResponseEntity<String> processCsv() {
		fileService.readBannerFile();
		fileService.readDescriptionFile();
//		fileService.readMasterFile();
		return ResponseEntity.ok("CSV processing successful!");
	}

}
