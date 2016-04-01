var MUVI = MUVI || {
	menu: function (event) {
		console.log('MUVI.menu');

		var target = event.target || event.srcElement;
		var type = event.type;

		var openCloseDiv = document.getElementById('openclose-div');
		var modalDiv = document.getElementById('modal-div');
		var menuBtn = document.getElementById('menu-btn');
		var menuSection = document.getElementById('menu-section');

		if (!DOMUtils.containClass(menuBtn, "opened") && ((type === 'click' && target.id === 'menu-btn')/* || verificar se foi um touchmove */)) {
			console.log('Abrindo o menu');
			DOMUtils.addClass(openCloseDiv, "opened");
			DOMUtils.addClass(menuBtn, "opened");
			//DOMUtils.removeClass(modalDiv, "hide-transition");
			DOMUtils.addClass(modalDiv, "show-transition");
			//DOMUtils.removeClass(menuSection, "hide-transition");
			DOMUtils.addClass(menuSection, "show-transition");
			//DOMUtils.removeClass(menuSection.children[0], "hide-transition");
			DOMUtils.addClass(menuSection.children[0], "show-transition");
			//DOMUtils.removeClass(menuSection.children[1], "hide-transition");
			DOMUtils.addClass(menuSection.children[1], "show-transition");
			//DOMUtils.removeClass(menuSection.children[2], "hide-transition");
			DOMUtils.addClass(menuSection.children[2], "show-transition");
		} else {
			console.log('Fechando o menu');
			DOMUtils.removeClass(openCloseDiv, "opened");
			DOMUtils.removeClass(menuBtn, "opened");
			DOMUtils.removeClass(modalDiv, "show-transition");
			//DOMUtils.addClass(modalDiv, "hide-transition");
			DOMUtils.removeClass(menuSection, "show-transition");
			//DOMUtils.addClass(menuSection, "hide-transition");
			DOMUtils.removeClass(menuSection.children[0], "show-transition");
			//DOMUtils.addClass(menuSection.children[0], "hide-transition");
			DOMUtils.removeClass(menuSection.children[1], "show-transition");
			//DOMUtils.addClass(menuSection.children[1], "hide-transition");
			DOMUtils.removeClass(menuSection.children[2], "show-transition");
			//DOMUtils.addClass(menuSection.children[2], "hide-transition");
		}
	},
	keyboard: function (left, right) {
		document.addEventListener("keypress", function (event) {
			if (!DOMUtils.containClass(document.getElementById('menu-btn'), "opened"))
				switch (event.keyCode) {
					case 37: // left
						left();
						break;
					case 39: // right
						right();
						break;
				}
			else
			if (event.keyCode == 27 && DOMUtils.containClass(document.getElementById('menu-btn'), 'opened'))
				document.getElementById('modal-div').click();
		});
	},
	cenariosMenu: function (event) {
		console.log('cenariosMenu');
		
		var target = event.target || event.srcElement;
		var lis = document.getElementsByClassName('menu-li');
		var lilis = document.getElementsByClassName('menu-lili');

		for (i = 0; i < lis.length; i++) {
			if (lis[i] === target) {
				if (DOMUtils.containClass(lis[i], "opened")) {
					DOMUtils.removeClass(lis[i], "opened");
					DOMUtils.removeClass(lilis[i], "show");
				} else {
					DOMUtils.addClass(lis[i], "opened");
					DOMUtils.addClass(lilis[i], "show");
				}
			} else if (DOMUtils.containClass(lis[i], "opened")) {
				DOMUtils.removeClass(lis[i], "opened");
				DOMUtils.removeClass(lilis[i], "show");
			}
		}
	}

};
