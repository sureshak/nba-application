package com.nba.sample.model;

public class RuleResponse {
	
	private String selectedUsecase;

	/**
	 * @return the selectedUsecase
	 */
	public String getSelectedUsecase() {
		return selectedUsecase;
	}

	/**
	 * @param selectedUsecase the selectedUsecase to set
	 */
	public void setSelectedUsecase(String selectedUsecase) {
		this.selectedUsecase = selectedUsecase;
	}

	@Override
	public String toString() {
		return "RuleResponse [selectedUsecase=" + selectedUsecase + "]";
	}
}
