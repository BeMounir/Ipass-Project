function login(event) {
    event.preventDefault();

    let formData = new FormData(document.querySelector("#loginForm"));
    let jsonRequestBody = {};
    formData.forEach((value, key) => jsonRequestBody[key] = value);

    fetch("restservices/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(jsonRequestBody)
    })
        .then(function (response) {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error("Wrong username/password");
            }
        })
        .then(function (data) {
            window.sessionStorage.setItem("myJWT", data.JWT);
            window.location.href = "Home.html";
        })
        .catch(function (error) {
            console.log(error);
        });
}

document.querySelector("#login").addEventListener("click", login);