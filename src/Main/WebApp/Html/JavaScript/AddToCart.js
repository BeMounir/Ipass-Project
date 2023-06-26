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

    alert("Product added to cart!");
}