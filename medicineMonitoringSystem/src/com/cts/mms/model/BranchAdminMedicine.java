package com.cts.mms.model;

public class BranchAdminMedicine {
      private String branchName;
      private String medicineName;
      private int medicineId;
      private String medicineUsage;
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineUsage() {
		return medicineUsage;
	}
	public void setMedicineUsage(String medicineUsage) {
		this.medicineUsage = medicineUsage;
	}
	@Override
	public String toString() {
		return "BranchAdminMedicine [branchName=" + branchName + ", medicineName=" + medicineName + ", medicineId="
				+ medicineId + ", medicineUsage=" + medicineUsage + "]";
	}
      
}
