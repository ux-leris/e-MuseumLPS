var DOMUtils = DOMUtils || {
    addClass: function (object, className) {
        console.log('Adicionando a classe ' + className + ' para o elemento ' + object);
        object.className = object.className + " " + className;
    },
    removeClass: function (object, className) {
        console.log('Removendo a classe ' + className + ' do elemento ' + object);
        object.className = object.className.replace(className, "");
    },
    containClass: function (object, className) {
        console.log('Verificando se o elemento ' + object + ' possui a classe ' + className);
        return object.className.search(className) !== -1;
    }
};
