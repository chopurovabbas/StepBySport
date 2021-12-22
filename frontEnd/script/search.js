let notFound = true

let searchProductFirst = function () {
    notFound = true
    storeCard()
    let searchInput = document.getElementById("search")
    let val = searchInput.value.trim().toLowerCase();
    let searchItems = document.querySelectorAll('.container .card-new');
    if (val !== '') {
        searchItems.forEach(function (elem) {
            if (elem.innerText.toLowerCase().search(val) === -1) {
                elem.classList.add('hide')
            } else {
                notFound = false
                elem.classList.remove('hide');
            }
        });
    } else {
        searchItems.forEach(function (elem) {
            notFound = false
            elem.classList.remove('hide');
        })
    }

    if (notFound === true) {
        document.getElementById("notFound").style.display = "block"
        document.getElementById("container").style.display = "none"
    }else{
        document.getElementById("notFound").style.display = "none"
        document.getElementById("container").style.display = "grid"
    }

}

const searchInput = document.getElementById('search');
searchInput.addEventListener('keyup', (e) => {
    const searchString = e.target.value.toLowerCase();
    let searchItems = document.querySelectorAll('.container .card-new');
    if (searchString === '') {
        searchItems.forEach(function (elem) {
            document.getElementById("notFound").style.display = "none"
            document.getElementById("container").style.display = "grid"
            elem.classList.remove('hide');
        })
    }
});



