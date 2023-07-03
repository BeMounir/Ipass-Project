function addToCart(productId, name, description, price) {
    const product = {
        productId: productId,
        name: name,
        description: description,
        price: price
    };

    const shoppingCart = JSON.parse(localStorage.getItem("shoppingCart")) || [];

    shoppingCart.push(product);

    localStorage.setItem("shoppingCart", JSON.stringify(shoppingCart));

    const aantalItemsElement = document.getElementById("AantalItems");
    const itemCount = parseInt(aantalItemsElement.textContent);
    aantalItemsElement.textContent = itemCount + 1;

    alert("Product Toegevoegd!");

    calculateTotalPrice();
}

