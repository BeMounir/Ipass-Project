function checkout() {
    const name = document.getElementById("name").value;
    const address = document.getElementById("address").value;
    const email = document.getElementById("email").value;
    const shoppingCart = JSON.parse(localStorage.getItem("shoppingCart")) || [];

    let totalPrice = 0;
    shoppingCart.forEach((product) => {
        totalPrice += parseFloat(product.price);
    });

    const orderId = generateOrderId();

    const order = {
        orderId: orderId,
        date: new Date().toLocaleDateString(),
        totalPrice: totalPrice
    };

    const orderHistory = JSON.parse(localStorage.getItem("orderHistory")) || [];
    orderHistory.push(order);
    localStorage.setItem("orderHistory", JSON.stringify(orderHistory));

    localStorage.removeItem("shoppingCart");

    alert("Bedankt voor de aankoop! Order ID: " + orderId);

    window.location.href = "BestelGeschiedenis.html";
}

function generateOrderId() {
    const orderHistory = JSON.parse(localStorage.getItem("orderHistory")) || [];
    if (orderHistory.length === 0) {
        return 1;
    } else {
        const lastOrder = orderHistory[orderHistory.length - 1];
        return lastOrder.orderId + 1;
    }
}