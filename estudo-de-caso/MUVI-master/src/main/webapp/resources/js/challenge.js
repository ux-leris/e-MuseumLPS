(function () {
	
	var challengeClicked = function (event) {
		console.log('challenge click');

		DOMUtils.removeClass(document.getElementById('challenge-section'), "hide");

		var cancelButton = document.getElementById('challenge-cancel');
		if (DOMUtils.containClass(cancelButton, "disabled")) {
			DOMUtils.removeClass(cancelButton, "disabled");
			cancelButton.addEventListener("click", cancelListener);

			for (var i = 0; i < alternativesdiv.length; i++) {
				console.log('Adding event listener to alternative ' + i);
				alternativesdiv[i].addEventListener("click", alternativeClicked);
			}
		}
	};

	var challengeButton = document.getElementById('challenge');
	challengeButton.addEventListener("click", challengeClicked);

	var alternativeClicked = function (event) {
		var target = event.target || event.srcElement;
		console.log(target.tagName);
		if (target.tagName) {
			if (target.tagName === 'P') {
				target.parentElement.click();
				return;
			}
			console.log(target.tagName);
		} else {
			return;
		}

		for (var i = 0; i < alternativesdiv.length; i++) {
			if (DOMUtils.containClass(alternativesdiv[i], "wrong"))
				DOMUtils.removeClass(alternativesdiv[i], "wrong");

			if (alternativesdiv[i] === target)
				if (DOMUtils.containClass(target, "selected"))
					DOMUtils.removeClass(target, "selected");
				else
					DOMUtils.addClass(target, "selected");
			else if (DOMUtils.containClass(alternativesdiv[i], "selected"))
				DOMUtils.removeClass(alternativesdiv[i], "selected");
		}
	}
	;

	var alternativesdiv = document.getElementsByClassName('alternative');
	for (var i = 0; i < alternativesdiv.length; i++) {
		console.log('Adding event listener to alternative ' + i);
		alternativesdiv[i].addEventListener("click", alternativeClicked);
	}
	;

	var cancelListener = function cancelListener (event) {
		console.log('challenge cancelado!');

		DOMUtils.addClass(document.getElementById('challenge-section'), "hide");
		DOMUtils.addClass(document.getElementById('challenge').children[0], "doneAndWrong");
		
		for (var i = 0; i < alternativesdiv.length; i++) {
			if (DOMUtils.containClass(alternativesdiv[i], "wrong"))
				DOMUtils.removeClass(alternativesdiv[i], "wrong");
			else if (DOMUtils.containClass(alternativesdiv[i], "selected"))
				DOMUtils.removeClass(alternativesdiv[i], "selected");
		}
	};

	document.getElementById('challenge-cancel').addEventListener("click", cancelListener);

	document.getElementById('challenge-done').addEventListener("click", function (event) {
		console.log('Challenge done!');

		var target = (event.target || event.srcElement);
		var challengebutton = document.getElementById('challenge').children[0];
		if (DOMUtils.containClass(target, "verified")) {
			DOMUtils.addClass(document.getElementById('challenge-section'), "hide");

			for (var i = 0; i < alternativesdiv.length; i++) {
				console.log('Removing event listener to alternative ' + i);
				alternativesdiv[i].removeEventListener("click", alternativeClicked);
			}
			
			challengeButton.children[0].innerHTML = 'Feito!';
			challengeButton.removeEventListener("click", challengeClicked);
			challengeButton.style.cursor = 'inherit';
		} else {
			for (i = 0; i < alternativesdiv.length; i++) {
				if (DOMUtils.containClass(alternativesdiv[i], "wrong"))
					DOMUtils.removeClass(alternativesdiv[i], "wrong");
				if (DOMUtils.containClass(alternativesdiv[i], "selected")) {

					if (i == 0/*alternativesdiv[i].children[0].innerHTML === '${challenge.correctAnswer.description}'*/) {
						if (DOMUtils.containClass(alternativesdiv[i], "wrong"))
							DOMUtils.removeClass(alternativesdiv[i], "wrong")
						if (!DOMUtils.containClass(alternativesdiv[i], "correct"))
							DOMUtils.addClass(alternativesdiv[i], "correct");
						if (DOMUtils.containClass(challengebutton, "doneAndWrong"))
							DOMUtils.removeClass(challengebutton, "doneAndWrong");
						if (!DOMUtils.containClass(challengebutton, "doneAndCorrect"))
							DOMUtils.addClass(challengebutton, "doneAndCorrect");
						target.innerHTML = 'Finalizar';

						DOMUtils.addClass(document.getElementById('challenge-cancel'), "disabled");
						DOMUtils.addClass(target, "verified");
						document.getElementById('challenge-cancel').removeEventListener("click", cancelListener);
						for (var i = 0; i < alternativesdiv.length; i++) {
							console.log('Adding event listener to alternative ' + i);
							alternativesdiv[i].removeEventListener("click", alternativeClicked);
						}
					} else {
						/*
						if (DOMUtils.containClass(alternativesdiv[i], "correct"))
							DOMUtils.removeClass(alternativesdiv[i], "correct")
						*/
						if (!DOMUtils.containClass(alternativesdiv[i], "wrong"))
							DOMUtils.addClass(alternativesdiv[i], "wrong");
						/*
						if (DOMUtils.containClass(challengebutton, "doneAndCorrect"))
							DOMUtils.removeClass(challengebutton, "doneAndCorrect");
						
						if (!DOMUtils.containClass(challengebutton, "doneAndWrong"))
							DOMUtils.addClass(challengebutton, "doneAndWrong");
						*/
						//DOMUtils.removeClass(document.getElementById('challenge-cancel'), "disabled");
						/*
						document.getElementById('challenge-cancel').addEventListener(cancelListener);
						for (var i = 0; i < alternativesdiv.length; i++) {
							console.log('Adding event listener to alternative ' + i);
							alternativesdiv[i].addEventListener("click", alternativeClicked);
						}
						*/
					}
				} else if (DOMUtils.containClass(alternativesdiv[i], "wrong"))
					DOMUtils.removeClass(alternativesdiv[i], "wrong");
			}
		}
	});

	/*var currentItem = 1;
	 
	 var load = function (next) {
	 var xhr;
	 
	 try {
	 xhr = new XMLHttpRequest();
	 } catch (e) {
	 try {
	 xhr = new ActiveXObject("Microsoft.XMLHTTP");
	 } catch (e) {
	 alert("Desculpe, mas seu navegador e' suportado pelo museu. =(");
	 return;
	 }
	 }
	 
	 xhr.onreadystatechange = function () {
	 if (xhr.readyState === 4) {
	 var navigationItem = JSON.parse(xhr.responseText);
	 
	 console.log(navigationItem);
	 
	 document.getElementById('title').innerHtml = navigationItem.text.name;
	 document.getElementById('alternative1').children[0].innerHtml = navigationItem.text.text;
	 document.getElementById('alternative2').innerHtml = navigationItem.toknowmore.text;
	 document.getElementById('alternative3').src = navigationItem.image.urlAddress;
	 }
	 };
	 
	 if (next) {
	 xhr.open("POST", "/muvi/visita-guiada/proximo", false);
	 
	 currentItem++;
	 
	 var goto = document.getElementById('goto');
	 if (currentItem === numItems)
	 DOMUtils.addClass(goto, 'hide');
	 else if (DOMUtils.containClass(goto, 'hide'))
	 DOMUtils.removeClass(goto, 'hide');
	 } else {
	 xhr.open("POST", "/muvi/visita-guiada/anterior", false);
	 currentItem--;
	 
	 var backto = document.getElementById('backto');
	 if (currentItem === 1)
	 DOMUtils.addClass(backto, 'hide');
	 else if (DOMUtils.containClass(backto, 'hide'))
	 DOMUtils.removeClass(backto, 'hide');
	 }
	 
	 xhr.send();
	 
	 document.getElementById('state').innerHtml = currentItem + ' de ' + numItems;
	 };
	 
	 document.getElementById('next').addEventListener("click", function (event) {
	 console.log('next clicked');
	 });
	 
	 document.getElementById('back').addEventListener("click", function (event) {
	 console.log('back clicked');
	 });
	 
	 document.getElementById('cancel').addEventListener("click", function (event) {
	 console.log('cancel clicked');
	 });
	 
	 document.getElementById('finish').addEventListener("click", function (event) {
	 console.log('finish clicked');
	 });*/



})();