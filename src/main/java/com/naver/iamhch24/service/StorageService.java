//package com.naver.iamhch24.service;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.MalformedURLException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.web.multipart.MultipartFile;
//
////@Service
//public class StorageService {
//
////	@Value("${service.file.uploadurl}")
////	private String fileUploadPath;
//	
//	/**
//	 * 파일 업로드
//	 * @param file
//	 */
//	public void store(MultipartFile file, String filename) {
////		String filename = StringUtils.cleanPath(file.getOriginalFilename());
//		try {
//			InputStream inputStream = file.getInputStream();
//			Files.copy(inputStream, getPath().resolve(filename),
//					StandardCopyOption.REPLACE_EXISTING);
//			
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * 파일 다운로드 
//	 * @param filename
//	 * @return
//	 */
//	public Resource loadAsResource(String filename) {
//		try {
//			Path file = getPath().resolve(filename);
//			Resource resource = new UrlResource(file.toUri());
//			if (resource.exists() || resource.isReadable()) {
//				return resource;
//			}
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * 패스 객체 반환
//	 * @return
//	 */
//	private Path getPath() {
//		return Paths.get(fileUploadPath);
//	}
//}