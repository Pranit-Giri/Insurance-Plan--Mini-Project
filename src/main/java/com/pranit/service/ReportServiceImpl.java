package com.pranit.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.pranit.entity.CitizenPlan;
import com.pranit.repo.CitizenPlanRepository;
import com.pranit.request.SearchRequest;
import com.pranit.util.EmailUtils;
import com.pranit.util.ExcleGenerator;
import com.pranit.util.PdfGenerator;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository planRepo;

	@Autowired
	private ExcleGenerator excleGenerator;

	@Autowired
	private PdfGenerator pdfGenrator;

	@Autowired
	private EmailUtils emailUtils;

	@Override
	public List<String> getPlanNames() {

		return planRepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {

		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();

		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}

		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}

		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}

		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			LocalDate localDate = LocalDate.parse(startDate, formatter);
			entity.setPlanStartDate(localDate);

		}

		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String endDate = request.getEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			LocalDate localDate = LocalDate.parse(endDate, formatter);
			entity.setPlanEndDate(localDate);

		}

		return planRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {

		File f = new File("Plans.pdf");

		List<CitizenPlan> plans = planRepo.findAll();
		pdfGenrator.generate(response, plans, f);
		
		String subject = "Test mail subject";
		String body = "<h1>Test Mail Body</h1>";
		String to = "pranitgiri161298@gmail.com";
		emailUtils.sendMail(subject, body, to, f);

		f.delete();

		return true;
	}

	@Override
	public boolean exportExcle(HttpServletResponse response) throws Exception {

		File f = new File("Plans.xls");

		List<CitizenPlan> plans = planRepo.findAll();
		excleGenerator.generate(response, plans, f);

		String subject = "Test mail subject";
		String body = "<h1>Test Mail Body</h1>";
		String to = "pranitgiri161298@gmail.com";
		emailUtils.sendMail(subject, body, to, f);

		f.delete();

		return true;
	}

}
