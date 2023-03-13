
let token = document.querySelector("meta[name='_csrf']").content;
let header = document.querySelector("meta[name='_csrf_header']").content;

const data = { username: 'example' };

let result = fetch("localhost8080:/campingHome/boards/new", {
    method : 'post',
    headers: {
        'Content-Type': 'application/json',
        header:token
    },
    body: JSON.stringify(data),
})
result.then(function(response) {
    console.log('response', response)
    console.log('header', response.headers.get('Content-Type'))
    return response.text()
}).then(function(text) {
    console.log('got text', text)
}).catch(function(ex) {
    console.log('failed', ex)
});
