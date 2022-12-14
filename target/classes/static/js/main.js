    // When the user clicks on <div>, open the popup
    function pop1() {
        var popup = document.getElementById("pop1");
        popup.classList.toggle("show");
      }
  
      function pop2() {
        var popup = document.getElementById("pop2");
        popup.classList.toggle("show");
      }
  
      function pop3() {
        var popup = document.getElementById("pop3");
        popup.classList.toggle("show");
      }
  
      function pop4() {
        var popup = document.getElementById("pop4");
        popup.classList.toggle("show");
      }
  
        
    // Use to target <div class="shop" id="shop">
    let shop = document.getElementById("shop");

    console.log(shop);

    let basket = JSON.parse(localStorage.getItem("data")) || [];
    
    //creates each item card and displays the relevant details for each specific item
    let generateShop = () => {
      return (shop.innerHTML= shopItemsData.map((x)=>{
        let {id, name, price, desc, details, img} = x;
        let search = basket.find((x)=>x.id === id) || []; // || ->  or return nothing
        return `
        <div class="column">
          <div class="card">
            <div id=product-id-${id} class="item">
              <img src= ${img} alt="Avatar" style="width:100%">
              <h4 style="font-family: MV Boli;"><b>${name}</b></h4> 
              <p style="font-family: MV Boli;">${desc}</p>
              <p>$${price}</p> 
              <div>
                <details>
                  <summary style="font-family: MV Boli;"><b>Click here for item details</b></summary>
                  <p>${details}</p>
                </details>
              </div>
          
              <br><br>
              <div class="addCartButton">
                <button class="button" onclick="increment(${id})">Add to Cart</button>
                <div id=${id} class="quantity">
                  ${search.item === undefined ? 0 : search.item}
                </div>
              </div>
            </div>
          </div>
        </div>
      `;
      })
      .join(""));
    };
 

    generateShop();
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
      localStorage.setItem("data", JSON.stringify(basket));
      // console.log(basket);
      update(selectedItem.id);
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
      console.log(basket);
      localStorage.setItem("data", JSON.stringify(basket));
    };
    /**
      * ! To update the digits of picked items on each item card
    */
    let update = (id) => {
      let search = basket.find((x) => x.id === id);
      // console.log(search); // This function gives "id: " and "item: "
      // console.log(search.item);
      document.getElementById(id).innerHTML = search.item; // reference to: <div id=${id} class="quantity">0</div>
      calculation();
    };
    /**
       * ! To calculate total amount of selected Items
    */

    let calculation = () => {
      let cartIcon = document.getElementById("cartAmount");
      cartIcon.innerHTML = basket.map((x) => x.item).reduce((x, y) => x + y, 0);
    };

    // Every time application loads, calculation() will run regardless
    // Prevent un-updated item amount on cart-icon will page gets refresh
    calculation();