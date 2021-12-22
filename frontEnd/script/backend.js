const charactersNikeList = document.getElementById('container-nike');
const charactersAdidasList = document.getElementById('container-adidas');
const charactersPumaList = document.getElementById('container-puma');
const charactersAllList = document.getElementById('container');

const loadCharacters = async () => {
    const res = await fetch('http://localhost:8080/products');
    const hpCharacters = await res.json();
    displayNikeCharacters(hpCharacters);
    displayAdidasCharacters(hpCharacters);
    displayPumaCharacters(hpCharacters);
    displayCharacter(hpCharacters);
    displayAllCharacters(hpCharacters);
};

const displayAllCharacters = (characters) => {
    charactersAllList.innerHTML = characters
        .map((character) => {
            let image = character.imageUrl[0]
            let productName = `${character.name}`
            let productId = `${character.id}`
            return `<div class="card-new" onclick="product('${productName}',${productId},character.childElementCount)">
            <img src="${image}" alt="${character.name}" style="width:250px; height: 300px">
            <h1 class="nike-sneaker">${character.name}</h1>
            <p class="price">$${character.price}</p>
        </div>`;
        })
        .join('');
}


const displayNikeCharacters = (characters) => {
    charactersNikeList.innerHTML = characters
        .map((character) => {
            let model = `${character.model}`
            let image = character.imageUrl[0]
            if (model === "Nike") {

                let productName = `${character.name}`
                let productId = `${character.id}`

                return `<div class="card-new" onclick="product('${productName}',${productId},character.childElementCount)">
            <img src="${image}" alt="${character.name}" style="width:250px; height: 300px">
            <h1 class="nike-sneaker">${character.name}</h1>
            <p class="price">$${character.price}</p>
        </div>`;
            }
        })
        .join('');
}

const displayAdidasCharacters = (characters) => {
    charactersAdidasList.innerHTML = characters
        .map((character) => {
            let image = character.imageUrl[0]
            let model = `${character.model}`
            if (model === "Adidas") {
                let productName = `${character.name}`
                let productId = `${character.id}`

                return `<div class="card-new" onclick="product('${productName}',${productId},character.childElementCount)">
            <img src="${image}" alt="${character.name}" style="width:250px; height: 300px">
            <h1 class="nike-sneaker">${character.name}</h1>
            <p class="price">$${character.price}</p>
        </div>`;
            }
        })
        .join('');
}

const displayPumaCharacters = (characters) => {
    charactersPumaList.innerHTML = characters
        .map((character) => {
            let model = `${character.model}`
            let image = character.imageUrl[0]

            if (model === "Puma") {
                let productName = `${character.name}`
                let productId = `${character.id}`

                return `<div class="card-new" onclick="product('${productName}',${productId},character.childElementCount)">
            <img src="${image}" alt="${character.name}" style="width:250px; height: 300px">
            <h1 class="nike-sneaker">${character.name}</h1>
            <p class="price">$${character.price}</p>
        </div>`;
            }
        })
        .join('');
}

const character = document.getElementById('card-container');

const displayCharacter = (characters) => {
    character.innerHTML = characters
        .map((character) => {

            let productId = `${character.id}`
            let image1 = character.imageUrl[0]
            let image2 = character.imageUrl[1]
            let image3 = character.imageUrl[2]
            let image4 = character.imageUrl[3]


            return `<div class="card-section" id="card-${productId}" style="display: none">
             
             <div class="image-container">
             <img src="${image1}" style="height: 80px; width: 80px;cursor: pointer;transition: 200ms" onclick="image('${image1}',${character.id})">
              <img src="${image2}" 
              style="height: 80px; width: 80px;cursor: pointer;transition: 200ms" onclick="image('${image2}',${character.id})">
              <img src="${image3}" 
              style="height: 80px; width: 80px;cursor: pointer;transition: 200ms" onclick="image('${image3}',${character.id})">
              <img src="${image4}"
               style="height: 80px; width: 80px;cursor: pointer;transition: 200ms" onclick="image('${image4}',${character.id})">
              </div>
             <div class="card">
             <div class="left">
                <img src="${image1}" alt="shoe" id="main-image-${character.id}">
                <i class="fa fa-long-arrow-left"></i>
                <i class="fa fa-long-arrow-right"></i>
            </div>
            <div class="right">
                <div class="product-info">
        <div class="product-name">
                <h1>${character.name}</h1>
            <i class="fa fa-search"></i>
            <i class="fa fa-user"></i>
            <i class="fa fa-shopping-cart"></i>
        </div>
            <div class="details" style="height: 75px">
                <h3>${character.collection} Collection</h3>
                <h4><span class="fa fa-dollar"></span>Price: ${character.price}$</h4>
            </div>
            <ul>
                <li class="size-list" style="font-size: 19px;margin-top: 120px">Size: ${character.size}</li>
            </ul>
            <span class="foot"><i class="fa fa-shopping-bag"></i>Buy Now</span>
            <span class="foot" id="foot-${character.id}" onclick="addToCart('${character.name}')"><i class="fa fa-shopping-cart"></i>Add to Cart</span>
            </div></div></div></div>`;
        })
        .join('');

};

loadCharacters();

let image = function (url,id){
    document.getElementById(`main-image-${id}`).src = url;
}
