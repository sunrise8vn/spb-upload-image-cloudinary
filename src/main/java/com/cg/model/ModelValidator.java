//package com.cg.model;
//
//import org.springframework.stereotype.Component;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validator;
//import javax.validation.executable.ExecutableValidator;
//import javax.validation.metadata.BeanDescriptor;
//import java.util.Set;
//
//
//@Component
//public class ModelValidator implements Validator {
//
//    public boolean supports(Class <?> clazz) {
//        return Model.class.isAssignableFrom(clazz);
//    }
//
//    public void validate(Object target, Errors errors) {
//        Model model = (Model) target;
//
//        CommonsMultipartFile[] commonsMultipartFiles = model.getFiles();
//
//        for (CommonsMultipartFile multipartFile: commonsMultipartFiles) {
//            if (multipartFile.getSize() == 0) {
//                errors.rejectValue("files", "The file is required");
//            }
//        }
//    }
//
//
//}