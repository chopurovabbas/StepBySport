cart = function () {


    scrollTo(0, 650);

    displayToNone();

    const loadProductsInCart = async () => {
        const username = sessionStorage.getItem('username')
        let response = await (await fetch(`http://localhost:8083/products?username=${username}`, {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
        }))
        let ch = await response.json();
        displayCart(ch);

        productExistInCart();

        /*alert(document.getElementById("cart-container").childNodes.length)*/
    };

    document.getElementById('card-container').style.display = "none";
    document.getElementById('cart').style.display = "block";

    const cartList = document.getElementById('cart-container');
    const displayCart = (characters) => {
        cartList.innerHTML = characters
            .map((character) => {
                let image = character.imageUrl[0]
                let productName = `${character.name}`
                let productId = `${character.id}`
                return `<div class="card-new" onclick="productInCart('${productName}',${productId},character.childElementCount)">
            <img src="${image}" alt="${character.name}" style="width:250px; height: 300px">
            <h1 class="nike-sneaker">${character.name}</h1>
            <p class="price">$${character.price}</p>
        </div>`;
            })
            .join('');
    }
    loadProductsInCart();

}

const addToCart = function (productName) {

    if (document.getElementById("sign-box").style.display === "none") {
        const loadCart = async () => {
            let response = await (await fetch('http://localhost:8083/products', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    "username": sessionStorage.getItem('username'),
                    "productName": productName,
                }),
            })).json();
        }
        loadCart();
    } else {
        document.getElementById('bg_signin').hidden = false
    }
};

let displayToNone = function () {
    document.getElementById("news-1").style.display = "none";
    document.getElementById("news-2").style.display = 'none';
    document.getElementById("product-1").style.display = 'none';
    document.getElementById("product-2").style.display = 'none';
    document.getElementById("product-3").style.display = 'none';
    document.getElementById("product").style.display = 'none';
    document.getElementById("carousel").style.display = "none";
}

let productExistInCart = function (){
    let doc = document.querySelectorAll(".cart-container .card-new")
    if (doc.length === 0) {
        document.getElementById("notFound-2").style.display = "block";
        document.getElementById("cart-container").style.display = "none"
    } else {
        document.getElementById("notFound-2").style.display = "none";
        document.getElementById("cart-container").style.display = "grid"
    }
}

