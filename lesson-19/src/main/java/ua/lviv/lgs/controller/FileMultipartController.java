package ua.lviv.lgs.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.domain.FileMultipart;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.FileMultipartService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class FileMultipartController {

	@Autowired
	FileMultipartService fileMultipartService;
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("user", new User());
		return "index";
	}

	@PostMapping("/registerUser")
	public String uploadFile(@RequestParam("file") MultipartFile file,
							 @ModelAttribute User user, Model model) throws IOException {
		FileMultipart fileMultipart = fileMultipartService.storeFile(file);
		user.setPhotoId(fileMultipart.getId());
		model.addAttribute("user",user);
		return "profile";
	}

	@GetMapping("/getPhoto/{fileId}")
	public void downlaodFile(@PathVariable String fileId, HttpServletResponse response) throws IOException {
		FileMultipart fileMultipart = fileMultipartService.getFile(fileId);
		response.setContentType("image/jpeg");
		byte[] bytes = fileMultipart.getData();
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
}

