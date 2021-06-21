package com.anand.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;
import com.anand.dto.AccountDto;
import com.anand.service.AccountService;

@SuppressWarnings("deprecation")
public class RegistrationController  extends SimpleFormController {
	private AccountService accountService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}


	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		AccountDto accountDto;
		
		accountDto = new AccountDto();


		
		
		String DOCUMENT_PATH = "G:/aa";

		try {
			MultipartFormDataRequest nreq;
			nreq = new MultipartFormDataRequest(request);


			accountDto.setFullName(nreq.getParameter("fullName"));

			accountDto.setEmail(nreq.getParameter("email"));

			accountDto.setPassword(nreq.getParameter("password"));

			accountDto.setPhone(nreq.getParameter("phone"));

			accountDto.setEducation(nreq.getParameter("education"));

			accountDto.setAddress(nreq.getParameter("address"));

			//(nreq.getParameter("picture"));
			
			
			// document upload
			UploadBean upb = new UploadBean();
			upb.setFolderstore(DOCUMENT_PATH);
			upb.setOverwrite(false);
			upb.store(nreq, "picture");

			Vector<?> history = upb.getHistory();
			ArrayList<String> fileName = new ArrayList<String>();
			for (int i = 0; i < history.size(); i++) {
				UploadParameters up = (UploadParameters) history.elementAt(i);
				fileName.add(up.getFilename());

			}
			long newFileName = System.nanoTime();
			String myOldFileArray = fileName.get(0).trim();

			String ext = myOldFileArray.substring(myOldFileArray
					.lastIndexOf('.'), myOldFileArray.length());

			File oldName = new File(DOCUMENT_PATH + "/" + fileName.get(0));
			File newName = new File(DOCUMENT_PATH + "/" + newFileName
					+ ext.trim());
			if (oldName.renameTo(newName)) {
				System.out.println("renamed");
				accountDto.setPicture(DOCUMENT_PATH + "/" + newFileName
						+ ext.trim());
				accountDto.setPictureExtensions(ext);
			} else {
				System.out.println("Error");
			}
			
			

		} catch (Exception e) {
			System.err.println(e);
		}

		

		return new ModelAndView("success-page", "resMsg", accountService.register(accountDto));
	}

}
