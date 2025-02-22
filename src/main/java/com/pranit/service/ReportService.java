package com.pranit.service;

import java.util.List;

import com.pranit.entity.CitizenPlan;
import com.pranit.request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {
   
	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportPdf(HttpServletResponse response) throws Exception;
	
	public boolean exportExcle(HttpServletResponse response) throws Exception;
	
}
