package com.pranit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pranit.entity.CitizenPlan;
import com.pranit.request.SearchRequest;
import com.pranit.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class Reportcontroller {
	@Autowired
	private ReportService service;

	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		response.setContentType("appliction/pdf");
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
		service.exportPdf(response);
	}
	
	@GetMapping("/excle")
	public void excleExport(HttpServletResponse response) throws Exception {
		response.setContentType("appliction/octet-stream");

		response.addHeader("Content-Disposition", "attachment;filename=plans.xls");

		service.exportExcle(response);
	}

	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("search", new SearchRequest());
		init(model);
		return "index";
	}

	private void init(Model model) {

		model.addAttribute("names", service.getPlanNames());
		model.addAttribute("status", service.getPlanStatus());
	}

	@PostMapping("/search")
	public String handelSearch(@ModelAttribute("search") SearchRequest search, Model model) {
		System.out.println(search);
		List<CitizenPlan> plans = service.search(search);
		model.addAttribute("plans", plans);

		init(model);
		return "index";
	}

}
