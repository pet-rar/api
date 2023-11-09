package com.project.pet.model;

public enum AnimalPorte {
	 PEQUENO("PEQUENO"),
	 MEDIO("MÉDIO"),
	 GRANDE("GRANDE");
	
	  private String porte;

	  private AnimalPorte(String porte) {
	     this.porte = porte;
	  }

	  public String getPorte() {
	      return porte;
	   }
	
}
