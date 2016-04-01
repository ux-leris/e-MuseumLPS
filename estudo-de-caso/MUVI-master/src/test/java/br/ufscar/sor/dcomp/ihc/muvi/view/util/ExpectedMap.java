package br.ufscar.sor.dcomp.ihc.muvi.view.util;

import java.util.HashMap;

/**
 *
 * @author USER
 */
public class ExpectedMap extends HashMap<String, Object> {

	private static ExpectedMap instance = null;

	public static ExpectedMap get() {
		if (instance == null) {
			instance = new ExpectedMap();
		}

		return instance;
	}

	private ExpectedMap() {
		put("title", "MUVI - Home");
		put("museumname", "Lei de Diretrizes e Base");
		put("aclass", "button button-home");
		put("paleatory", "Aleatória");
		put("pguided", "Guiada");
		put("titlealeatory", "MUVI - Visita Aleatória");
		put("titleguided", "MUVI - Visita Guiada");
		put("buttonclass", "button");
		put("stateclass", "nav-sce-location");
		put("anavbutton", "nav-sce-btn");
		put("empty", "");
		put("hideclass", "hide");
		put("cancelbuttontext", "Cancelar");
		put("donebuttontext", "Verificar");
		put("buttondoneandcorrect", "button doneAndCorrect");
		put("buttondoneandwrong", "button doneAndWrong");
		put("notdonetext", "Finalizar");
		put("donetext", "Feito!");
	}

}
