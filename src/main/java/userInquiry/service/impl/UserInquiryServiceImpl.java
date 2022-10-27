package userInquiry.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import common.JDBCTemplate;
import userInquiry.dao.face.UserInquiryDao;
import userInquiry.dao.impl.UserInquiryDaoImpl;
import userInquiry.dto.UserInquiry;
import userInquiry.dto.UserInquiryFile;
import userInquiry.service.face.UserInquiryService;

public class UserInquiryServiceImpl implements UserInquiryService {
	
	// DAO 객체
	private UserInquiryDao userInquiryDao = new UserInquiryDaoImpl();

	@Override
	public void write(HttpServletRequest req) {

		// multipart/form-data 인코딩 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		// multipart형식이 아닐 경우 처리 중단
		if(!isMultipart) {
			System.out.println("[ERROR] 파일 업로드 형식 데이터가 아님");
			return;
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//메모리 처리 사이즈 설정
		int maxMem = 1 * 1024 * 1024;	// 1 MB == 1048576 B
		factory.setSizeThreshold(maxMem);

		//서블릿 컨텍스트 객체
		ServletContext context = req.getServletContext();
		
		//임시 파일 저장 폴더
		String path = context.getRealPath("tmp");
		File tmpRepository = new File(path);
		tmpRepository.mkdir();
		factory.setRepository(tmpRepository);

		//파일 업로드 수행 객체
		ServletFileUpload upload = new ServletFileUpload(factory);
				
		//파일 업로드 용량 제한
		int maxFile = 10 * 1024 * 1024; // 10MB
		upload.setFileSizeMax(maxFile);

		//파일 업로드된 데이터 파싱
		List<FileItem> items = null;
		
//		try {
//			items = upload.parseRequest(req);
//		} catch (FileUploadException e) {
//			e.printStackTrace();
//		}
		
		// 신고글 정보 DTO 객체
		UserInquiry userInquiry = new UserInquiry();
		
		// 신고글 첨부파일 정보 DTO객체
		UserInquiryFile userInquiryFile = new UserInquiryFile();
		
		// 파일아이템 반복자
		Iterator<FileItem> iter = items.iterator();
		
		while(iter.hasNext()) {
			FileItem item = iter.next();
			
			if(item.getSize() <= 0) {
				continue;
			}
			
			if(item.isFormField()) {
				String key = item.getFieldName();
				
				String value = null;
				try {
					value = item.getString("UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				if("report_content".equals(key) ) {
					userInquiry.setReportContent(value);
				}
			}
			
			if(!item.isFormField()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
				String rename = sdf.format(new Date());
				
				File uploadFolder = new File(context.getRealPath("upload"));
				uploadFolder.mkdir();
				
				File up = new File(uploadFolder, rename);
				try {
					item.write(up);
					item.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				userInquiryFile.setOriginname(item.getName());
				userInquiryFile.setStoredname(rename);
				userInquiryFile.setFilesize((int)item.getSize());
			} 
		}
	
		Connection conn = JDBCTemplate.getConnection();
		
		int boardno = userInquiryDao.selectNextBoardno(conn);
		
		userInquiry.setReporter((String)req.getSession().getAttribute("reporter"));
		
		if(userInquiryDao.insert(conn, userInquiry) > 0) {
			JDBCTemplate.commit(conn);;
		} else {
			JDBCTemplate.rollback(conn);;
		}
		
		if(userInquiryFile.getFilesize() != 0) {
			
			userInquiryFile.setBoardno(userInquiry.getBoardNo());
			
			if(userInquiryDao.insertFile(conn, userInquiryFile) > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		}

		
	}

}
