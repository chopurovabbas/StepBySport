productBlock = function () {
    document.getElementById("news-1").style.display = "none";
    document.getElementById("news-2").style.display = 'none';
    document.getElementById("carousel").style.display = "none";
    document.getElementById('card-container').style.display = "none";
    document.getElementById('cart').style.display = "none";
    scrollTo(0, 650);
}

nikeCard = function () {
    productBlock();
    document.getElementById("product").style.display = 'none';
    document.getElementById("product-2").style.display = 'none';
    document.getElementById("product-3").style.display = 'none';
    document.getElementById("product-1").style.display = 'block';
    scrollTo(0, 650);
}

adidasCard = function () {
    productBlock();
    document.getElementById("product").style.display = 'none';
    document.getElementById("product-1").style.display = 'none';
    document.getElementById("product-3").style.display = 'none';
    document.getElementById("product-2").style.display = 'block';
    scrollTo(0, 650);
}

pumaCard = function () {
    productBlock();
    document.getElementById("product").style.display = 'none';
    document.getElementById("product-1").style.display = 'none';
    document.getElementById("product-2").style.display = 'none';
    document.getElementById("product-3").style.display = 'block';
    scrollTo(0, 650);
}

storeCard = function () {
    productBlock();
    document.getElementById("product").style.display = 'block';
    document.getElementById("product-1").style.display = 'none';
    document.getElementById("product-3").style.display = 'none';
    document.getElementById("product-2").style.display = 'none';
    document.getElementById("container").style.display = 'grid';
    document.getElementById("notFound").style.display = 'none';
    let searchItems = document.querySelectorAll('.container .card-new');
    searchItems.forEach(function (elem) {
        elem.classList.remove('hide');
    })
    scrollTo(0, 650);
}

home = function () {
    document.getElementById('news-1').style.display = "block";
    document.getElementById('news-2').style.display = "block";
    document.getElementById('product-1').style.display = "none";
    document.getElementById('product-3').style.display = "none";
    document.getElementById('product').style.display = "none";
    document.getElementById('product-2').style.display = "none";
    document.getElementById("carousel").style.display = "flex";
    document.getElementById('card-container').style.display = "none";
    document.getElementById('cart').style.display = "none";
    scrollTo(0, 0);
}

let product = (characterName, id, length) => {
    displayToNone();
    document.getElementById('card-container').style.display = "flex";
    document.getElementById('cart').style.display = "none";

    for (let i = 1; i < length + 1; i++) {
        if (i === id) {
            document.getElementById(`card-${i}`).style.display = "flex";
            document.getElementById(`foot-${i}`).innerText = "Add To Card"
        }
        if (i !== id) {
            document.getElementById(`card-${i}`).style.display = "none";

        }
    }
}

let productInCart = (characterName, id, length) => {

    displayToNone();
    document.getElementById('card-container').style.display = "flex";
    document.getElementById('cart').style.display = "none";

    for (let i = 1; i < length + 1; i++) {
        if (i === id) {
            document.getElementById(`card-${i}`).style.display = "flex";
            document.getElementById(`foot-${i}`).innerText = "Delete From Cart";
            document.getElementById(`foot-${i}`).style.margin = "40% 0px 0px 0px";
            document.getElementById(`foot-${i}`).onclick = function () {
                const deleteCart = async () => {
                    let response = await (await fetch('http://localhost:8083/products', {
                        method: 'DELETE',
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json',
                        },
                        body: JSON.stringify({
                            "username": sessionStorage.getItem('username'),
                            "productName": characterName,
                        }),
                    })).json();
                }
                cart();
                cart();
                deleteCart();
            };
        }
        if (i !== id) {
            document.getElementById(`card-${i}`).style.display = "none";

        }
    }
}

