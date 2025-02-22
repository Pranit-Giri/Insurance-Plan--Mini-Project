package com.pranit.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CITIZEN_ PLANS_INFO")
public class CitizenPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citizenId;
	private String citizenName;
	private String gender;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private Integer benifitAmount;
	private String denielReason;
	private LocalDate teminationDate;
	private String terminationReson;

	public Integer getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(Integer citizenId) {
		this.citizenId = citizenId;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public LocalDate getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	public Integer getBenifitAmount() {
		return benifitAmount;
	}

	public void setBenifitAmount(Integer benifitAmount) {
		this.benifitAmount = benifitAmount;
	}

	public String getDenielReason() {
		return denielReason;
	}

	public void setDenielReason(String denielReason) {
		this.denielReason = denielReason;
	}

	public LocalDate getTeminationDate() {
		return teminationDate;
	}

	public void setTeminationDate(LocalDate teminationDate) {
		this.teminationDate = teminationDate;
	}

	public String getTerminationReson() {
		return terminationReson;
	}

	public void setTerminationReson(String terminationReson) {
		this.terminationReson = terminationReson;
	}

}
