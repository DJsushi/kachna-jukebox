const searchBox = document.querySelector(".search-box__input__text-field") as HTMLInputElement
const resultsElement = document.querySelector('.search-box__results') as HTMLDivElement

let timeoutId = -1;

function searchSongs(query: string) {
    fetch(`/search/${query}`).then((response: Response) => {
        return response.json()
    }).then((data) => {
        console.log(data)
        displayResults(data)
    }).catch((error) => {
        console.log(error)
    })
}

function displayResults(results: any) {
    resultsElement.innerHTML = ''

    results.forEach((result) => {
        const splitterElement = document.createElement('div')
        splitterElement.classList.add('search-box-splitter')
        const resultElement = document.createElement('div')
        resultElement.classList.add('search-result')
        const image = document.createElement('img')
        image.classList.add('search-result__image')
        image.src = result['image_url']

        const songInfoDivElement = document.createElement('div')
        songInfoDivElement.classList.add('search-result__artist-info')

        const songNameElement = document.createElement('span')
        songNameElement.classList.add('search-result__artist-info__song')
        songNameElement.innerHTML = result['title']
        const artistNameElement = document.createElement('span')
        artistNameElement.classList.add('search-result__artist-info__name')
        artistNameElement.innerHTML = result['artist']

        songInfoDivElement.append(songNameElement)
        songInfoDivElement.append(artistNameElement)

        resultElement.append(image)
        resultElement.append(songInfoDivElement)

        resultsElement.append(splitterElement)
        resultsElement.append(resultElement)
    })
}

searchBox.addEventListener('input', (evt: Event) => {
    if (timeoutId !== -1) clearTimeout(timeoutId)
    timeoutId = setTimeout(() => {
        searchSongs(searchBox.value)
    }, 0)
    console.log(evt.currentTarget)
})