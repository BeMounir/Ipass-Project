class OrderService {
    static addOrder(order) {
        const url = `restservices/orders`;
        const options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(order),
        };

        return fetch(url, options)
            .then((response) => {
                if (!response.ok) {
                    throw new Error(response.status);
                }
                return response.json();
            });
    }

    static getOrder() {
        const url = `restservices/orders`;
        return fetch(url)
            .then((response) => response.json());
    }

    static getHuis(productId) {
        const url = `restservices/orders/${productId}`;
        return fetch(url)
            .then((response) => {
                return response.json();
            });
    }

    static updateOrders(order) {
        const url = `restservices/orders/${order.order}`;
        const options = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json;charset=utf-8',
            },
            body: JSON.stringify(order),
        }

        return fetch(url, options)
            .then((response) => {
                if (!response.ok) {
                    throw new Error(response.status);
                }
                return response.json();
            });

    }

    deleteOrder(order) {
        const url = `restservices/orders/${order.orderId}`;
        const options = {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json;charset=utf-8',
            },
        }

        return fetch(url, options)
            .then((response) => {
                if (!response.ok) {
                    throw new Error(response.status);
                }
                return response.json();
            });
    }
}