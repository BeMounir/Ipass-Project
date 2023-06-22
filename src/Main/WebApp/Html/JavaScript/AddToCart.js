let cartItems = [];
let totalPrice = 0;

function addToCart(productId, price) {
    const product = {
        productId: productId,
        price: price
    };

    cartItems.push(product);

    totalPrice += price;

    document.getElementById("AantalItems").textContent = cartItems.length;

    alert("Product added to cart!");
}

function incrementItemCount() {
    let itemCountElement = document.getElementById("AantalItems");
    let itemCount = parseInt(itemCountElement.innerHTML);
    itemCountElement.innerHTML = itemCount + 1;

    addItemToCart(productId, name, price);
}

function addItemToCart(productId, name, price) {
    let cartItem = document.createElement("div");
    cartItem.classList.add("cart-item");

    cartItem.innerHTML = `
        <img src="../Images/schoen4.png" alt="${name}">
        <div class="details">
            <h3>${name}</h3>
            <p>Price: $${price}</p>
            <p>Quantity: 1</p>
        </div>
        <div class="price">$${price}</div>
    `;

    let cartContainer = document.getElementById("cart-items");

    cartContainer.appendChild(cartItem);
}