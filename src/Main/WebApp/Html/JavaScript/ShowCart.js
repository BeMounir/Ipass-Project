let cartItems = [];
let totalPrice = 0;

function displayCartItems() {
    const cartItemsElement = document.getElementById("CartItems");
    cartItemsElement.innerHTML = "";

    for (let i = 0; i < cartItems.length; i++) {
        const item = cartItems[i];

        const listItem = document.createElement("li");
        listItem.textContent = `Product ID: ${item.productId}, Price: €${item.price}`;

        cartItemsElement.appendChild(listItem);
    }
}

function displayTotalPrice() {
    const totalAmountElement = document.getElementById("TotalAmount");
    totalAmountElement.textContent = `€${totalPrice}`;
}

displayCartItems();
displayTotalPrice();