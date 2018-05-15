package dev.top.entities;

public enum ActionEnum {
	AIMER("AIMER"), DETESTER("DETESTER");
	private String action;

	private ActionEnum(String action) {
		this.action = action;
	}

	public String getActionEnum() {
		return action;
	}

	public void setActionEnum(String action) {
		this.action = action;
	}
}
