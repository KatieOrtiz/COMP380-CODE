let ShoppingCart = document.getElementById("shopping-cart");
    let label = document.getElementById("label");

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
   //creates each item card and displays the relevant details for each specific item
     let generateCartItems = () => {
      if (basket.length !== 0) {
        return (ShoppingCart.innerHTML = basket
          .map((x) => {
            let { id, item } = x;
            let search = shopItemsData.find((x) => x.id === id) || [];
            let { img, price, shipping, name } = search;
            return `
          <div class="cart-item">
            <img width="250px" src=${img} alt="" />

            <div class="details">
            
              <div class="title-price-x">
                <h4 class="title-price">
                  <p>${name}</p>
                  <p class="cart-item-price">$${price}</p>
                  <p class="cart-item-price">$${shipping}</p>
                </h4>
                <i onclick="removeItem(${id})" class="bi bi-x-lg fa-lg"></i>
              </div>

              <div class="cart-buttons">
                <div class="buttons">
                  <i onclick="decrement(${id})" class="bi bi-dash-lg fa-lg"></i>
                  <div id=${id} class="cart-quantity">${item}</div>
                  <i onclick="increment(${id})" class="bi bi-plus-lg fa-lg"></i>
                </div>
              </div>

              <h3>$ ${(item * price) + shipping}</h3>
            
            </div>
          </div>
          `;
          })
          .join(""));
      } else {
        ShoppingCart.innerHTML = "";
        label.innerHTML = `
        <h2 style="color:white;">Cart is Empty</h2>
        <a href="/home">
          <button class="HomeBtn">Back to Home</button>
        </a>
        `;
      }
    };

    generateCartItems();

    /**
     * ! used to increase the selected product item quantity by 1
     */

    //increments the quantity of the specific item in the cart
    let increment = (id) => {
      let selectedItem = id;
      let search = basket.find((x) => x.id === selectedItem.id);

      if (search === undefined) {
        basket.push({
          id: selectedItem.id,
          item: 1,
        });
      } else {
        search.item += 1;
      }

      generateCartItems();
      update(selectedItem.id);
      localStorage.setItem("data", JSON.stringify(basket));
    };

    /**
     * ! used to decrease the selected product item quantity by 1
     */
    
    //decreases the quantity of the specific item in the cart
    let decrement = (id) => {
      let selectedItem = id;
      let search = basket.find((x) => x.id === selectedItem.id);

      if (search === undefined) return;
      else if (search.item === 0) return;
      else {
        search.item -= 1;
      }

      update(selectedItem.id);
      basket = basket.filter((x) => x.item !== 0);
      generateCartItems();
      localStorage.setItem("data", JSON.stringify(basket));
    };

    /**
     * ! To update the digits of picked items on each item card
     */

    let update = (id) => {
      let search = basket.find((x) => x.id === id);
      document.getElementById(id).innerHTML = search.item;
      calculation();
      TotalAmount();
    };

    /**
     * ! Used to remove 1 selected product card from basket
     * ! using the X [cross] button
     */

    let removeItem = (id) => {
      let selectedItem = id;
      basket = basket.filter((x) => x.id !== selectedItem.id);
      calculation();
      generateCartItems();
      TotalAmount();
      localStorage.setItem("data", JSON.stringify(basket));
    };

    /**
     * ! Used to calculate total amount of the selected Products
     * ! with specific quantity
     * ? When basket is blank, it will show nothing
     */

    let TotalAmount = () => {
      if (basket.length !== 0) {
        let amount = basket
          .map((x) => {
            let { id, item } = x;
            let filterData = shopItemsData.find((x) => x.id === id);
            return (filterData.price * item) + filterData.shipping ;
          })
          .reduce((x, y) => x + y, 0);

        return (label.innerHTML = `
        <br><br>
        <h2 style="color:white;">Subtotal : $ ${amount}</h2>
        <a href="/payment">
          <button class="checkout">Checkout</button>
        </a>
        <br><br>
        <button onclick="clearCart()" class="removeAll">Clear Cart</button>
        `);
      } else return;
    };

    TotalAmount();

    /**
     * ! Used to clear cart, and remove everything from local storage
     */

    let clearCart = () => {
      basket = [];
      generateCartItems();
      calculation();
      localStorage.setItem("data", JSON.stringify(basket));
    };
    