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

let generateCartItems = () => {
  if(basket.length !== 0) {
    console.log("Items in basket");
    return (ShoppingCart.innerHTML = basket
      .map((x)=>{ // object: x targets id in local storage
        console.log(x);
        let {id,item} = x; // x = basket 
        // y = shopItemsData, to match id in basket with id in shopItemsData
        // y.id is from shopItemsData & id is from x or basket
        let search = shopItemsData.find((y)=>y.id === id) || [];
        return `
       
              <h4>
                <label>${search.name}</label>
                <label>$ ${search.price}</label>     
                <label id=${id} class="quantity">
                 
                </label>
              </h4>        

        `;
    }).join(""));
  }
  else {
    console.log("Empty basket");
    ShoppingCart.innerHTML = "";
    label.innerHTML = `
    <h2>Cart is Empty</h2>
    <a href="/home">
      <button class="HomeBtn">Back to Home</button>
    </a>
    `;
  }
};

generateCartItems();

