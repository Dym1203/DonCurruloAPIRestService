package com.doncurrulo.app.service;

import org.springframework.core.io.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.doncurrulo.app.entity.DocumentoAlmacenado;
import com.doncurrulo.app.repository.DocumentoAlmacenadoRepository;
import com.doncurrulo.app.utilidades.GenericResponse;

import static com.doncurrulo.app.utilidades.Global.*;

import java.io.IOException;
import java.util.HashMap;

@Service
@Transactional
public class DocumentoAlmacenadoService
{
	private DocumentoAlmacenadoRepository repo;
	private FileStorageService storageService;
	
	public DocumentoAlmacenadoService(DocumentoAlmacenadoRepository repo, FileStorageService storageService)
	{
		this.repo = repo;
		this.storageService = storageService;
	}
	
	public GenericResponse<Iterable<DocumentoAlmacenado>> list()
	{
		return new GenericResponse<Iterable<DocumentoAlmacenado>>(TIPO_RESULT, RPTA_OK, OPERACION_CORRECTA,
				repo.list());
	}
	
	@SuppressWarnings("rawtypes")
	public GenericResponse find(Long aLong)
	{
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GenericResponse save(DocumentoAlmacenado obj)
	{
		String fileName = (repo.findById(obj.getId())).orElse(new DocumentoAlmacenado()).getFileName();
		
		String originalFilename = obj.getFile().getOriginalFilename();
		String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
		
		fileName = storageService.storeFile(obj.getFile(), fileName);
		
		obj.setFileName(fileName);
		obj.setExtension(extension);
		
		return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, repo.save(obj));
	}
	
	public ResponseEntity<Resource> download(String completefileName, HttpServletRequest request)
	{
		Resource resource = storageService.loadResource(completefileName);
		String contentType = null;
		
		try
		{
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		if (contentType == null)
		{
			contentType = "application/octet-stream";
		}
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
	
	public ResponseEntity<Resource> downloadByFileName(String fileName, HttpServletRequest request)
	{
		DocumentoAlmacenado doc = repo.findByFileName(fileName).orElse(new DocumentoAlmacenado());
		return download(doc.getCompleteFileName(), request);
	}
	
	@SuppressWarnings("rawtypes")
	public GenericResponse delete(Long aLong)
	{
		return null;
	}
	
	public HashMap<String, Object> validate(DocumentoAlmacenado obj)
	{
		return null;
	}
}