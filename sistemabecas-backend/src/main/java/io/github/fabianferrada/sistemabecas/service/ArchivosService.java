package io.github.fabianferrada.sistemabecas.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArchivosService {
	private Path uploadDir;
	
	public ArchivosService(@Value("${file.upload-dir}") String uploadDir) {
		this.uploadDir = Paths.get(uploadDir).toAbsolutePath().normalize();
		
		try {
			Files.createDirectories(this.uploadDir);
		} catch (Exception e) {
			throw new RuntimeException("Error creating uploads directory");
		}
	}
	
	public String saveFile(MultipartFile file) {
		String filename = file.getOriginalFilename();
		
		Path targetLocation = this.uploadDir.resolve(filename);
		
		try {
			Files.copy(
				file.getInputStream(),
				targetLocation,
				StandardCopyOption.REPLACE_EXISTING
			);
		} catch (Exception e) {
			throw new RuntimeException("Error creating file in disk");
		}
		
		return filename;
	}
	
	public Resource getFile(String fileDir) {
		try {
			Path filePath = Paths.get(fileDir).toAbsolutePath().normalize();
			Resource fileResource = new UrlResource(filePath.toUri());
			
			if (fileResource.exists() && fileResource.isReadable()) {
				return fileResource;
			} else {
				throw new RuntimeException("Error obtaining the file");
			}
		} catch (Exception e) {
			throw new RuntimeException("Error obtaining the file");
		}
	}
	
	public void deleteFile(String fileDir) {
		try {
			Files.deleteIfExists(Paths.get(fileDir).toAbsolutePath().normalize());
		} catch (Exception e) {
			throw new RuntimeException("Error while deleting the file");
		}
	}
}