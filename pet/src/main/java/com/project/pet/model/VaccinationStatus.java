package com.project.pet.model;

public enum VaccinationStatus {
	
	APLICADO("APLICADO"),
	
	PENDENTE("PENDENTE");
	
	
	private String status;
	
		private VaccinationStatus(String status) {
			this.status=status;
		}
		
		public String getTipo() {
			return status;
		}
}