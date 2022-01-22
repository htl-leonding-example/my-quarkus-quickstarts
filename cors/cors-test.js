function test() {
    console.log("cors-test");

    // https://adambien.blog/roller/abien/entry/quarkus_cors_and_missing_http
//    const sendPost = async  _ => {
//        const response = await fetch("http://localhost:8080/hello", {
//            method: 'GET'
//        });
//        const body = response.text();
//        console.log('body: ',body);
//    }
//
//    sendPost();

    fetch('http://localhost:8080/hello')
    .then(response => response.text())
    .then(body => {console.log(body)})
}

