package com.mrk.htd.jsf.util;

import java.io.File;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 * 
 * @author mkiswani
 * 
 */
public class JsfUtil {

	public static void showError(String string) {
		System.out.println("================>Error Msg to View <===============================");
		System.out.println(string);
		FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage(FacesMessage.SEVERITY_FATAL, string, null));
	}

	public static void showSucess(String string) {
		FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage(FacesMessage.SEVERITY_INFO, string, null));
	}

	public static File getImage(String imageName) {
		String folderName = "/images";
		File externalFolder = getExternalFolder(folderName);
		File f = new File(externalFolder, imageName);
		return f;
	}

	public static File getExternalFolder(String folderName) {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String realPath = servletContext.getRealPath(folderName);
		return new File(realPath);
	}

}