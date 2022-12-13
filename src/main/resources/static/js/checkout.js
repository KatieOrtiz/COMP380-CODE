let ShoppingCart = document.getElementById("shopping-cart");
        let checkout = document.getElementById("checkout-page");
    
        // console.log(shopItemsData);
    
        /**
         * ! Basket to hold all the selected items
         * ? the getItem part is retrieving data from the local storage
         * ? if local storage is blank, basket becomes an empty array
         */
    
        let basket = JSON.parse(localStorage.getItem("data")) || [];
    
        /**
         * ! To calculate total amount of selected Items
         */
        let calculation = () => {
          let cartIcon = document.getElementById("cartAmount");
          cartIcon.innerHTML = basket.map((x) => x.item).reduce((x, y) => x + y, 0);
        };
    
        calculation();
     
        /**
         * ! Generates the Cart Page with product cards composed of
         * ! images, title, price, buttons, & Total price
         * ? When basket is blank -> show's Cart is Empty
         */
    
         let generateCartItems = () => {
          if (basket.length !== 0) {
          return (checkout.innerHTML = basket
            .map((x) => {
            let { id, item } = x;
            let search = shopItemsData.find((x) => x.id === id) || [];
            let { img, price, shipping, name } = search;
            return `
            <div class="head" id="head">
              <table>
                <tr>
                  <td>
                    <div class="item-info">
                      <img width=200px src=${img} alt="">
                      <div>
                        <p>${name}</p>
                        <p>$ ${price}</p>
                        <p>Shipping: $ ${shipping}</p>
                      </div>
                    </div>
                  </td>
                  <td>
                    <div class="quantity-info">
                      ${item}
                    </div>  
                  </td>
                  <td>$ ${(item * price)}</td>
                </tr>
              </table>
            </div>
          `;
          })
          .join(""));
      } 
    };

    generateCartItems();

    let subtotalAmount = () => {
      if (basket.length !== 0) {
        let amount = basket
          .map((x) => {
            let { id, item } = x;
            let filterData = shopItemsData.find((x) => x.id === id);
            var total = (filterData.price * item);
            return total;
          })
          .reduce((x, y) => x + y, 0);

        return (subtotal.innerHTML = `
        <br>
          <p>
            <span>Items: </span>
            <span>$ ${amount}</span>
          </p>
    

        `);
      } else return;
    };

    subtotalAmount();

    let ShippingAmount = () => {
      if (basket.length !== 0) {
        let amount = basket
          .map((x) => {
            let { id, item } = x;
            let filterData = shopItemsData.find((x) => x.id === id);
            var total = filterData.shipping;
            return total;
          })
          .reduce((x, y) => x + y, 0);

        return (shipping.innerHTML = `
        
        <p>
          <span>Shipping: </span>
          <span>$ ${amount}</span>
        </p> 

        `);
      } else return;
    };

    ShippingAmount();

    const round = (value, digits) => {
      const factor = Math.pow(10, digits);
      value += math.sign(value) + Number.EPSILON;
      return Math.round(value * factor) / factor;
    }
    
    let TotalAmount = () => {
      if (basket.length !== 0) {
        let amount = basket
          .map((x) => {
            let { id, item } = x;
            let filterData = shopItemsData.find((x) => x.id === id);
            var total = (filterData.price * item) + filterData.shipping;
            var result = Math.round(total*100)/100;
            // return total;
            return result;
          })
          .reduce((x, y) => x + y, 0);

        return (total.innerHTML = `
        <br>
        <p>
          <span>Total: </span>
          <span>$ ${amount}</span>
        </p> 

        `);
      } else return;
    };

    TotalAmount();


        //This function asks the customer to confirm that they want to place their order
        function confirmationFunction() {
          if (confirm("Press OK to place your order!")) {
            orderPlaced();

            let clearCart = () => {
              basket = [];
              generateCartItems();
              calculation();
              localStorage.setItem("data", JSON.stringify(basket));
            };
          clearCart();
          } else {
            
          }
        }

        //This function confirms that the order was placed successfully, sends the email confirmation with order details, and redirects the user to the home page
        function orderPlaced() {
          alert("Your order was placed successfully!") //Windows displays to tell customer that their order was successfully placed
          location.href="mailto:katie_kns@yahoo.com?subject=Order%20Confirmation&body=Dear%20Customer%2C%0D%0A%0D%0AThis%20is%20your%20confirmation%20receipt%20for%20the%20order%20you've%20placed%20on%20the%20CODE%20website!%20If%20you%20would%20like%20to%20track%20your%20order%2C%20the%20order%20number%20is%20101.%0D%0A%0D%0ASincerely%2C%0D%0AThe%20CODE%20Store%20Team"; //Email template opens in user's email app 
          //window.open('email'); //New tab opens and order confirmation is displayed
          location.href = "/home"; //Customer is redirected to home on the original tab
        }
        