package dev.top.service;

import org.springframework.stereotype.Service;

import dev.top.entities.ActionEnum;
import dev.top.entities.ActionIhm;
import dev.top.entities.Collegue;

@Service
public class ActionService {

	public Collegue modifScore(Collegue collegue, ActionIhm action) {
		if (action.getAction().equals(ActionEnum.AIMER)) {
			collegue.setScore(collegue.getScore() + 10);
		} else if (action.getAction().equals(ActionEnum.DETESTER)) {
			collegue.setScore(collegue.getScore() - 5);
		} else {
			collegue.setScore(collegue.getScore());
		}
		return collegue;
	}

}
