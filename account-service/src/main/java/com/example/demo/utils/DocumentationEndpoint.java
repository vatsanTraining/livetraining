package com.example.demo.utils;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

@Component
@WebEndpoint(id = "docs")
public class DocumentationEndpoint {

	
	String versionInfo = new StringBuffer().append("Account Service").append("\n").append("Version 1.0").toString();

	@ReadOperation
	public String releaseInfo() {
	   return versionInfo;
	  }

	
	@WriteOperation
	public String updateInfo(@Selector String author) {
	   this.versionInfo = this.versionInfo.concat(author);
	   return this.versionInfo;
	  }

	
}
