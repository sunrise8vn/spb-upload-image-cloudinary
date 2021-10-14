package com.cg.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface UploadService {
    Map upload(MultipartFile multipartFile, Map params) throws IOException;

    Map destroy(String publicId, Map params) throws IOException;
}
