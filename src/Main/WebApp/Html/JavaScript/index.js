class ProductService {

    static addProduct(product) {
        const url = `restservices/products`;
        const options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(product),
        };

        return fetch(url, options)
            .then((response) => {
                if (!response.ok) {
                    throw new Error(response.status);
                }
                return response.json();
            });
    }

    static getProduct() {
        const url = `/restservices/products`;
        return fetch(url)
            .then((response) => response.json());
    }

    static getHuis(productId) {
        const url = `restservices/products/${productId}`;
        return fetch(url)
            .then((response) => {
                return response.json();
            });
    }

    static updateProduct(product) {
        const url = `restservices/products/${product.productId}`;
        const options = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json;charset=utf-8',
            },
            body: JSON.stringify(product),
        }

        return fetch(url, options)
            .then((response) => {
                if (!response.ok) {
                    throw new Error(response.status);
                }
                return response.json();
            });

    }

    deleteProduct(product) {
        const url = `restservices/products/${product.productId}`;
        const options = {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
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
window.addEventListener("DOMContentLoaded", updateCartItemCount);
