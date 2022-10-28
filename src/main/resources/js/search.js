var searchBox = document.querySelector(".search-box__input__text-field");
var resultsElement = document.querySelector('.search-box__results');
var timeoutId = -1;
function searchSongs(query) {
    fetch("/search/".concat(query)).then(function (response) {
        return response.json();
    }).then(function (data) {
        console.log(data);
        displayResults(data);
    }).catch(function (error) {
        console.log(error);
    });
}
function displayResults(results) {
    resultsElement.innerHTML = '';
    results.forEach(function (result) {
        var splitterElement = document.createElement('div');
        splitterElement.classList.add('search-box-splitter');
        var resultElement = document.createElement('div');
        resultElement.classList.add('search-result');
        var image = document.createElement('img');
        image.classList.add('search-result__image');
        image.src = result['image_url'];
        var songInfoDivElement = document.createElement('div');
        songInfoDivElement.classList.add('search-result__artist-info');
        var songNameElement = document.createElement('span');
        songNameElement.classList.add('search-result__artist-info__song');
        songNameElement.innerHTML = result['title'];
        var artistNameElement = document.createElement('span');
        artistNameElement.classList.add('search-result__artist-info__name');
        artistNameElement.innerHTML = result['artist'];
        songInfoDivElement.append(songNameElement);
        songInfoDivElement.append(artistNameElement);
        resultElement.append(image);
        resultElement.append(songInfoDivElement);
        resultsElement.append(splitterElement);
        resultsElement.append(resultElement);
    });
}
searchBox.addEventListener('input', function (evt) {
    if (timeoutId !== -1)
        clearTimeout(timeoutId);
    timeoutId = setTimeout(function () {
        searchSongs(searchBox.value);
    }, 0);
    console.log(evt.currentTarget);
});
