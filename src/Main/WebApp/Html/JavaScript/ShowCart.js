window.onload = () => {
    displayShoppingCart();
    calculateTotalPrice();

}
function displayShoppingCart() {
    const shoppingCart = JSON.parse(localStorage.getItem("shoppingCart")) || []
    const cartTable = document.getElementById("cartTable");

    cartTable.innerHTML = "";

    shoppingCart.forEach((product) => {
        const row = document.createElement("tr");

        const productCell = document.createElement("td");
        productCell.textContent = product.name;

        const descriptionCell = document.createElement("td");
        descriptionCell.textContent = product.description;

        const priceCell = document.createElement("td");
        priceCell.textContent = product.price;

        row.appendChild(productCell);
        row.appendChild(descriptionCell);
        row.appendChild(priceCell);

        cartTable.appendChild(row);
    });
}
function calculateTotalPrice() {
    const shoppingCart = JSON.parse(localStorage.getItem("shoppingCart")) || [];

    let totalPrice = 0;

    shoppingCart.forEach((product) => {
        totalPrice += parseFloat(product.price);
    });

    const totalPriceElement = document.getElementById("totalPrice");
    totalPriceElement.textContent = "$" + totalPrice.toFixed(2);
}


function clearCart() {
    localStorage.removeItem("shoppingCart");
    displayShoppingCart();
    calculateTotalPrice();
}