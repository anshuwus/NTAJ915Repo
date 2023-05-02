package com.nt.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.MarriageSeeker;
import com.nt.service.IMatrimonyServiceMgmt;

@Component
public class LOBsTestRunner implements CommandLineRunner {

	@Autowired
	private IMatrimonyServiceMgmt service;
	
	@Override
	public void run(String... args) throws Exception {
		/*		Scanner scn=new Scanner(System.in);
				System.out.println("Enter person name:: ");
				String name=scn.nextLine();
				System.out.println("Enter person address:: ");
				String addrs=scn.nextLine();
				System.out.println("Enter person Photo file complete path:: ");
				String photoPath=scn.nextLine().replace("?","");
				//‪D:\\HTML\\img\\deepika.jpg
				System.out.println("Enter person biodata file complete path:: ");
				String biodataPath=scn.nextLine().replace("?", "");  
				//‪D:\\HTML\\img\\cfg.txt
				System.out.println("Is the person Indian? ");
				boolean indian=scn.nextBoolean();scn.nextLine();
				//prepare byte[] representing photo file content
				System.out.println("================");
				System.out.println(photoPath);
				System.out.println(biodataPath);
				System.out.println("================");
				InputStream is=new FileInputStream(photoPath);
				byte[] photoData=new byte[is.available()];
				photoData=is.readAllBytes();
				
				//prepare char[] representing biodata file content
				File file=new File(biodataPath);
				Reader reader=new FileReader(file);
				char bioDataContent[]=new char[(int)file.length()];
				reader.read(bioDataContent);
				
				//prepare Entity class object
				MarriageSeeker seeker=new MarriageSeeker(name,addrs,photoData,bioDataContent,LocalDateTime.of(2000, 04,23,12,45),indian);
				System.out.println(service.registerMarriageSeeker(seeker));
				*/System.out.println("==================================================");
		
		Optional<MarriageSeeker> opt=service.searchSeekerById(152L);
		if(opt.isPresent()) {
			MarriageSeeker seeker1=opt.get();
			System.out.println(seeker1.getId()+"     "+seeker1.getAddrs()+"     "+seeker1.isIndian());
			OutputStream os=new FileOutputStream("deepika.jpg");
			os.write(seeker1.getPhoto());
			os.flush();
			Writer writer=new FileWriter("cfg.txt");
			writer.write(seeker1.getBiodata());
			writer.flush();
			os.close();
			writer.close();
			System.out.println("LOBs are retrieved");
		}
		else {
			System.out.println("Records are not found");
		}
	}

}
