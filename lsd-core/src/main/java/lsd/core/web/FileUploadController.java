package lsd.core.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lsd.common.dto.json.FailedResponse;
import lsd.common.dto.json.ObjectResponse;
import lsd.common.dto.json.Response;
import lsd.core.dto.FileUploadDTO;

/***
 * 文件上传控制器
 * @author panchaoyang
 *
 */
@Controller
@RequestMapping("fileupload")
public class FileUploadController {
	
	 @Value("${spring.jsp.uploadpath}")
	 private String uploadpath;
	 
	 /***
	  * 被运行的文件类型
	  */
	 private List<String>  allowTypes = new ArrayList<String>(){
		private static final long serialVersionUID = -7478928976664848255L;
		{
			 add("png");
			 add("jpg");
			 add("jpeg");
			 add("gif");
			 add("bmp");
			 add("mp4");
			 add("mp3");
		 }
	 };
	 
	 
	 @RequestMapping(value="/upload", method=RequestMethod.POST)
	 @ResponseBody
	  public  Response handleFileUpload( @RequestParam("file") MultipartFile file,HttpServletRequest request) throws Exception, IOException{
	        if (!file.isEmpty()) {
	        	String filename =  file.getOriginalFilename();  
	        	String fileType = StringUtils.getFilenameExtension(filename);
	        	
	        	if(!allowTypes.contains(fileType.toLowerCase()))
	        		return new FailedResponse("不被允许的文件类型");
	        	
	        	String newfilename = System.currentTimeMillis()+"."+ StringUtils.getFilenameExtension(filename);
                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"+ newfilename;  
                file.transferTo(new File(filePath));  
                return new ObjectResponse<FileUploadDTO>(new FileUploadDTO(filename,newfilename));
	        }
	        else
	        	return new FailedResponse("上传失败");
	 }

}