window.addEventListener("DOMContentLoaded", displayShoppingCart);

function displayShoppingCart() {
    // Retrieve shopping cart from local storage
    const shoppingCart = JSON.parse(localStorage.getItem("shoppingCart")) || [];

    // Get the table element
    const cartTable = document.getElementById("cartTable");

    // Clear the table body
    cartTable.innerHTML = "";

    // Iterate over each product in the shopping cart
    shoppingCart.forEach((product) => {
        // Create a new row
        const row = document.createElement("tr");

        // Create cells for product details
        const productCell = document.createElement("td");
        productCell.textContent = product.name;

        const descriptionCell = document.createElement("td");
        descriptionCell.textContent = product.description;

        const priceCell = document.createElement("td");
        priceCell.textContent = product.price;

        // Append cells to the row
        row.appendChild(productCell);
        row.appendChild(descriptionCell);
        row.appendChild(priceCell);

        // Append the row to the table
        cartTable.appendChild(row);
    });
}