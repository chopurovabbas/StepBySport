let slideIndex = 1;

function showSlides(n) {
    let slides = document.getElementsByClassName("item");

    if (n > slides.length) {
        slideIndex = 1
    }
    if (n < 1) {
        slideIndex = slides.length
    }

    for (let slide of slides) {
        slide.style.display = "none";
    }
    slides[slideIndex - 1].style.display = "block";
}

function nextSlide() {
    showSlides(slideIndex += 1);
    if (slideIndex < 4) {
        setTimeout(nextSlide, 6000)
    } else if (slideIndex === 4) {
        slideIndex = 0;
        setTimeout(nextSlide, 6000)
    }
}

function currentSlide(n) {
    showSlides(n)
    setTimeout(nextSlide, 6000)
}

currentSlide(slideIndex);

/*
let slideIndexSecond = 1;

function showSlidesSecond(n) {
    let slidesSecond = document.getElementsByClassName("item-2");

    if (n > slidesSecond.length) {
        slideIndexSecond = 1
    }
    if (n < 1) {
        slideIndexSecond = slidesSecond.length
    }

    for (let slide of slidesSecond) {
        slide.style.display = "none";
    }
    slidesSecond[slideIndexSecond - 1].style.display = "block";
}

function nextSlideSecond() {
    showSlidesSecond(slideIndexSecond += 1);
    setTimeout(previousSlideSecond,10000)
}

function previousSlideSecond() {
    showSlidesSecond(slideIndexSecond -= 1);
    setTimeout(nextSlideSecond,10000)
}

function currentSlideSecond(n) {
    showSlidesSecond(n)
    setTimeout(nextSlideSecond,10000)
}

currentSlideSecond(slideIndexSecond);*/
