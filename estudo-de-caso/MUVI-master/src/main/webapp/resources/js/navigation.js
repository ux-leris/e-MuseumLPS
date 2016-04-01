(function () {
	var currentItem = 1;

	/*var load = function (next) {
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

				console.log('navigarionItem: ' + navigationItem);

				document.getElementById('title').innerHtml = navigationItem.text.name;
				document.getElementById('object-text').children[0].innerHtml = navigationItem.text.text;
				document.getElementById('divmore').innerHtml = navigationItem.toknowmore.text;
				document.getElementById('image').src = navigationItem.image.urlAddress;
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
			if (currentItem === 2 && DOMUtils.containClass(backto, 'hide'))
				DOMUtils.removeClass(backto, 'hide');
		} else {
			xhr.open("POST", "/muvi/visita-guiada/anterior", false);
			currentItem--;

			var backto = document.getElementById('backto');
			if (currentItem === 1)
				DOMUtils.addClass(backto, 'hide');
			else if (DOMUtils.containClass(backto, 'hide'))
				DOMUtils.removeClass(backto, 'hide');
			if (currentItem === (numItems - 1) && DOMUtils.containClass(goto, 'hide'))
				DOMUtils.removeClass(goto, 'hide');
		}

		xhr.send();
		console.log('done');

		document.getElementById('state').innerHtml = currentItem + ' de ' + numItems;
	};*/

	function shouldHideFooter(getingOutFrom) {
		var footer = document.getElementsByTagName('footer')[0];

		if (!DOMUtils.containClass(footer, "hide"))
			DOMUtils.addClass(footer, "hide")
	}

	document.getElementById('goto').addEventListener("click", function (event) {
		console.log('goto clicked');
		//load(true);
		document.getElementById('agoto').click();
	});

	document.getElementById('backto').addEventListener("click", function (event) {
		console.log('backto clicked');
		//load(false);
		document.getElementById('abackto').click();
	});

	document.getElementById('amore').addEventListener("click", function (event) {
		var a = event.target || event.srcElement;
		var aparentparent = a.parentNode.parentNode;
		var footer = aparentparent.children[2];
		if (DOMUtils.containClass(footer, "hide"))
			DOMUtils.removeClass(footer, "hide");
		else
			DOMUtils.addClass(footer, "hide");
	});

	//load(true);

})();