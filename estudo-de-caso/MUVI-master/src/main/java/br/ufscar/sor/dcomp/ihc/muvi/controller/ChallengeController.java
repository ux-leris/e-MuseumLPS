package br.ufscar.sor.dcomp.ihc.muvi.controller;

import com.lpsmuseum.dto.scenario.Answer;
import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.service.ChallengeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author USER
 */
@Controller
public class ChallengeController {
	
	Challenge challenge;
	final ChallengeService service;

	public ChallengeController() {
		this.service = new ChallengeService();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "challenge",
			method = RequestMethod.HEAD,
			produces = "application/json")
	public void init(@RequestParam Long challenge, @RequestParam(required = false) Long correct) throws Exception {
		this.challenge = service.findById(challenge);
		
		if (correct != null && this.challenge.getCorrectAnswer() == null) {
			for (Answer answer : this.challenge.getAnswers()) {
				System.out.println(answer.getId() + "|" + correct);
				if (answer.getId().equals(correct)) {
					this.challenge.setCorrectAnswer(answer);
					break;
				}
			}
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "challenge/verify", method = RequestMethod.PUT)
	public Boolean verify(@RequestParam Long answer) {
		return challenge.getCorrectAnswer().getId().equals(answer);
	}

	public Challenge getChallenge() {
		return challenge;
	}
	
}
